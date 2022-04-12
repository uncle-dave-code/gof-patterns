package com.dscfgos.patterns.creational.factory_method;

public class ShapeFactory {
    public Shape geShape(ShapeType type) {
        if (type != null) {
            switch (type) {
                case CIRCLE:
                    return new Circle();
                case SQUARE:
                    return new Square();
                case TRIANGLE:
                    return new Triangle();
                default:
                    throw new IllegalArgumentException("Invalid Shape Type");
            }
        } else {
            throw new IllegalArgumentException("Invalid Shape Type");
        }
    }
}
