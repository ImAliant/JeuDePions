package main.pawngame;

public class Context {
    public StateManager states;

    public Context() {
        states = new StateManager();
    }

    public void close() {
        states.popAll();
    }
}
