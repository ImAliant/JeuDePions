package main.pawngame;

import java.util.Deque;

public class StateManager {
    private Deque<State> states;
    private State newState;

    private boolean add;
    private boolean replace;
    private boolean removeAll;

    public void addState(State toAdd, boolean replace) {
        add = true;
        newState = toAdd;
        this.replace = replace;
    }

    public void popAll() {
        removeAll = true;
    }

    public void processStateChange() {
        if (removeAll) {
            while (!isEmpty()) states.pop();
            
            removeAll = false;
        }

        if (add) {
            if (replace && !isEmpty()) {
                states.pop();
                replace = false;
            }

            states.push(newState);
            states.peek().init();
            add = false;
        }
    }

    public State getCurrent() {
        return states.peek();
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }
}
