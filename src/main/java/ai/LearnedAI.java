package ai;

import board.Board;
import board.Move;
import board.SimpleBoard;
import javafx.util.Pair;
import machinelearning.Learner;
import machinelearning.MapMovePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LearnedAI implements AI {

    private HashMap<int[][], Move> moves = new HashMap<>();
    private Learner learner;
    private boolean isLearning;

    public HashMap<int[][], Move> getMoves() {
        return moves;
    }

    public LearnedAI(Learner learner, boolean isLearning) {
        this.learner = learner;
        this.isLearning = isLearning;
    }

    private List<Move> getAllPossibleMoves(int[][] board, int player) {
        List<Move> moves = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == Board.SQUARE_EMPTY) {
                    moves.add(new Move(row, col,player));
                }
            }
        }
        return moves;
    }

    @Override
    public Move getMove(SimpleBoard board, int player) {
        List<Move> moves = getAllPossibleMoves(board.getBoard(), player);
        int bestMove = -1;
        Move moveToMake = null;
        if(!isLearning) {
            for (Move move : moves) {
                MapMovePair mapMovePair = new MapMovePair(board.getBoard(), move);
                if (learner.getMap().containsKey(mapMovePair)) {
                    if (learner.getMap().get(mapMovePair) > bestMove) {
                        moveToMake = move;
                        bestMove = learner.getMap().get(mapMovePair);
                    }
                    //System.out.println("found a key!");
                }
            }
        }

        if(moveToMake == null) {
            Random r = new Random();
            int nr = r.nextInt(moves.size());
            moveToMake = moves.get(nr);
        }

        this.moves.put(board.getBoard(), moveToMake);

        return moveToMake;
    }
}


