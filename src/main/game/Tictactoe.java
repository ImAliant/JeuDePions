package main.game;

public class Tictactoe extends Game{

    protected Tictactoe(Player[] players, GameConfigurations gameConfigurations) {
        super(players, gameConfigurations);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        showBoard();
    }
    
    @Override
    public void showBoard() {
        System.out.print("    ");
            for(int i = 1; i <= board.getColumn(); i++)
                System.out.print(i + "  ");
        System.out.println("  +---------+");
        for (int i = 0; i < board.getRow(); i++) {
            System.out.print(" " + (i+1) + " | ");
            for (int j = 0; j < board.getColumn(); j++) {
                System.out.print(board.getCells()[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +---------+");
    }

    @Override
    public boolean gameOver() {
        // TODO Auto-generated method stub
        return false;
    }
}
