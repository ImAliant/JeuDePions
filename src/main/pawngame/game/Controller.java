package main.pawngame.game;

public abstract class Controller {
    private Model model;
    private View view;

    protected Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        // TODO Auto-generated method stub
    }
}
