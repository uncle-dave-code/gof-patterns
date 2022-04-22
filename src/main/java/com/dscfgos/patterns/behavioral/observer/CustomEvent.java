package com.dscfgos.patterns.behavioral.observer;

public class CustomEvent<T> {
    private final T value;

    public CustomEvent(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
