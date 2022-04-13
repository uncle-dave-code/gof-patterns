package com.dscfgos.patterns.creational.abstract_factory;

import com.dscfgos.patterns.creational.abstract_factory.classes.*;
import com.dscfgos.patterns.creational.abstract_factory.interfaces.AbstractFactory;
import com.dscfgos.patterns.creational.abstract_factory.interfaces.Shape;

public class ThreeDimShapeFactory implements AbstractFactory {

    @Override
    public Shape createShape(ShapeType type) {
        if (type != null) {
            switch (type) {
                case SPHERE:
                    return new Sphere();
                case CUBE:
                    return new Cube();
                case CONE:
                    return new Cone();
                default:
                    throw new IllegalArgumentException("Invalid Shape Type");
            }
        } else {
            throw new IllegalArgumentException("Invalid Shape Type");
        }
    }
}
