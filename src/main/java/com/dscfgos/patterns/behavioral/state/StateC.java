package com.dscfgos.patterns.behavioral.state;

public class StateC implements State{
    @Override
    public void handle(Context context) {
        context.setState(this);
    }

    @Override
    public String toString() {
        return "State C";
    }
}
