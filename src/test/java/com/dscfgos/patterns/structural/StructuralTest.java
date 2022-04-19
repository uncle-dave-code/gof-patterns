package com.dscfgos.patterns.structural;

import com.dscfgos.patterns.structural.adapter.BigBox;
import com.dscfgos.patterns.structural.adapter.Measurable;
import com.dscfgos.patterns.structural.adapter.MeasurableAdapter;
import com.dscfgos.patterns.structural.adapter.MeasurableAdapterImpl;
import com.dscfgos.patterns.structural.bridge.Car;
import com.dscfgos.patterns.structural.bridge.ConcreteCar;
import com.dscfgos.patterns.structural.bridge.Green;
import com.dscfgos.patterns.structural.bridge.Red;
import com.dscfgos.patterns.structural.composite.CompositeCategory;
import com.dscfgos.patterns.structural.composite.LeafCategory;
import com.dscfgos.patterns.structural.decorator.Circle;
import com.dscfgos.patterns.structural.decorator.CustomShapeDecorator;
import com.dscfgos.patterns.structural.decorator.Rectangle;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StructuralTest {

    Logger logger = Logger.getLogger(StructuralTest.class.getName());

    @org.junit.jupiter.api.Test
    void testAdapter() {
        Measurable measurable = new BigBox();
        MeasurableAdapter measurableAdapter = new MeasurableAdapterImpl(measurable);

        logger.log(Level.INFO, String.valueOf(measurableAdapter.getMeters()));

        assertEquals("25.4", String.valueOf(measurableAdapter.getMeters()));

    }

    @org.junit.jupiter.api.Test
    void testBridge() {
        Car greenCar = new ConcreteCar(new Green());
        Car redCar = new ConcreteCar(new Red());
        logger.log(Level.INFO, String.valueOf(greenCar.paint()));
        logger.log(Level.INFO, String.valueOf(redCar.paint()));

        assertEquals("Painting with color: #00FF00", greenCar.paint());
        assertEquals("Painting with color: #FF0000", redCar.paint());
    }

    @org.junit.jupiter.api.Test
    void testComposite() {
        var leaf11 = new LeafCategory("Leaf 1.1");
        var leaf12 = new LeafCategory("Leaf 1.2");

        var leaf21 = new LeafCategory("Leaf 2.1");
        var leaf22 = new LeafCategory("Leaf 2.2");

        var composite2 = new CompositeCategory("Composite 2");
        composite2.addCategory(leaf21);
        composite2.addCategory(leaf22);

        var composite1 = new CompositeCategory("Composite 1");
        composite1.addCategory(leaf11);
        composite1.addCategory(leaf12);
        composite1.addCategory(composite2);

        composite1.showDetails();
    }

    @org.junit.jupiter.api.Test
    void testDecorator() {
        var shapeCircle = new Circle();
        var customShapeCircle = new CustomShapeDecorator(new Circle());
        var customShapeRectangle = new CustomShapeDecorator(new Rectangle());

        shapeCircle.draw();
        customShapeCircle.draw();
        customShapeRectangle.draw();
    }
}