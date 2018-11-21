package main;

import ai.AI;
import ai.Human;
import ai.MiniMax;
import ai.RandomAI;
import board.Board;
import board.Game;
import board.Move;
import board.SimpleBoard;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        Board b = new Board(3, 3, 3);
        b.printBoard();
        b.place(new Move(0, 2, Board.SQUARE_PLAYER_BLACK));
        b.place(new Move(1, 1, Board.SQUARE_PLAYER_BLACK));
        b.place(new Move(2, 0, Board.SQUARE_PLAYER_BLACK));
        b.printBoard();
        System.out.println(b.getGameStatus().getGameStatus());
        System.out.println();
        System.out.println(new Random().nextInt(3) + 1);
        */
        /*
        Game game = new Game();
        try {
            game.play(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        /*

        Board b = new Board(3, 3, 3);
        b.printBoard();
        b.place(new Move(0, 2, Board.SQUARE_PLAYER_WHITE));
        b.place(new Move(0, 1, Board.SQUARE_PLAYER_WHITE));
        //b.place(new Move(2, 0, Board.SQUARE_PLAYER_BLACK));
        b.printBoard();

        AI ai = new MiniMax();
        //b.getBoard().clone()[1][2] = 10;





        Move move = ai.getMove(new SimpleBoard(b.getBoard()), Board.SQUARE_PLAYER_BLACK);
        move.setPlayer( Board.SQUARE_PLAYER_BLACK);
        b.place(move);
        b.printBoard();
        */




        Game game = new Game(new RandomAI(), new MiniMax());
        try {
            game.play(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
