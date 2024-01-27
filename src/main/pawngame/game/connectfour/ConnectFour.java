package main.pawngame.game.connectfour;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.Player;
import main.pawngame.game.Model;

public class ConnectFour extends Model {
    public ConnectFour(Player[] players) {
        super(players);
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 7 || board.getRow() != 6)
            throw new IllegalArgumentException("Connect Four board must be 7x6");
    }

    @Override
    protected void turn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turn'");
    }

    /*@Override
    protected boolean checkWin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkWin'");
    }*/

    @Override
    protected void createConfig() {
        GameConfigurations.setInstance(Constants.CONNECTFOUR_KUPLET, Constants.CONNECTFOUR_ROW, Constants.CONNECTFOUR_COLUMN);
    }

    @Override
    protected void checkBoardDimension(int row, int column) {
        if (row != Constants.CONNECTFOUR_ROW || column != Constants.CONNECTFOUR_COLUMN)
            throw new IllegalArgumentException("Connect Four board must be 7x6");
    }
}
