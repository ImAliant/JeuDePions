package main.game;

import java.util.Scanner;

public class Menu {
    protected final Scanner scanner = new Scanner(System.in);

    private String game;
    private String ai;
    private String name;
    private String name2 = Constants.AI;

    public Menu() {
        run();
    }

    public void run() {
        askForGame();

        askForAI();

        askForName();

        askGameConfiguration();
    }

    private void askForGame() {
        System.out.println(Constants.GAMEQUESTION);
        for (int i = 0; i < Constants.GAMES.length; i++)
            System.out.println((i + 1) + ". " + Constants.GAMES[i]);
        game = scanner.nextLine();
        System.out.println();
    }

    private void askForAI() {
        System.out.println(Constants.AIQUESTION);
        ai = scanner.nextLine();
        System.out.println();
    }

    private void askForName() {
        name = askForPlayerName(Constants.NAMEQUESTION, Constants.DEFAULTNAMES[0]);
        if (!ai.equals(Constants.YES))
            name2 = askForPlayerName(Constants.NAMEQUESTION, Constants.DEFAULTNAMES[1]);
    }

    private String askForPlayerName(String question, String defaultName) {
        System.out.println(question);
        String playerName = scanner.nextLine();
        if (playerName == null || playerName.isEmpty()) {
            playerName = defaultName;
        }

        return String.format("%s (%s)", playerName, Constants.HUMAN);
    }

    private void askGameConfiguration() {
        System.out.println(Constants.GAMECONFIGQUESTION);
        String defaultConfig = scanner.nextLine();
        System.out.println();
    }
}
