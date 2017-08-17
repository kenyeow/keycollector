package com.keycollector;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Creted by Yeow Wan Shung
 * To load image from resources
 * **/

public class GameImage {

    final ImageIcon banGei;
    final ImageIcon arkImides;
    final ImageIcon canSer;
    final ImageIcon dozCiztem;

    final ImageIcon pinkey;
    final ImageIcon donkey;
    final ImageIcon keyDisk;
    final ImageIcon keyNote;
    final ImageIcon monkey;

    final ImageIcon treasureChest;

    public GameImage(){
        banGei = new ImageIcon("icons/1.gif");
        arkImides = new ImageIcon("icons/2.gif");
        canSer = new ImageIcon("icons/3.gif");
        dozCiztem = new ImageIcon("icons/4.gif");

        pinkey = new ImageIcon("icons/a.gif");
        donkey = new ImageIcon("icons/b.gif");
        keyDisk = new ImageIcon("icons/c.gif");
        keyNote = new ImageIcon("icons/d.gif");
        monkey = new ImageIcon("icons/e.gif");

        treasureChest = new ImageIcon("icons/5.gif");
    }

}
