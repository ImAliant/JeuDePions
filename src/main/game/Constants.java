package main.game;

public class Constants {
    public static final String[] GAMES = {"Tic-tac-toe", "Connect Four", "Gomoku"};
    public static final String[] DEFAULTNAMES = {"Player 1", "Player 2"};

    public static final String YES = "y";

    public static final String HUMAN = "Human";
    public static final String AI = "AI";

    public static final String GAMEQUESTION = "What game do you want to play?";
    public static final String NAMEQUESTION = "What is your name?";
    public static final String AIQUESTION = "Do you want to play against an AI? (y/n)";
    public static final String GAMECONFIGQUESTION = "Do you want to play with the default configuration? (y/n)";

    public static final GameConfigurations TICTACTOE = new GameConfigurations(3, 3, 3);
    public static final GameConfigurations CONNECTFOUR = new GameConfigurations(4, 7, 6);
    public static final GameConfigurations GOMOKU = new GameConfigurations(5, 15, 15);
}
