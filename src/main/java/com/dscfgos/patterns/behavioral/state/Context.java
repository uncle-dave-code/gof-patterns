package com.dscfgos.patterns.behavioral.state;

public class Context {
    private State currentState;

    public State getState() {
        return currentState;
    }

    public void setState(State state) {
        this.currentState = state;
    }
}
