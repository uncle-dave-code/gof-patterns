package com.dscfgos.patterns.behavioral.visitor;

public interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}
