package com.dscfgos.patterns.creational.abstract_factory;

import com.dscfgos.patterns.creational.abstract_factory.interfaces.AbstractFactory;

public class ShapeFactory {
    public static AbstractFactory getFactory(boolean twoDimShape) {

        return (twoDimShape) ? new TwoDimShapeFactory() : new ThreeDimShapeFactory();
    }
}
