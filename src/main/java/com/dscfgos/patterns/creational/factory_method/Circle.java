package com.dscfgos.patterns.creational.factory_method;

public class Circle implements Shape {
    @Override
    public void draw() { System.out.println("Drawing from Circle"); }

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }
}
