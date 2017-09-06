package com.keycollector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Movement implements ActionListener {

    Player currentPlayer;

    //TODO: Add Restriction
    private boolean moveRestriction(){
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Square squareClicked = (Square) e.getSource();
        int row = Integer.parseInt(squareClicked.getClientProperty("row").toString());
        int column = Integer.parseInt(squareClicked.getClientProperty("column").toString());
        System.out.println("Row " + row);
        System.out.println("Column " + column);

        currentPlayer = Gameplay.getCurrentPlayer();
        int oriRow = currentPlayer.getCurrentRow();
        int oriColumn = currentPlayer.getCurrentColumn();
        Gameplay.removePlayerFromSquare(oriRow, oriColumn);

        currentPlayer.setPostion(row, column);
        squareClicked.setPlayer(currentPlayer);
    }
}
