package main.game;

public class GameConfigurations {
    private final int kupletSize;
    private final int width;
    private final int height;

    public GameConfigurations(int kupletSize, int width, int height) {
        this.kupletSize = kupletSize;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "GameConfigurations{" +
                "kupletSize=" + kupletSize +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}