package com.dscfgos.patterns.creational.abstract_factory.interfaces;

import com.dscfgos.patterns.creational.abstract_factory.classes.ShapeType;

public interface AbstractFactory {
    Shape createShape(ShapeType type);
}
