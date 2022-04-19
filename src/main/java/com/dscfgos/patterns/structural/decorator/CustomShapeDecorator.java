package com.dscfgos.patterns.structural.decorator;

public class CustomShapeDecorator extends ShapeDecorator {

    public CustomShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setCustomBorder(shape);
        setCustomColor(shape);
    }

    private void setCustomBorder(Shape shape) {
        System.out.println("Adding Borders To Shape");
    }

    private void setCustomColor(Shape shape) {
        System.out.println("Adding Colors To Shape");
    }
}
