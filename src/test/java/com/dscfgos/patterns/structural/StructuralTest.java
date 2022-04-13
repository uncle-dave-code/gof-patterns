package com.dscfgos.patterns.structural;

import com.dscfgos.patterns.structural.adapter.BigBox;
import com.dscfgos.patterns.structural.adapter.Measurable;
import com.dscfgos.patterns.structural.adapter.MeasurableAdapter;
import com.dscfgos.patterns.structural.adapter.MeasurableAdapterImpl;
import com.dscfgos.patterns.structural.bridge.Car;
import com.dscfgos.patterns.structural.bridge.ConcreteCar;
import com.dscfgos.patterns.structural.bridge.Green;
import com.dscfgos.patterns.structural.bridge.Red;

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
}