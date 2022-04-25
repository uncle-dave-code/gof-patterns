package com.dscfgos.patterns.behavioral.visitor;

public class ConcreteElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
