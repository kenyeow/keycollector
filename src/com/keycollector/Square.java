package com.keycollector;

import javax.swing.*;

/**
 * Created by Yeow Wan Shung
 * **/

public class Square extends JButton {

    private boolean playerOccupy = false;
    private boolean keyOccupy;
    private Player player = null;
    private Key key = null;

    public Square(){
        super();
        addActionListener(new Movement());
    }

    public void setPlayer(Player player){
        this.player = player;
        playerOccupy = true;
        setIcon(player.getIcon());
    }

    public void removePlayer(){
        this.player = null;
        playerOccupy = false;
        setIcon(null);
    }

    public void setKey(Key key){
        this.key = key;
        keyOccupy = true;
        setIcon(key.getIcon());
    }

    public boolean isPlayerOccupy(){
        return playerOccupy;
    }

}
