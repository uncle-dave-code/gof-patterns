package com.dscfgos.patterns.structural.bridge;

public abstract class Car {
    protected Color color;

    public Car(Color color) {
        this.color = color;
    }

    public abstract String paint();

}
