package com.dscfgos.patterns.creational.abstract_factory.classes;

import com.dscfgos.patterns.creational.abstract_factory.interfaces.ThreeDimShape;

public class Cube implements ThreeDimShape {
    @Override
    public void draw() {
        System.out.println("Drawing from Cube");
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CUBE;
    }
}
