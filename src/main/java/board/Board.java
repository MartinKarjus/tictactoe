package board;

public class Board {
    private int[][] board;
    public static int SQUARE_PLAYER_WHITE = 1;
    public static int SQUARE_PLAYER_BLACK = -1;
    public static int SQUARE_EMPTY = 0;
    private Status gameStatus = new Status();
    public static int WIN_COUNT;

    public Status getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Status gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public Board(int height, int width, int winCount)  {
        board = new int[height][width];
        WIN_COUNT = winCount;
    }

    public void place(Move move) {

        if(board[move.getRow()][move.getColumn()] != Board.SQUARE_EMPTY) {
            throw new RuntimeException("square you are trying to use is not empty ROW:" + move.getRow()
                    + " COLUMN: " + move.getColumn() + " PLAYER: " + move.getPlayer());
        }
        board[move.getRow()][move.getColumn()] = move.getPlayer();
        checkIfSomeoneHasWon();
    }
    public void printBoard() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(String.format("%1$3d", board[i][j]));
            }
            System.out.println();
        }
        System.out.println("----------");
    }
    public void checkIfSomeoneHasWon() {
        boolean hasEmpty = false;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int player = board[row][col];
                if (player != Board.SQUARE_EMPTY) {
                    if (row <= board.length - WIN_COUNT)  {// down
                        if (countWinningSquares(row, col, 1, 0)) { // just down

                            gameStatus.setWinner(player);
                            return;
                        }
                        if (col > WIN_COUNT - 2 && countWinningSquares(row, col, 1, -1)) { // diag down and left

                            gameStatus.setWinner(player);
                            return;
                        }
                    }
                    if (col <= board[row].length - WIN_COUNT) { // right
                        if (countWinningSquares(row, col, 0, 1)) { // just right

                            gameStatus.setWinner(player);
                            return;
                        }
                        if (row <=  board.length - WIN_COUNT && countWinningSquares(row, col, 1, 1)) { // right and down
                            gameStatus.setWinner(player);
                            return;
                        }
                    }
                } else {
                    hasEmpty = true;
                }

            }
        }
        if (hasEmpty) return;
        gameStatus.setWinner(Status.GAME_STATUS_DRAW);

        //source: ttü gomoku

    }
    private boolean countWinningSquares(int row, int column, int deltaRow, int deltaColumn) {
        int player = board[row][column];
        for (int i = 1; i < WIN_COUNT; i++) {

            if (board[row + i * deltaRow][column + i * deltaColumn] != player) return false;
        }
        return true;
        //source: ttü gomoku
    }


}
