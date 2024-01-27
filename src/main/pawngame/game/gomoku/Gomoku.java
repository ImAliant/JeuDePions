package main.pawngame.game.gomoku;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;
import main.pawngame.game.Model;

public class Gomoku extends Model {
    public Gomoku(Player[] players) {
        super(players);
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 19 || board.getRow() != 19)
            throw new IllegalArgumentException("Gomoku board must be 19x19");
    }

    @Override
    protected void turn() {
        //throw new UnsupportedOperationException("Unimplemented method 'turn'");
    }

    /*@Override
    protected boolean checkWin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkWin'");
    }*/

    @Override
    protected void createConfig() {
        GameConfigurations.setInstance(Constants.GOMOKU_KUPLET, Constants.GOMOKU_ROW, Constants.GOMOKU_COLUMN);
    }

    @Override
    protected void checkBoardDimension(int row, int column) {
        if (row != Constants.GOMOKU_ROW || column != Constants.GOMOKU_COLUMN)
            throw new IllegalArgumentException("Gomoku board must be 19x19");
    }
}
