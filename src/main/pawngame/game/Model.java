package main.pawngame.game;

import main.pawngame.Board;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;

public abstract class Model {
    protected Board board;
    protected Player[] players;

    protected Player currentPlayer;

    protected Model(Player[] players, GameConfigurations gameConfigurations) {
        initPlayers(players);
        initBoard(gameConfigurations);
    }

    private void initPlayers(Player[] players) {
        this.players = players;
        currentPlayer = players[0];
    }

    private void initBoard(GameConfigurations gameConfigurations) {
        board = new Board(gameConfigurations.getKupletSize(), gameConfigurations.getRow(), gameConfigurations.getColumn());
        checkBoardDimension();
    }

    protected abstract void turn();
    protected abstract boolean checkWin();
    protected abstract void checkBoardDimension();
}
