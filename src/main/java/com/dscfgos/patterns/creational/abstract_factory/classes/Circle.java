package com.dscfgos.patterns.creational.abstract_factory.classes;

import com.dscfgos.patterns.creational.abstract_factory.interfaces.TwoDimShape;

public class Circle implements TwoDimShape {

    @Override
    public void draw() { System.out.println("Drawing from Circle"); }

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }
}
