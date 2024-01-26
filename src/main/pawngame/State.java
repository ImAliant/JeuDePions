package main.pawngame;

public interface State {
    public void init();
    public void processInput();
    public void update();
    public void draw();
}
