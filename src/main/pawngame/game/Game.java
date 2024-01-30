package main.pawngame.game;

public class Game {
    private Controller controller;

    public Game(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        controller.start();
    }
}
