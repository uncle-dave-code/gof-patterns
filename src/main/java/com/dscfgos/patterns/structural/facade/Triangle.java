package com.dscfgos.patterns.structural.facade;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}
