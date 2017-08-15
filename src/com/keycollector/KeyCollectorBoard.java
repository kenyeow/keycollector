package com.keycollector;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 *  Created by Yeow Wan Shung
 *
 * **/
public class KeyCollectorBoard {

    private JButton jButton[][] = new JButton[9][9];

    public KeyCollectorBoard(){
        initializeGui();
    }

    // set up the main gui
    public final void initializeGui() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(800,600));

        /** Game Board **/
        GridLayout gameBoard = new GridLayout(9,9);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(gameBoard);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j ++){
                jButton[i][j] = new JButton();
                gamePanel.add(jButton[i][j]);
            }
        }

        initializeImage(new GameImage());

        /**
         * TODO: Add a info panel to how keys the player has collected.
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(new Dimension(300,600));
         **/

        jFrame.add(gamePanel);
        // jFrame.add(infoPanel);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeImage(GameImage gameImage){
        jButton[0][0].setIcon(gameImage.banGei);
        jButton[0][8].setIcon(gameImage.arkImides);
        jButton[8][0].setIcon(gameImage.canSer);
        jButton[8][8].setIcon(gameImage.dozCiztem);

        jButton[4][4].setIcon(gameImage.treasureChest);

        jButton[1][2].setIcon(gameImage.pinkey);
        jButton[3][6].setIcon(gameImage.monkey);
        jButton[6][3].setIcon(gameImage.donkey);
        jButton[7][2].setIcon(gameImage.keyDisk);
        jButton[7][6].setIcon(gameImage.keyNote);
    }

}
