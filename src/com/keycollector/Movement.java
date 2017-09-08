package com.keycollector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.SynchronousQueue;

public class Movement implements ActionListener {

    Player currentPlayer;
    private int row , column;
    private int oriRow, oriColumn;
    private Square squareClicked;

    private boolean moveRestriction(){

        if(row > oriRow + 2 || row < oriRow - 2)
        {
            return false;
        }
        else
        {
            if(column > oriColumn + 2 || column < oriColumn - 2)
            {
                return false;
            }
            else
            {
                if(squareClicked.isPlayerOccupy() == false)
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        squareClicked = (Square) e.getSource();
        row = Integer.parseInt(squareClicked.getClientProperty("row").toString());
        column = Integer.parseInt(squareClicked.getClientProperty("column").toString());
        System.out.println("Row " + row);
        System.out.println("Column " + column);

        currentPlayer = Gameplay.getCurrentPlayer();
        oriRow = currentPlayer.getCurrentRow();
        oriColumn = currentPlayer.getCurrentColumn();
        if(moveRestriction())
        {
            Gameplay.removePlayerFromSquare(oriRow, oriColumn);
            currentPlayer.setPostion(row, column);
            squareClicked.setPlayer(currentPlayer);
            currentPlayer = Gameplay.nextPlayer();
        }
        else
        {
            System.out.println("Invalid Movement");
        }


    }
}
