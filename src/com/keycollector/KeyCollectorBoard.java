package com.keycollector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *  Created by Yeow Wan Shung
 *
 * **/
public class KeyCollectorBoard {

    private static final int NUMBER_OF_KEY = 5;
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
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 6; j ++){
                jLabel[i][j] = new JLabel();
                infoPanel.add(jLabel[i][j]);
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
        initializeKeyInRandom();
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

    public void setToolBarInfo(String info){
        toolBarInfo.setText(info);
    }

    private void initializeKeyInRandom(){
        ArrayList<Integer> row = new ArrayList<>(NUMBER_OF_KEY);
        ArrayList<Integer> column = new ArrayList<>(NUMBER_OF_KEY);

        row = RandomNumberUtils.addRandomNumberToArrayList(row, squares.length - 2, NUMBER_OF_KEY);
        column = RandomNumberUtils.addRandomNumberToArrayList(column, squares.length - 2, NUMBER_OF_KEY);

        for(int i = 0; i < NUMBER_OF_KEY; i++){
            while (row.get(i).equals(4) && column.get(i).equals(4)){
                row.set(i, RandomNumberUtils.generateRandomNumber(squares.length - 2));
                column.set(i, RandomNumberUtils.generateRandomNumber(squares.length - 2));
            }

            squares[row.get(i)][column.get(i)].setIcon(new GameImage().getKeyIcon(i));
        }
    }
}
