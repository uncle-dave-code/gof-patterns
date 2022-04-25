package com.dscfgos.patterns.behavioral.strategy;

public class MultiplyStrategy implements Strategy{
    @Override
    public Double doStrategy(Double number1, Double number2) {
        return number1 * number2;
    }
}
