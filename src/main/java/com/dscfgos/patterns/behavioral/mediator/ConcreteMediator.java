package com.dscfgos.patterns.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator implements Mediator<String> {
    private final Map<String, Colleague<String>> mapColleagues;

    public ConcreteMediator() {
        this.mapColleagues = new HashMap<>();
    }

    public void addColleague(Colleague<String> colleague) {
        this.mapColleagues.put(colleague.getId(), colleague);
    }

    @Override
    public void doMediation(Message<String> message) {
        var colleague = this.mapColleagues.get(message.getToColleague());
        if (colleague != null) {
            colleague.receive(message);
        } else {
            throw new RuntimeException("Colleague not found");
        }
    }
}
