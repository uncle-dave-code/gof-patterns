package com.dscfgos.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public Shape getShape(ShapeType shapeType, Color color) {
        Shape result = null;

        if (shapeType != null && color != null) {
            String key = this.getKey(shapeType, color);
            result = shapeMap.get(key);

            if (result == null) {
                switch (shapeType){
                    case CIRCLE:
                        result = new Circle(color);
                        break;
                    case RECTANGLE:
                        result = new Rectangle(color);
                        break;
                    case TRIANGLE:
                        result = new Triangle(color);
                        break;
                }
                shapeMap.put(key, result);
            }
        }

        return result;
    }

    public int getShapePoolSize(){
        return shapeMap.size();
    }

    private String getKey(ShapeType shapeType, Color color) {
        return shapeType + ":" + color.getColor();
    }
}
