package com.dscfgos.patterns.structural.facade;

public class ShapeFacade {
    private final Shape circle ;
    private final Shape rectangle ;
    private final Shape triangle ;

    public ShapeFacade() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.triangle = new Triangle();
    }

    public void drawCircle(){
        this.circle.draw();
    }

    public void drawRectangle(){
        this.rectangle.draw();
    }

    public void drawTriangle(){
        this.triangle.draw();
    }
}
