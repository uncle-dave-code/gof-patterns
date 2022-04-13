package com.dscfgos.patterns.structural;

import com.dscfgos.patterns.structural.adapter.BigBox;
import com.dscfgos.patterns.structural.adapter.Measurable;
import com.dscfgos.patterns.structural.adapter.MeasurableAdapter;
import com.dscfgos.patterns.structural.adapter.MeasurableAdapterImpl;

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
}