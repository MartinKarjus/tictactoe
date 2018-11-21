package board;

public class SimpleBoard {
    int[][] board;

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    public SimpleBoard(int[][] board) {
        this.board = new int[board.length][board.length];
        copyBoard(board);
    }

    private void copyBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                this.board[row][col] = board[row][col];
            }
        }
    }
}
