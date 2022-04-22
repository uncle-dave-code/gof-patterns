package com.dscfgos.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {

    private final List<Observer<T>> observers = new ArrayList<>();

    public void addEventListener(Observer<T> observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    public void removeEventListener(Observer<T> observer) {
        this.observers.remove(observer);
    }

    public void dispatchEvent(CustomEvent<T> event) {
        for (var observer : observers) {
            observer.handleEvent(event);
        }
    }
}
