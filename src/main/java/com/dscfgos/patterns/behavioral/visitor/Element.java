package com.dscfgos.patterns.behavioral.visitor;

public interface Element {
    void accept(Visitor visitor);
}
