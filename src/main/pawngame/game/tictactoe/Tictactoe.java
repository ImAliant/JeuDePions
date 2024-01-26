package main.pawngame.game.tictactoe;

import main.pawngame.GameConfigurations;
import main.pawngame.Player;
import main.pawngame.game.Model;

public class Tictactoe extends Model {

    public Tictactoe(Player[] players, GameConfigurations gameConfigurations) {
        super(players, gameConfigurations);
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 3 || board.getRow() != 3)
            throw new IllegalArgumentException("Tictactoe board must be 3x3");
    }

    @Override
    protected void turn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turn'");
    }

    @Override
    protected boolean checkWin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkWin'");
    }

    /*@Override
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
    }*/
}
