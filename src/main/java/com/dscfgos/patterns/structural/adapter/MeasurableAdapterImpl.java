package com.dscfgos.patterns.structural.adapter;

public class MeasurableAdapterImpl implements MeasurableAdapter {

    private final Measurable measurable;

    public MeasurableAdapterImpl(Measurable measurable) {
        this.measurable = measurable;
    }

    @Override
    public double getMeters() {
        return measurable.getInches() * 0.0254;
    }
}
