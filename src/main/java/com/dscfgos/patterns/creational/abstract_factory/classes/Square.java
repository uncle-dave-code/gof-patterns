package com.dscfgos.patterns.creational.abstract_factory.classes;

import com.dscfgos.patterns.creational.abstract_factory.interfaces.TwoDimShape;

public class Square implements TwoDimShape {
    @Override
    public void draw() {
        System.out.println("Drawing from Square");
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }
}
