package board;

import ai.AI;
import ai.MiniMax;
import ai.RandomAI;

public class Game {
    public static final int HEIGHT = 3;
    public static final int WIDTH = 3;
    public static final int WIN_COUNT = 3;
    private int sleepTime = 3000;

    private int whiteWon = 0;
    private int blackWon = 0;
    private int draw = 0;
    private AI black;
    private AI white;
    private String whoWonLastGame = "";

    public AI getBlack() {
        return black;
    }

    public AI getWhite() {
        return white;
    }

    public String getWhoWonLastGame() {
        return whoWonLastGame;
    }

    public void setWhoWonLastGame(String whoWonLastGame) {
        this.whoWonLastGame = whoWonLastGame;
    }

    public Game(AI white, AI black) {

        this.white = white;
        this.black = black;
    }

    public void play(boolean print) throws InterruptedException {
        Board board = new Board(HEIGHT, WIDTH, WIN_COUNT);

        while (true) {
            if (makeMove(board, white, Board.SQUARE_PLAYER_WHITE, print)) break;

            if (makeMove(board, black, Board.SQUARE_PLAYER_BLACK, print)) break;
        }
        if(board.getGameStatus().getGameStatus() == 10) {
            draw++;
            whoWonLastGame = "DRAW";
        } else if(board.getGameStatus().getGameStatus() == 1) {
            whiteWon++;
            whoWonLastGame = "WHITE";
        } else if(board.getGameStatus().getGameStatus() == -1) {
            blackWon++;
            whoWonLastGame = "BLACK";
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
