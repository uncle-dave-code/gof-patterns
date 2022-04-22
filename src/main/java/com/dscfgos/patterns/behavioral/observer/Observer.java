package com.dscfgos.patterns.behavioral.observer;

public interface Observer<T> {
    void handleEvent(CustomEvent<T> event);
}
