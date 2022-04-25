package com.dscfgos.patterns.behavioral.interpreter.arithmetic;

import com.dscfgos.patterns.behavioral.interpreter.Expression;
import com.dscfgos.patterns.behavioral.interpreter.NonTerminalExpression;

public class AdditionExpression implements NonTerminalExpression<Double> {
    private Expression<Double> firstExpression;
    private Expression<Double> secondExpression;

    @Override
    public Double interpret() {
        return this.firstExpression.interpret() + this.secondExpression.interpret();
    }

    public void setValues(Expression<Double> firstExpression, Expression<Double> secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public String toString() {
        return "+";
    }
}
