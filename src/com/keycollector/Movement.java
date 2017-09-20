package com.keycollector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Created by Yeow Wan Shung, Fam Xuan Deng
 * Movement class is an ActionListener class for square class
 * It is responsible for movement of the player.
 * It checks the restriction of the player based on their key collection.
 * It also performs movement for the player to selected position if it is not restricted.
 * **/
public class Movement implements ActionListener {

    private int moveToRow, moveToColumn;
    private int oriRow, oriColumn;
    private Square squareClicked;

    private boolean checkRestriction(Player player){
        boolean ableToMove;
        Key playerLastKey = player.getLastKey();

        if(squareClicked.hasTreasureChest()){
            if(!Gameplay.playerHasAllKey(player)){
                return false;
            }
        }

        if(playerLastKey == null){
            return normalRestriction();
        }

        int ableToMoveVertical = playerLastKey.
                getMovementRestriction().getAbleToMoveVertical();
        int ableToMoveHorizontal = playerLastKey.
                getMovementRestriction().getAbleToMoveHorizontal();
        int ableToMoveDiagonal = playerLastKey.
                getMovementRestriction().getAbleToMoveDiagonal();

        ableToMove = (checkDirection(moveToRow, oriRow, ableToMoveVertical) &&
                checkDirection(moveToColumn, oriColumn, ableToMoveHorizontal)) ||
                checkDiagonal(moveToRow, moveToColumn, oriRow, oriColumn, ableToMoveDiagonal);
        return ableToMove;
    }

    private boolean normalRestriction(){
        return (checkDirection(moveToRow, oriRow, 2) &&
                checkDirection(moveToColumn, oriColumn, 2)) ||
                checkDiagonal(moveToRow, moveToColumn, oriRow, oriColumn, 2);
    }

    private boolean checkDirection(int moveToPos, int oriPos,
                                    int ableToMovePos){
        if((moveToRow - oriRow) != (moveToColumn - oriColumn)){
            if((moveToRow - oriRow == 0) || (moveToColumn - oriColumn) == 0){
                if(moveToPos <= (oriPos + ableToMovePos)
                        && moveToPos >= (oriPos - ableToMovePos)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(int moveToRow, int moveToColumn, int oriRow,
                                  int oriColumn, int ableToMoveDiagonal){
        if((moveToRow - oriRow) == (moveToColumn - oriColumn)){
            if((moveToRow > oriRow && moveToColumn > oriColumn)){
                if((moveToRow <= (oriRow + ableToMoveDiagonal) &&
                        moveToColumn <= (oriColumn + ableToMoveDiagonal))){
                    return true;
                }
            }

            if((moveToRow < oriRow && moveToColumn < oriColumn)){
                if(moveToRow >= (oriRow - ableToMoveDiagonal) &&
                        moveToColumn >= (oriColumn - ableToMoveDiagonal)){
                    return true;
                }
            }
        }

        if((moveToRow - oriRow) == (oriColumn - moveToColumn)){
            if((moveToRow < oriRow && moveToColumn > oriColumn)){
                if(moveToRow >= (oriRow - ableToMoveDiagonal) &&
                        moveToColumn <= (oriColumn + ableToMoveDiagonal)){
                    return true;
                }
            }

            if((moveToRow > oriRow && moveToColumn < oriColumn)){
                if(moveToRow <= (oriRow + ableToMoveDiagonal) &&
                        moveToColumn >= (oriColumn - ableToMoveDiagonal)){
                    return true;
                }
            }
        }

        return false;
    }

    private void makeMove(Player currentPlayer){
        Gameplay.removePlayerFromSquare(oriRow, oriColumn);
        currentPlayer.setPostion(moveToRow, moveToColumn);
        squareClicked.setPlayer(currentPlayer);

        if(isSquareOccupiedByKey()){
            currentPlayer.addKey(squareClicked.getKey());
            KeyCollectorBoard.updateSideBoard(currentPlayer);
        }
    }

    private void checkWinStatus(Player player){
        if(squareClicked.hasTreasureChest()){
            if(Gameplay.playerHasAllKey(player)){
                JOptionPane.showMessageDialog(null
                        , "Player " +
                                (Arrays.asList(Gameplay.getPlayer()).indexOf(player) + 1) +
                                " has won the game! Congratulations",
                        "You WON", ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    private boolean isSquareOccupiedByPlayer(){
        return squareClicked.isPlayerOccupy();
    }

    private boolean isSquareOccupiedByKey() { return squareClicked.isKeyOccupy(); }

    @Override
    public void actionPerformed(ActionEvent e) {
        squareClicked = (Square) e.getSource();

        moveToRow = Integer.parseInt(squareClicked.getClientProperty("row").toString());
        moveToColumn = Integer.parseInt(squareClicked.getClientProperty("column").toString());

        Player currentPlayer = Gameplay.getCurrentPlayer();
        oriRow = currentPlayer.getCurrentRow();
        oriColumn = currentPlayer.getCurrentColumn();

        if(checkRestriction(currentPlayer) && !isSquareOccupiedByPlayer()) {
            makeMove(currentPlayer);
            checkWinStatus(currentPlayer);
            Gameplay.nextPlayer(currentPlayer);
            return;
        }

        JOptionPane.showMessageDialog(null,
                "You just made an invalid move!",
                "Invalid Move",
                ERROR_MESSAGE);
    }
}
