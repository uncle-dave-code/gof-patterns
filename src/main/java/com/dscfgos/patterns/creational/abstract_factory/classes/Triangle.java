package com.dscfgos.patterns.creational.abstract_factory.classes;

import com.dscfgos.patterns.creational.abstract_factory.interfaces.TwoDimShape;

public class Triangle implements TwoDimShape {
    @Override
    public void draw() {
        System.out.println("Drawing from Triangle");
    }

    @Override
    public ShapeType getType() {
        return ShapeType.TRIANGLE;
    }
}
