package main.pawngame.game.gomoku;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.board.GomokuBoard;
import main.pawngame.game.Model;
import main.pawngame.player.ai.GomokuAI;
import main.pawngame.player.human.GomokuHuman;

public class GomokuModel extends Model {
    @Override
    protected void createPlayers(boolean ai) {
        players.add(new GomokuHuman(Constants.FIRSTPLAYER, Constants.COLORP1));
        players.add(ai ? new GomokuAI(Constants.COLORP2): new GomokuHuman(Constants.SECONDPLAYER, Constants.COLORP2));
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

        board = new GomokuBoard(GameConfigurations.getInstance());
    }

    @Override
    protected void checkBoardDimension(int row, int column) {
        if (row != Constants.GOMOKU_ROW || column != Constants.GOMOKU_COLUMN)
            throw new IllegalArgumentException("Gomoku board must be 19x19");
    }
}
