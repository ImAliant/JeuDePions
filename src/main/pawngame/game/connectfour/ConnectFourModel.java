package main.pawngame.game.connectfour;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.board.ConnectFourBoard;
import main.pawngame.game.Model;
import main.pawngame.player.ai.ConnectFourAI;
import main.pawngame.player.human.ConnectFourHuman;

public class ConnectFourModel extends Model {
    @Override
    protected void createPlayers(boolean ai) {
        players.add(new ConnectFourHuman(Constants.FIRSTPLAYER, Constants.COLORP1));
        players.add(ai ? new ConnectFourAI(Constants.COLORP2): new ConnectFourHuman(Constants.SECONDPLAYER, Constants.COLORP2));
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 7 || board.getRow() != 6)
            throw new IllegalArgumentException("Connect Four board must be 7x6");
    }

    @Override
    protected boolean checkWin() {
        return super.checkWin();
    }

    @Override
    protected void createConfig() {
        GameConfigurations.setInstance(Constants.CONNECTFOUR_KUPLET, Constants.CONNECTFOUR_ROW, Constants.CONNECTFOUR_COLUMN);

        board = new ConnectFourBoard(GameConfigurations.getInstance());
    }

    @Override
    protected void checkBoardDimension(int row, int column) {
        if (row != Constants.CONNECTFOUR_ROW || column != Constants.CONNECTFOUR_COLUMN)
            throw new IllegalArgumentException("Connect Four board must be 7x6");
    }
}
