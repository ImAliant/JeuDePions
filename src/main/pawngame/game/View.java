package main.pawngame.game;

import main.pawngame.Board;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;

public abstract class View {
    private Board board;

    protected View() {}

    public void showBoard(Board board) {
        GameConfigurations config = GameConfigurations.getInstance();
        System.out.printf("%d %d %d\n", config.getKupletSize(), config.getRow(), config.getColumn());
    }
    public void showWinner(Player player) {
        System.out.println("The winner is " + player.getName());
    }
}
