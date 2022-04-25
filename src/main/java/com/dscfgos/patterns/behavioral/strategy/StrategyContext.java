package com.dscfgos.patterns.behavioral.strategy;

public class StrategyContext {
    private final Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public Double executeStrategy(Double number1, Double number2) {
        return strategy.doStrategy(number1, number2);
    }
}
