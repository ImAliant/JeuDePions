package main.game;

import java.util.Arrays;
import java.util.List;

public class Constants {
    private Constants() {
        throw new AssertionError("Constants class should not be instantiated");
    }

    public static final GameConfigurations TICTACTOECONF = new GameConfigurations(3, 3, 3);
    public static final GameConfigurations CONNECTFOURCONF = new GameConfigurations(4, 7, 6);
    public static final GameConfigurations GOMOKUCONF = new GameConfigurations(5, 19, 19);
    
    protected static final List<Tuple<Integer, String>> GAMES = Arrays.asList(
        new Tuple<>(1, "Tic-tac-toe"),
        new Tuple<>(2, "Connect Four"),
        new Tuple<>(3, "Gomoku")
    );

    public static final int TICTACTOE = 1;
    public static final int CONNECTFOUR = 2;
    public static final int GOMOKU = 3;

    protected static final String[] DEFAULTNAMES = {"Player 1", "Player 2"};

    public static final String YES = "y";
    public static final String NO = "n";

    public static final String HUMAN = "Human";
    public static final String AI = "AI";

    public static final String DEFAULTGAME = "1";
    public static final String DEFAULTAI = YES;

    public static final String FORMATNAME = "%-15s (%s)";

    public static final String GAMEQUESTION = "What game do you want to play? (default is 1)";
    public static final String NAMEQUESTION = "What is your name? (default is \"Player ...\")";
    public static final String AIQUESTION = "Do you want to play against an AI? (y/n) (default is y)";
    public static final String GAMECONFIGQUESTION = "Do you want to play with the default configuration? (y/n) (default is y)";

    public static final String INVALIDGAME = "Invalid game";
    public static final String INVALIDANSWER = "Invalid answer";
}
