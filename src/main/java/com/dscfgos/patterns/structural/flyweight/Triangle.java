package com.dscfgos.patterns.structural.flyweight;

public class Triangle implements Shape {

    private final Color color;

    public Triangle(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle - Color:" + color.getColor());
    }

    @Override
    public ShapeType getType() {
        return ShapeType.TRIANGLE;
    }
}
