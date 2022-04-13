package com.dscfgos.patterns.structural.adapter;

public class BigBox implements Measurable{
    @Override
    public double getInches() {
        return 1000;
    }
}
