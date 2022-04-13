package com.dscfgos.patterns.creational.abstract_factory;

import com.dscfgos.patterns.creational.abstract_factory.classes.Circle;
import com.dscfgos.patterns.creational.abstract_factory.classes.ShapeType;
import com.dscfgos.patterns.creational.abstract_factory.classes.Square;
import com.dscfgos.patterns.creational.abstract_factory.classes.Triangle;
import com.dscfgos.patterns.creational.abstract_factory.interfaces.AbstractFactory;
import com.dscfgos.patterns.creational.abstract_factory.interfaces.Shape;

public class TwoDimShapeFactory implements AbstractFactory {

    @Override
    public Shape createShape(ShapeType type) {
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
