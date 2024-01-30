package main.pawngame;

public class GameConfigurations {
    private static GameConfigurations instance;

    private final int kupletSize;
    private final int row;
    private final int column;

    private GameConfigurations(int kupletSize, int row, int column) {
        this.kupletSize = kupletSize;
        this.row = row;
        this.column = column;
    }

    public static void setInstance(int kupletSize, int row, int column) {
        if (instance == null)
            instance = new GameConfigurations(kupletSize, row, column);
    }
    public static GameConfigurations getInstance() {
        return instance;
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