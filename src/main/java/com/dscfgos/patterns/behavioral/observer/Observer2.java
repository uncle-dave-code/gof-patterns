package com.dscfgos.patterns.behavioral.observer;

public class Observer2 implements Observer<String>{
    @Override
    public void handleEvent(CustomEvent<String> event) {
        System.out.printf("Observer 2, message from Subject: %s%n",event.getValue());
    }
}
