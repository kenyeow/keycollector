package com.keycollector;

import javax.swing.*;

public final class Player{

    private ImageIcon icon;
    private int currentRow;
    private int currentColumn;

    public Player(ImageIcon icon, int row, int column){
        this.icon = icon;
        this.currentRow = row;
        this.currentColumn = column;
    }

    public ImageIcon getIcon(){
        return icon;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setPostion(int row, int coloumn){
        currentRow = row;
        currentColumn = coloumn;
    }
}
