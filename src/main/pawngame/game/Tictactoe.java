package main.pawngame.game;

import main.pawngame.GameConfigurations;
import main.pawngame.Player;

public class Tictactoe extends Game{

    public Tictactoe(Player[] players, GameConfigurations gameConfigurations) {
        super(players, gameConfigurations);
    }

    @Override
    public void run() {
        showBoard();
    }
    
    @Override
    public void showBoard() {
        System.out.print("    ");
            for(int i = 0; i < board.getColumn(); i++)
                System.out.print(i + " ");
        System.out.println();
        System.out.println("  +-------+");
        for (int i = 0; i < board.getRow(); i++) {
            System.out.printf("%d | ", i);
            for (int j = 0; j < board.getColumn(); j++) {
                System.out.printf("%s ", board.getCells()[i][j].state());
            }
            System.out.println("|");
        }
        System.out.println("  +-------+");
    }

    @Override
    public boolean gameOver() {
        return false;
    }
}
