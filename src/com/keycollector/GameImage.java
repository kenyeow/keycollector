package com.keycollector;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Creted by Yeow Wan Shung
 * To load image from resources
 * **/

public class GameImage {

    private final ImageIcon treasureChest;
    private final ArrayList<ImageIcon> playerIcons;
    private final ArrayList<ImageIcon> keyIcons;

    public GameImage(){
        playerIcons = new ArrayList<>();
        playerIcons.add(new ImageIcon("icons/1.gif"));
        playerIcons.add(new ImageIcon("icons/2.gif"));
        playerIcons.add(new ImageIcon("icons/3.gif"));
        playerIcons.add(new ImageIcon("icons/4.gif"));

        keyIcons = new ArrayList<>();
        keyIcons.add(new ImageIcon("icons/a.gif"));
        keyIcons.add(new ImageIcon("icons/b.gif"));
        keyIcons.add(new ImageIcon("icons/c.gif"));
        keyIcons.add(new ImageIcon("icons/d.gif"));
        keyIcons.add(new ImageIcon("icons/e.gif"));

        treasureChest = new ImageIcon("icons/5.gif");
    }

    public ImageIcon getPlayerIcon(int position){
        return playerIcons.get(position);
    }

    public ImageIcon getKeyIcon(int position){
        return keyIcons.get(position);
    }

    public ImageIcon getTreasureChest() {
        return treasureChest;
    }
}
