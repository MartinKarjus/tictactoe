package machinelearning;

import board.Move;

import java.util.Arrays;

public class MapMovePair {
    private int [][] key;
    private Move value;

    public MapMovePair(int[][] arr, Move move) {
        this.key = arr;
        this.value = move;
    }

    public int [][] getKey() {
        return key;
    }

    public Move getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof MapMovePair) {
            MapMovePair pair = (MapMovePair) o;
            if (key != null ? !Arrays.deepEquals(key, pair.key) : pair.key != null) return false;
            if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(key) * 13 + (value == null ? 0 : value.hashCode());
    }
}
