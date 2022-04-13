package com.dscfgos.patterns.structural.bridge;

public class ConcreteCar extends Car {

    public ConcreteCar(Color color) {
        super(color);
    }

    @Override
    public String paint() {
        return "Painting with color: " + color.getColor();
    }
}
