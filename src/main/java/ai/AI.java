package ai;

import board.Board;
import board.Move;
import board.SimpleBoard;

public interface AI {
    Move getMove(SimpleBoard board, int player);
}
