package com.dscfgos.patterns.creational.factory_method;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing from Square");
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }
}
