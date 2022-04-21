package com.dscfgos.patterns.behavioral.mediator;

public abstract class Colleague<T> {

    private final String id;
    private final Mediator<T> mediator;

    public Colleague(String id, Mediator<T> mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    public abstract void send(Message<T> message);
    public abstract void receive(Message<T> message);

    public Mediator<T> getMediator() {
        return mediator;
    }

    public String getId() {
        return id;
    }
}
