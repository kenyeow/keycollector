package com.keycollector;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Tan Di Xiang, Chiaw Pang Yee
 * Player class contain information about player.
 * It contain player's current position (row and column).
 * It contain the collection of key by the player.
 * **/
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

    public ArrayList<Key> getKeyCollection() {
        return keyCollection;
    }

    public void addKey(Key key){
        if(!keyCollection.contains(key)){
            keyCollection.add(key);
        }
    }

    public Key getLastKey(){
        if(keyCollection.isEmpty()){
            return null;
        }

        return keyCollection.get(keyCollection.size() - 1);
    }
}
