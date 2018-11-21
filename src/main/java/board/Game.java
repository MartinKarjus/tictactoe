package board;

import ai.AI;
import ai.MiniMax;
import ai.RandomAI;

public class Game {
    private int sleepTime = 3000;

    private int whiteWon = 0;
    private int blackWon = 0;
    private int draw = 0;
    private AI black;
    private AI white;


    public Game(AI white, AI black) {

        this.white = white;
        this.black = black;
    }

    public void play(boolean print) throws InterruptedException {
        Board board = new Board(3, 3, 3);

        while (true) {
            if (makeMove(board, white, Board.SQUARE_PLAYER_WHITE, print)) break;

            if (makeMove(board, black, Board.SQUARE_PLAYER_BLACK, print)) break;
        }
        if(board.getGameStatus().getGameStatus() == 10) {
            draw++;
        } else if(board.getGameStatus().getGameStatus() == 1) {
            whiteWon++;
        } else if(board.getGameStatus().getGameStatus() == -1) {
            blackWon++;
        }
    }

    private boolean makeMove(Board board, AI player, int squarePlayerWhite, boolean print) throws InterruptedException {
        Move move = player.getMove(new SimpleBoard(board.getBoard()), squarePlayerWhite);

        move.setPlayer(squarePlayerWhite);

        board.place(move);
        if(print) {
            board.printBoard();
            Thread.sleep(sleepTime);
        }
        return board.getGameStatus().getGameStatus() != 0;
    }

    public void playManyTimesNoPrint(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            play(false);
        }
        System.out.println("Black won: " + blackWon);
        System.out.println("White won: " + whiteWon);
        System.out.println("Drawn games: " + draw);
    }
}
