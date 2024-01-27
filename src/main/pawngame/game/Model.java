package main.pawngame.game;

import main.pawngame.Board;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;

public abstract class Model {
    protected Board board;
    protected Player[] players;

    protected Player currentPlayer;

    protected boolean playerChanged = false;

    protected Model(Player[] players) {
        this.players = players;
        this.currentPlayer = players[0];
    }

    public void init() {
        initBoard();
    }

    private void initBoard() {
        createConfig();

        board = new Board(GameConfigurations.getInstance());

        int row = board.getRow();
        int column = board.getColumn();

        checkBoardDimension(row, column);
    }

    public Board getBoard() {
        return board;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    protected boolean checkWin() {
        return true;
    };

    protected abstract void createConfig();
    protected abstract void checkBoardDimension(int row, int column);
    protected abstract void turn();
    protected abstract void checkBoardDimension();
}
