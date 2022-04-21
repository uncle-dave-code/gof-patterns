package com.dscfgos.patterns.behavioral.mediator;

public class ConcreteColleage extends Colleague<String> {

    public ConcreteColleage(String id, Mediator<String> mediator) {
        super(id, mediator);
    }

    @Override
    public void send(Message<String> message) {
        message.setFromColleague(this.getId());
        System.out.printf("Sending message from %s to %s%n", message.getFromColleague(), message.getToColleague());
        this.getMediator().doMediation(message);
    }

    @Override
    public void receive(Message<String> message) {
        System.out.printf("Receiving message from %s : %s%n%n", message.getFromColleague(), message.getMessage());
    }
}
