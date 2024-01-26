package main.pawngame.game;

import main.pawngame.Board;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;

public abstract class Model {
    protected Board board;
    protected Player[] players;

    protected Model(Player[] players, GameConfigurations gameConfigurations) {
        this.players = players;
        board = new Board(gameConfigurations.getKupletSize(), gameConfigurations.getRow(), gameConfigurations.getColumn());

        checkBoardDimension();
    }

    protected abstract void checkBoardDimension();
}
