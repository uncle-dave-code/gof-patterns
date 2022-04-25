package com.dscfgos.patterns.behavioral.interpreter.interfaces.arithmetic;

import com.dscfgos.patterns.behavioral.interpreter.interfaces.TerminalExpression;

public class DoubleNumber implements TerminalExpression<Double> {
    private final Double number;

    public DoubleNumber(Double number) {
        this.number = number;
    }

    public DoubleNumber(String number) {
        this.number = Double.valueOf(number);
    }

    @Override
    public Double interpret() {
        return this.number;
    }
}
