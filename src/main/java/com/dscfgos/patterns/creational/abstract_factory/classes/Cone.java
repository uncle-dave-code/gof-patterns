package com.dscfgos.patterns.creational.abstract_factory.classes;

import com.dscfgos.patterns.creational.abstract_factory.interfaces.ThreeDimShape;

public class Cone implements ThreeDimShape {
    @Override
    public void draw() {
        System.out.println("Drawing from Cone");
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CONE;
    }
}
