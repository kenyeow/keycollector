package com.keycollector;

import javax.swing.*;

/**
 * Created by Yeow Wan Shung
 * **/

public class Square extends JButton {

    private boolean playerOccupy = false;
    private boolean keyOccupy = false;
    private Player player = null;
    private Key key = null;
    private Icon keyIcon = null;
    private Icon playerIcon = null;

    public Square(){
        super();
        addActionListener(new Movement());
    }

    public void setPlayer(Player player){
        this.player = player;
        playerOccupy = true;
        playerIcon = player.getIcon();
        setIcon(playerIcon);
    }

    public void removePlayer(){
        this.player = null;
        playerOccupy = false;
        playerIcon = null;
        setIcon(keyIcon);
    }

    public void setKey(Key key){
        this.key = key;
        keyOccupy = true;
        keyIcon = key.getIcon();
        setIcon(keyIcon);
    }

    public Key getKey(){
        return key;
    }

    public boolean isPlayerOccupy(){
        return playerOccupy;
    }

    public boolean isKeyOccupy() {
        return keyOccupy;
    }

}
