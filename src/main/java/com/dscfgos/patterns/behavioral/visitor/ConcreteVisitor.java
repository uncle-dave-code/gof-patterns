package com.dscfgos.patterns.behavioral.visitor;

public class ConcreteVisitor implements Visitor{
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("Visit Element A");
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("Visit Element B");
    }
}
