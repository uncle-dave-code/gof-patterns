package com.dscfgos.patterns.structural.flyweight;

public class Circle implements Shape {
    private final Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle - Color:" + color.getColor());
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }

}
