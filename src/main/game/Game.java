package main.game;

public abstract class Game {
    private Board board;
    private Player[] players;

    protected Game(Player[] players, GameConfigurations gameConfigurations) {
        this.players = players;
        board = new Board(gameConfigurations.getKupletSize(), gameConfigurations.getRow(), gameConfigurations.getColumn());
    }

    public abstract void run();

    public abstract void showBoard();

    public abstract boolean gameOver();

    public Board getBoard() {
        return board.clone();
    }

    public Player[] getPlayers() {
        return players.clone();
    }
}
