package main.pawngame.game.tictactoe;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.board.TictactoeBoard;
import main.pawngame.game.Model;
import main.pawngame.player.ai.TictactoeAI;
import main.pawngame.player.human.TictactoeHuman;

public class TictactoeModel extends Model {
    @Override
    protected void createPlayers(boolean ai) {
        players.add(new TictactoeHuman(Constants.FIRSTPLAYER, Constants.COLORP1));
        players.add(ai ? new TictactoeAI(Constants.COLORP2): new TictactoeHuman(Constants.SECONDPLAYER, Constants.COLORP2));
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

        board = new TictactoeBoard(GameConfigurations.getInstance());
    }

    @Override
    protected void checkBoardDimension(int row, int column) {
        if (row != Constants.TICTACTOE_ROW || column != Constants.TICTACTOE_COLUMN)
            throw new IllegalArgumentException("Tictactoe board must be 3x3");
    }
}
