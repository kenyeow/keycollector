package com.keycollector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *  Created by Yeow Wan Shung
 *
 * **/
public class KeyCollectorBoard {

    private JButton jButton[][] = new JButton[9][9];
    private JLabel jLabel[][] = new JLabel[4][6];
    final int NUMBER_OF_KEYS = 5;

    public KeyCollectorBoard(){
        initializeGui();
    }

    // set up the main gui
     public final void initializeGui() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(new Dimension(1100,600));
        jFrame.setLayout(new BorderLayout());

        /** Game Board **/
        GridLayout gameBoard = new GridLayout(9,9);

        GameImage gameImage = new GameImage();

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(gameBoard);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                jButton[i][j] = new JButton();
                gamePanel.add(jButton[i][j]);
            }
        }
        initializeGameBoard(gameImage);

        /** SideBoard **/
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(new Dimension(500,600));
        infoPanel.setLayout(new GridLayout(4,6));
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j ++){
                jLabel[i][j] = new JLabel();
                infoPanel.add(jLabel[i][j]);
            }
        }
        initializeSideBoard(gameImage);

        jFrame.add(gamePanel,BorderLayout.WEST);
        jFrame.add(infoPanel,BorderLayout.EAST);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeGameBoard(GameImage gameImage){
        jButton[0][0].setIcon(gameImage.getPlayerIcon(0));
        jButton[0][8].setIcon(gameImage.getPlayerIcon(1));
        jButton[8][0].setIcon(gameImage.getPlayerIcon(2));
        jButton[8][8].setIcon(gameImage.getPlayerIcon(3));

        jButton[4][4].setIcon(gameImage.getTreasureChest());

        randomizeKey();
    }

    private void initializeSideBoard(GameImage gameImage){
        jLabel[0][0].setIcon(gameImage.getPlayerIcon(0));
        jLabel[1][0].setIcon(gameImage.getPlayerIcon(1));
        jLabel[2][0].setIcon(gameImage.getPlayerIcon(2));
        jLabel[3][0].setIcon(gameImage.getPlayerIcon(3));
    }

    private void randomizeKey(){
        ArrayList<Integer> row = new ArrayList<>(NUMBER_OF_KEYS);
        ArrayList<Integer> column = new ArrayList<>(NUMBER_OF_KEYS);

        row = RandomNumberUtils.addRandomNumberToArrayList(row, jButton.length - 1, NUMBER_OF_KEYS);
        column = RandomNumberUtils.addRandomNumberToArrayList(column, jButton.length - 1, NUMBER_OF_KEYS);

        for(int i = 0; i < NUMBER_OF_KEYS; i++){
            jButton[row.get(i)][column.get(i)].setIcon(new GameImage().getKeyIcon(i));
        }
    }
}
