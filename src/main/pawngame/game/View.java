package main.pawngame.game;

import main.pawngame.Board;
import main.pawngame.Player;
import main.pawngame.UI;

public abstract class View implements UI {
    protected View() {}

    public void showBoard(Board board) {
        printColumnNumbers(board.getColumn());
        printBorder();
        printBoardRepresentation(board);
        printBorder();
    }

    public void printColumnNumbers(int column) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < column; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public void showWinner(Player player) {
        System.out.println("The winner is " + player.getName());
    }
}
