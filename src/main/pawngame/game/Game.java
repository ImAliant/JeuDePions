package main.pawngame.game;

import main.pawngame.Board;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;

public abstract class Game {
    protected Board board;
    protected Player[] players;

    protected Game(Player[] players, GameConfigurations gameConfigurations) {
        this.players = players;
        board = new Board(gameConfigurations.getKupletSize(), gameConfigurations.getRow(), gameConfigurations.getColumn());
    }

    public abstract void run();

    public abstract void showBoard();

    public abstract boolean gameOver();
}
