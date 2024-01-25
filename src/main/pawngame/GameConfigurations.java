package main.pawngame;

public class GameConfigurations {
    private final int kupletSize;
    private final int row;
    private final int column;

    public GameConfigurations(int kupletSize, int row, int column) {
        this.kupletSize = kupletSize;
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "GameConfigurations{" +
                "kupletSize=" + kupletSize +
                ", row=" + row +
                ", column=" + column +
                '}';
    }

    public int getKupletSize() {
        return kupletSize;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}