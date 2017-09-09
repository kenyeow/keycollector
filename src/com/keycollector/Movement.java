package com.keycollector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Movement implements ActionListener {

    Player currentPlayer;
    private int moveToRow, moveToColumn;
    private int oriRow, oriColumn;
    private Square squareClicked;

    private boolean checkRestriction(Player player){
        boolean ableToMove;
        Key playerLastKey = player.getLastKey();

        if(playerLastKey == null){
            return normalRestriction();
        }

        int ableToMoveVertical = playerLastKey.
                getMovementRestriction().getAbleToMoveVertical();
        int ableToMoveHorizontal = playerLastKey.
                getMovementRestriction().getAbleToMoveHorizontal();
        int ableToMoveDiagonal = playerLastKey.
                getMovementRestriction().getAbleToMoveDiagonal();

        ableToMove = checkDirection(moveToRow, oriRow, ableToMoveVertical) ||
        checkDirection(moveToColumn, oriColumn, ableToMoveHorizontal) ||
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

    @Override
    public void actionPerformed(ActionEvent e) {
        squareClicked = (Square) e.getSource();
        moveToRow = Integer.parseInt(squareClicked.getClientProperty("row").toString());
        moveToColumn = Integer.parseInt(squareClicked.getClientProperty("column").toString());
        System.out.println("Row " + moveToRow);
        System.out.println("Column " + moveToColumn);

        currentPlayer = Gameplay.getCurrentPlayer();
        oriRow = currentPlayer.getCurrentRow();
        oriColumn = currentPlayer.getCurrentColumn();
        if(checkRestriction(currentPlayer))
        {
            Gameplay.removePlayerFromSquare(oriRow, oriColumn);
            currentPlayer.setPostion(moveToRow, moveToColumn);
            squareClicked.setPlayer(currentPlayer);
            currentPlayer = Gameplay.nextPlayer();
        }
        else
        {
            System.out.println("Invalid Movement");
        }


    }
}
