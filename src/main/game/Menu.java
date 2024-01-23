package main.game;

import java.util.Scanner;

public class Menu {
    protected final Scanner scanner = new Scanner(System.in);

    private int game;
    private String ai;

    private GameConfigurations gameConfigurations;

    public Menu() {
        run();
    }

    public void run() {
        askForGame();

        askForAI();

        setGameConfiguration();

        // On lance le jeu
        launchGame();
    }

    private void askForGame() {
        System.out.println(Constants.GAMEQUESTION);
        for (Tuple<Integer, String> g : Constants.GAMES) {
            System.out.println(String.format("%d. %s", g.getFirst(), g.getSecond()));
        }
        String rep = scanner.nextLine();

        if (Integer.parseInt(rep) < 1 || Integer.parseInt(rep) > Constants.GAMES.size()+1)
            throw new IllegalArgumentException(Constants.INVALIDGAME);

        if (rep.isEmpty())
            rep = Constants.DEFAULTGAME;

        game = Integer.parseInt(rep);

        System.out.println();
    }

    private void askForAI() {
        System.out.println(Constants.AIQUESTION);
        ai = scanner.nextLine();

        if (!ai.equals(Constants.YES) && !ai.equals(Constants.NO) && !ai.isEmpty())
            throw new IllegalArgumentException(Constants.INVALIDANSWER);

        if (ai.isEmpty()) 
            ai = Constants.DEFAULTAI;

        System.out.println();
    }

    private void launchGame() {
        Player[] players = new Player[2];
        players[0] = new Human(Constants.DEFAULTNAMES[0]);
        if (ai.equals(Constants.YES))
            players[1] = new AI(Constants.AI);
        else players[1] = new Human(Constants.DEFAULTNAMES[1]);

        Game newGame;
        
        switch (game) {
            case Constants.TICTACTOE:
                newGame = new Tictactoe(players, gameConfigurations);
                break;
            case Constants.CONNECTFOUR:
                newGame = new ConnectFour(players, gameConfigurations);
                break;
            case Constants.GOMOKU:
                newGame = new Gomoku(players, gameConfigurations);
                break;
            default:
                throw new IllegalArgumentException(Constants.INVALIDGAME);
        }

        newGame.run();
    }

    private void setGameConfiguration() {
        switch (game) {
            case Constants.TICTACTOE:
                gameConfigurations = Constants.TICTACTOECONF;
                break;
            case Constants.CONNECTFOUR:
                gameConfigurations = Constants.CONNECTFOURCONF;
                break;
            case Constants.GOMOKU:
                gameConfigurations = Constants.GOMOKUCONF;
                break;
            default:
                throw new IllegalArgumentException(Constants.INVALIDGAME);
        }
    }
}
