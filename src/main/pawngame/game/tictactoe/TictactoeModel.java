package main.pawngame.game.tictactoe;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.game.Model;
import main.pawngame.player.Human;
import main.pawngame.player.TictactoeAI;

public class TictactoeModel extends Model {
    @Override
    protected void createPlayers(boolean ai) {
        super.createPlayers(ai);
        players.add(ai ? new TictactoeAI(): new Human(Constants.SECONDPLAYER));
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 3 || board.getRow() != 3)
            throw new IllegalArgumentException("Tictactoe board must be 3x3");
    }

    @Override
    protected boolean checkWin() {
        return super.checkWin();
    }

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
