package com.keycollector;

import javax.swing.*;
import java.util.ArrayList;

public final class Player{

    private ImageIcon icon;
    private int currentRow;
    private int currentColumn;
    private ArrayList<Key> keyCollection;

    public Player(ImageIcon icon, int row, int column){
        this.icon = icon;
        this.currentRow = row;
        this.currentColumn = column;
        keyCollection = new ArrayList();
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

    public void addKey(Key key){
        keyCollection.add(key);
    }

    public Key getLastKey(){
        if(keyCollection.isEmpty()){
            return null;
        }

        return keyCollection.get(keyCollection.size() - 1);
    }
}
