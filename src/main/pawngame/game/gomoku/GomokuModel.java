package main.pawngame.game.gomoku;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.game.Model;
import main.pawngame.player.Human;
import main.pawngame.player.GomokuAI;

public class GomokuModel extends Model {
    @Override
    protected void createPlayers(boolean ai) {
        super.createPlayers(ai);
        players.add(ai ? new GomokuAI(): new Human(Constants.SECONDPLAYER));
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 19 || board.getRow() != 19)
            throw new IllegalArgumentException("Gomoku board must be 19x19");
    }

    @Override
    protected boolean checkWin() {
        return super.checkWin();
    }

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
