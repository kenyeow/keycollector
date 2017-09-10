package com.keycollector;

import java.util.ArrayList;
import java.util.Arrays;

public class Gameplay {

    // TODO: player able to get key, player win game, fix oo principle.

    private static final int NUMBER_OF_KEY = 5;
    private static final int NUMBER_OF_PLAYER = 4;
    private static Player[] player = new Player[NUMBER_OF_PLAYER];
    private static Key[] key = new Key[NUMBER_OF_KEY];
    private static Player currentPlayer = null;
    private static Square[][] squares;

    public Gameplay(){
        GameImage gameImage = new GameImage();
        new KeyCollectorBoard();

        initializePlayer(gameImage);
        initializeKey(gameImage);
        initializeKeyInRandom();
        initializeGamePlay();
    }

    /**
     * initialize player and set the player initial position
     * add the initialized player into squares.
     * **/
    private void initializePlayer(GameImage gameImage){
        player[0] = new Player(gameImage.getPlayerIcon(0), 0, 0);
        player[1] = new Player(gameImage.getPlayerIcon(1), 0, 8);
        player[2] = new Player(gameImage.getPlayerIcon(2), 8, 0);
        player[3] = new Player(gameImage.getPlayerIcon(3), 8, 8);

        squares = KeyCollectorBoard.getSquares();
        squares[0][0].setPlayer(player[0]);
        squares[0][8].setPlayer(player[1]);
        squares[8][0].setPlayer(player[2]);
        squares[8][8].setPlayer(player[3]);
    }

    private void initializeKey(GameImage gameImage){
        key[0] = new Key(gameImage.getKeyIcon(0), 1,
                1, 1);
        key[1] = new Key(gameImage.getKeyIcon(1), 0,
                0, 3);
        key[2] = new Key(gameImage.getKeyIcon(2), 3,
                3,0);
        key[3] = new Key(gameImage.getKeyIcon(3), 2,
                2,2);
        key[4] = new Key(gameImage.getKeyIcon(4), 3,
                3,3);
    }

    private void initializeGamePlay(){
        KeyCollectorBoard.setToolBarInfo("Player 1 turn");
        currentPlayer = player[0];
    }

    public static Player getCurrentPlayer(){
        return currentPlayer;
    }

    public static Player[] getPlayer() {
        return player;
    }

    public static void nextPlayer(Player currentPlayer){
        int currentPlayerTurn = Arrays.asList(player).indexOf(currentPlayer);

        int nextPlayerTurn = currentPlayerTurn + 1;
        if (nextPlayerTurn > 3) { nextPlayerTurn = 0; }

        Player nextPlayer = player[nextPlayerTurn];
        Gameplay.currentPlayer = nextPlayer;
        KeyCollectorBoard.setToolBarInfo("Player " + (nextPlayerTurn + 1) + " turn");
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

            squares[row.get(i)][column.get(i)].setKey(key[i]);
        }
    }

    public static void removePlayerFromSquare(int row, int column){
        squares[row][column].removePlayer();
    }
}

