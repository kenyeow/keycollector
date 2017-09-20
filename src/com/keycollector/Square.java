package com.keycollector;

import javax.swing.*;

/**
 * Created by Tan Di Xiang, Chiaw Pang Yee
 * Square class is a JButton in KeyCollectorBoard
 * Each square responsible for set player, remove player,
 *      add key and remove key.
 * It also contain method to check if the square is occupied by Player or Key.
 * **/

public class Square extends JButton {

    private boolean playerOccupy = false;
    private boolean keyOccupy = false;
    private Player player = null;
    private Key key = null;
    private TreasureChest treasureChest = null;
    private Icon keyIcon = null;
    private Icon playerIcon = null;
    private Icon treasureChestIcon = null;

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

    public void setTreasureChest(TreasureChest treasureChest){
        this.treasureChest = treasureChest;
        this.treasureChestIcon = treasureChest.getIcon();
    }

    public boolean hasTreasureChest(){
        return treasureChest != null;
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
