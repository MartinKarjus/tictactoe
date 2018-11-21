package ai;

import board.Move;
import board.SimpleBoard;

import java.util.Scanner;

public class Human implements AI {
    private Scanner reader = new Scanner(System.in);
    @Override
    public Move getMove(SimpleBoard board, int player) {
        System.out.println("Enter a position,( ex: 1,2 ) : ");
        String input = reader.nextLine();
        int row = Integer.valueOf(input.split(",")[0]);
        int col = Integer.valueOf(input.split(",")[1]);
        return new Move(row, col, player);
    }
}
