package main.pawngame;

import java.util.Arrays;
import java.util.List;

public class Constants {
    private Constants() {
        throw new AssertionError("Constants class should not be instantiated");
    }

    // Tictactoe config
    public static final int TICTACTOE_KUPLET = 3;
    public static final int TICTACTOE_ROW = 3;
    public static final int TICTACTOE_COLUMN = 3;
    // ConnectFour config
    public static final int CONNECTFOUR_KUPLET = 4;
    public static final int CONNECTFOUR_ROW = 6;
    public static final int CONNECTFOUR_COLUMN = 7;
    // Gomoku config
    public static final int GOMOKU_KUPLET = 5;
    public static final int GOMOKU_ROW = 19;
    public static final int GOMOKU_COLUMN = 19;
    
    protected static final List<Tuple<Integer, String>> GAMES = Arrays.asList(
        new Tuple<>(1, "Tic-tac-toe"),
        new Tuple<>(2, "Connect Four"),
        new Tuple<>(3, "Gomoku")
    );

    public static final int TICTACTOE = 1;
    public static final int CONNECTFOUR = 2;
    public static final int GOMOKU = 3;

    public static final String FIRSTPLAYER = "Player 1";
    public static final String SECONDPLAYER = "Player 2";

    public static final int IDPLAYER1 = 0;
    public static final int IDPLAYER2 = 1;
    public static final int MAX_PLAYERS = 2;

    public static final String YES = "y";
    public static final String NO = "n";

    public static final String HUMAN = "Human";
    public static final String AI = "AI";

    public static final String DEFAULTGAME = "1";
    public static final String DEFAULTAI = YES;

    public static final String FORMATNAME = "%-15s (%s)";

    public static final String WELCOME = "Welcome to the PawnGame ! Three games are available:";
    public static final String GAMEQUESTION = "What game do you want to play? (default is 1) [1..3]:";
    public static final String AIQUESTION = "Do you want to play against an AI? (default is y) [y/n]:";
    public static final String GAMECONFIGQUESTION = "Do you want to play with the default configuration? (default is y) [y/n]:";

    public static final String INVALIDGAME = "Invalid game";
    public static final String INVALIDANSWER = "Invalid answer";
}
