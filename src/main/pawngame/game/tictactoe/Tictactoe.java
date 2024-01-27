package main.pawngame.game.tictactoe;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;
import main.pawngame.game.Model;

public class Tictactoe extends Model {

    public Tictactoe(Player[] players) {
        super(players);
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 3 || board.getRow() != 3)
            throw new IllegalArgumentException("Tictactoe board must be 3x3");
    }

    @Override
    protected void turn() {
        //throw new UnsupportedOperationException("Unimplemented method 'turn'");
    }

    /*@Override
    protected boolean checkWin() {
        
    }*/

    @Override
    protected void createConfig() {
        GameConfigurations.setInstance(Constants.TICTACTOE_KUPLET, Constants.TICTACTOE_ROW, Constants.TICTACTOE_COLUMN);
    }

    @Override
    protected void checkBoardDimension(int row, int column) {
        if (row != Constants.TICTACTOE_ROW || column != Constants.TICTACTOE_COLUMN)
            throw new IllegalArgumentException("Tictactoe board must be 3x3");
    }
}
