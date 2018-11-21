package machinelearning;

import ai.LearnedAI;
import ai.RandomAI;
import board.Game;
import board.Move;
import javafx.util.Pair;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Learner {
    public static final int GAMES_TO_PLAY = 10000;
    private HashMap<MapMovePair, Integer> map = new HashMap<>();
    private static String LEARNER_COLOR = "black";


    public HashMap<MapMovePair, Integer> getMap() {
        return map;
    }

    private String getGameResult(Game game) throws InvalidValue {
        if(game.getWhoWonLastGame().equals("WHITE")) {
            if(LEARNER_COLOR.equals("white")) {
                return "win";
            } else {
                return "lose";
            }
        }
        if(game.getWhoWonLastGame().equals("DRAW")) {
            return "draw";
        }
        if(game.getWhoWonLastGame().equals("BLACK")) {
            if(LEARNER_COLOR.equals("white")) {
                return "lose";
            } else {
                return "win";
            }
        }
        throw new InvalidValue("invalid winstate");
    }

    public void learn() throws InterruptedException, InvalidValue {

        int gamesToPlay = GAMES_TO_PLAY;
        Game game;
        List<String> rList = new ArrayList<>();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < gamesToPlay; i++) {

//            for (MapMovePair movePair : map.keySet()) {
//                System.out.println(Arrays.deepToString(movePair.getKey()) + " " + movePair.getValue().getColumn() + ":" + movePair.getValue().getRow());
//                System.out.println(map.get(movePair));
//            }

            LearnedAI learner = new LearnedAI(this);
            if(LEARNER_COLOR.equals("white")) {
                game = new Game(learner, new RandomAI());
            } else {
                game = new Game(new RandomAI(), learner);
            }

            game.play(false);

            String result = getGameResult(game);

            for (int[][] ints : learner.getMoves().keySet()) {
                MapMovePair moveAtState = new MapMovePair(ints, learner.getMoves().get(ints));
                if (map.containsKey(moveAtState)) {
                    // HashMap<Pair<int[][], Move>, Integer>
                    if (result.equals("win")) {
                        map.put(moveAtState, map.get(moveAtState) + 2);
                    } else if(result.equals("lose")) {
                        map.put(moveAtState, map.get(moveAtState) - 2);
                    } else if(result.equals("draw")) {
                        map.put(moveAtState, map.get(moveAtState) + 1);
                    }
                } else {
                    if (result.equals("win")) {
                        map.put(moveAtState, 2);
                    } else if(result.equals("lose")) {
                        map.put(moveAtState, -2);
                    } else if(result.equals("draw")) {
                        map.put(moveAtState, 1);
                    }
                }
            }

            rList.add(result);
            if (result.equals("win")) {
                wins += 1;
            } else if(result.equals("lose")) {
                losses += 1;
            } else if(result.equals("draw")) {
                draws += 1;
            }

        }
        /*for (String s : rList) {
            System.out.println(s);
        }*/
        System.out.println("win " + wins);
        System.out.println("losses " + losses);
        System.out.println("draws " + draws);
    }


    public static void main(String[] args) throws InvalidValue, InterruptedException {
        new Learner().learn();
    }
}
