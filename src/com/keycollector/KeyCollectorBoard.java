package com.keycollector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *  Created by Yeow Wan Shung
 *
 * **/
public class KeyCollectorBoard {

    private static Square squares[][] = new Square[9][9];
    private static JLabel jLabel[][] = new JLabel[4][6];
    private static JLabel toolBarInfo;

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
                squares[i][j] = new Square();
                squares[i][j].putClientProperty("row", i);
                squares[i][j].putClientProperty("column", j);
                gamePanel.add(squares[i][j]);
            }
        }
        initializeGameBoard(gameImage);

        /** SideBoard **/
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(new Dimension(500,600));
        infoPanel.setLayout(new GridLayout(4,6));
        for(int player = 0; player < 4; player++) {
            for(int key = 0; key < 6; key ++){
                jLabel[player][key] = new JLabel();
                infoPanel.add(jLabel[player][key]);
            }
        }
        initializeSideBoard(gameImage);

        JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolBarInfo = new JLabel();
        toolBar.add(toolBarInfo);

        jFrame.add(gamePanel,BorderLayout.WEST);
        jFrame.add(infoPanel,BorderLayout.EAST);
        jFrame.add(toolBar, BorderLayout.SOUTH);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeGameBoard(GameImage gameImage){
        squares[4][4].setIcon(gameImage.getTreasureChest());
    }

    public static Square[][] getSquares() {
        return squares;
    }

    private void initializeSideBoard(GameImage gameImage) {
        jLabel[0][0].setIcon(gameImage.getPlayerIcon(0));
        jLabel[1][0].setIcon(gameImage.getPlayerIcon(1));
        jLabel[2][0].setIcon(gameImage.getPlayerIcon(2));
        jLabel[3][0].setIcon(gameImage.getPlayerIcon(3));
    }

    public static void setToolBarInfo(String info){
        toolBarInfo.setText(info);
    }

}
