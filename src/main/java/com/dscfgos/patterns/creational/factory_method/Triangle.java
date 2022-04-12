package com.dscfgos.patterns.creational.factory_method;

public class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing from Triangle");
    }

    @Override
    public ShapeType getType() {
        return ShapeType.TRIANGLE;
    }
}
