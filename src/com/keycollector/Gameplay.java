package com.keycollector;

public class Gameplay {

    private static int x = 0;
    private static KeyCollectorBoard keyCollectorBoard;
    private static Player[] player = new Player[4];
    private static Player currentPlayer = null;
    private static Square[][] squares;


    public Gameplay(){
        GameImage gameImage = new GameImage();
        keyCollectorBoard = new KeyCollectorBoard();
        player[0] = new Player(gameImage.getPlayerIcon(0), 0, 0);
        player[1] = new Player(gameImage.getPlayerIcon(1), 0, 8);
        player[2] = new Player(gameImage.getPlayerIcon(2), 8, 0);
        player[3] = new Player(gameImage.getPlayerIcon(3), 8, 8);

        squares = KeyCollectorBoard.getSquares();
        squares[0][0].setPlayer(player[0]);
        squares[0][8].setPlayer(player[1]);
        squares[8][0].setPlayer(player[2]);
        squares[8][8].setPlayer(player[3]);

        initializeGamePlay();
    }

    private void initializeGamePlay(){
        keyCollectorBoard.setToolBarInfo("Player 1 turn");
        currentPlayer = player[0];
    }

    public static Player getCurrentPlayer(){
        return currentPlayer;
    }

    public static Player nextPlayer(){
        x++;
        if(x > 3)
        {
            x = 0;
        }
        currentPlayer = player[x];
        keyCollectorBoard.setToolBarInfo("Player " + x + " turn");
        return currentPlayer;
    }



    public static void removePlayerFromSquare(int row, int column){
        squares[row][column].removePlayer();
    }
}

