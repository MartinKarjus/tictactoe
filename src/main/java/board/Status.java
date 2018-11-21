package board;

public class Status {
    private int gameStatus = 0;
    public static int GAME_STATUS_DRAW = 10;
    public static int GAME_STATUS_OPEN = 0;
    public static int GAME_STATUS_BLACK_WIN = -1;
    public static int GAME_STATUS_WHITE_WIN = 1;

    public int getGameStatus() {
        return gameStatus;
    }

    public void setWinner(int gameStatus) {
        if(gameStatus == GAME_STATUS_DRAW) {
            System.out.println("THE GAME IS A DRAW");
        } else if(gameStatus == GAME_STATUS_BLACK_WIN) {
            System.out.println("BLACK WON");
        } else if(gameStatus == GAME_STATUS_WHITE_WIN) {
            System.out.println("WHITE WON");
        }
        this.gameStatus = gameStatus;
    }
}
