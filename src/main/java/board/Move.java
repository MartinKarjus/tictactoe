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
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Move)) {
            return false;
        }

        Move move = (Move) o;

        return move.player == player &&
                move.column == column &&
                move.row == move.row;

    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + player;
        return result;
    }
}
