package com.dscfgos.patterns.behavioral.interpreter.interfaces;

public interface NonTerminalExpression<T> extends Expression<T> {
    void setValues(Expression<Double> firstExpression, Expression<Double> secondExpression);
}
