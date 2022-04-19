package com.dscfgos.patterns.structural.flyweight;

public class Rectangle implements Shape {

    private final Color color;

    public Rectangle(Color color) {
        this.color = color;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle - Color:" + color.getColor());
    }

    @Override
    public ShapeType getType() {
        return ShapeType.RECTANGLE;
    }

}
