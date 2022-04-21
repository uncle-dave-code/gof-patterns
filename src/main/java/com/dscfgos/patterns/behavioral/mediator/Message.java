package com.dscfgos.patterns.behavioral.mediator;

public class Message<T> {
    private String fromColleague;
    private final String toColleague;

    private final T message;

    public Message(String toColleague, T message) {
        this.toColleague = toColleague;
        this.message = message;
    }

    public String getFromColleague() {
        return fromColleague;
    }

    public void setFromColleague(String fromColleague) {
        this.fromColleague = fromColleague;
    }

    public String getToColleague() {
        return toColleague;
    }

    public T getMessage() {
        return message;
    }
}
