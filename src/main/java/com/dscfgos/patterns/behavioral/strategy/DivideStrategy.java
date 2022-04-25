package com.dscfgos.patterns.behavioral.strategy;

public class DivideStrategy implements Strategy{
    @Override
    public Double doStrategy(Double number1, Double number2) {
        return number1 / number2;
    }
}
