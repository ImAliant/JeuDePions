package main.pawngame.game;

import main.pawngame.UI;
import main.pawngame.board.Board;
import main.pawngame.player.Player;

import java.util.Scanner;

public abstract class View implements UI {
    protected Scanner scanner = new Scanner(System.in);

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

    public void showCurrentPlayer(Player player) {
        System.out.println("Current player is " + player.getName());
    }

    public void showWinner(Player player) {
        System.out.println("The winner is " + player.getName());
    }
}
