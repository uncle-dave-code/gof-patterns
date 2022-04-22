package com.dscfgos.patterns.behavioral.observer;

public class Observer3 implements Observer<String>{
    @Override
    public void handleEvent(CustomEvent<String> event) {
        System.out.printf("Observer 3, message from Subject: %s%n",event.getValue());
    }
}
