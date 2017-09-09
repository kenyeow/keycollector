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
    private Icon icon = null;

    public Square(){
        super();
        addActionListener(new Movement());
    }

    public void setPlayer(Player player){
        this.player = player;
        playerOccupy = true;
        icon = player.getIcon();
        setIcon(icon);
    }

    public void removePlayer(){
        this.player = null;
        playerOccupy = false;
        icon = null;
        setIcon(icon);
    }

    public void setKey(Key key){
        this.key = key;
        keyOccupy = true;
        icon = key.getIcon();
        setIcon(icon);
    }

    public boolean isPlayerOccupy(){
        return playerOccupy;
    }

}
