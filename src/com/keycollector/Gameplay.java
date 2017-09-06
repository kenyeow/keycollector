package com.keycollector;

public class Gameplay {

    private KeyCollectorBoard keyCollectorBoard;
    private static Player player1, player2, player3, player4;
    private static Player currentPlayer = null;
    private static Square[][] squares;

    public Gameplay(){
        GameImage gameImage = new GameImage();
        keyCollectorBoard = new KeyCollectorBoard();
        player1 = new Player(gameImage.getPlayerIcon(0), 0, 0);
        player2 = new Player(gameImage.getPlayerIcon(1), 0, 8);
        player3 = new Player(gameImage.getPlayerIcon(2), 8, 0);
        player4 = new Player(gameImage.getPlayerIcon(3), 8, 8);

        squares = KeyCollectorBoard.getSquares();
        squares[0][0].setPlayer(player1);
        squares[0][8].setPlayer(player2);
        squares[8][0].setPlayer(player3);
        squares[8][8].setPlayer(player4);

        initializeGamePlay();
    }

    private void initializeGamePlay(){
        keyCollectorBoard.setToolBarInfo("Player 1 turn");
        currentPlayer = player1;
    }

    public static Player getCurrentPlayer(){
        return currentPlayer;
    }

    public static void removePlayerFromSquare(int row, int column){
        squares[row][column].removePlayer();
    }
}
