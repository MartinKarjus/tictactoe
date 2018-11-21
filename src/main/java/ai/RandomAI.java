package ai;

import board.Board;
import board.Move;
import board.SimpleBoard;

import java.util.Random;

public class RandomAI  implements AI{

    @Override
    public Move getMove(SimpleBoard simpleBoard, int player) {
        int[][] board = simpleBoard.getBoard();
        Random r = new Random();
        int col = r.nextInt(board.length);
        int row = r.nextInt(board.length);
        if(board[row][col] != Board.SQUARE_EMPTY) {
            return getMove(simpleBoard ,player);
        }
        return new Move(row, col, player);
    }
}
