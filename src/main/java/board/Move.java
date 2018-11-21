package board;

public class Move {
    private int row;
    private int column;
    private int player;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Move(int row, int column, int player) {

        this.row = row;
        this.column = column;
        this.player = player;
    }
}
