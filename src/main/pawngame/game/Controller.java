package main.pawngame.game;

public abstract class Controller {
    private Model model;
    private View view;

    protected Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        init();
    }

    public void init() {
        model.init();
    }

    public void start() {
        boolean isGameOver = false;
        while (!isGameOver) {
            view.cleanScreen();
            view.showCurrentPlayer(model.getCurrentPlayer());
            view.showBoard(model.getBoard());
            model.turn();

            // update the kuplet
            model.updateKuplet();

            isGameOver = model.checkWin();

            model.changePlayer();
        }

        end();
    }

    public void end() {
        view.cleanScreen();
        view.showBoard(model.getBoard());
        view.showWinner(model.getWinner());
    }
}
