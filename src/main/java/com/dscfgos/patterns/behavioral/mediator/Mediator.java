package com.dscfgos.patterns.behavioral.mediator;

public interface Mediator<T> {

    void doMediation(Message<T> message);

    void addColleague(Colleague<T> colleague);
}
