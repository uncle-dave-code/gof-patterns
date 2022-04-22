package com.dscfgos.patterns.behavioral.state;

public class StateA implements State{
    @Override
    public void handle(Context context) {
        context.setState(this);
    }

    @Override
    public String toString() {
        return "State A";
    }
}
