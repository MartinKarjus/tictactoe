package main;

import ai.*;
import board.Board;
import board.Game;
import board.Move;
import board.SimpleBoard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import machinelearning.Learner;
import machinelearning.MapMovePair;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
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

        Game game = null;
        Learner learner = new ObjectMapper().readValue(new File(Learner.PATH), Learner.class);
        LearnedAI learnedAI =  new LearnedAI(learner);

            game = new Game(new RandomAI(), learnedAI);

        try {
            game.playManyTimesNoPrint(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        for (MapMovePair m :
                learner.getMap().keySet()) {
            System.out.println(m.toString() + " " + learner.getMap().get(m));
        }
        */


    }
}
