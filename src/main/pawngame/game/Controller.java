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
        view.showBoard(model.getBoard());

        while (!model.checkWin()) {
            model.turn();
            view.showBoard(model.getBoard());
        }
    }

    public void end() {
        view.showWinner(model.getCurrentPlayer());
    }
}
