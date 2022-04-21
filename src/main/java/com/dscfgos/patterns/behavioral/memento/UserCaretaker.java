package com.dscfgos.patterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class UserCaretaker {
    private final List<UserMemento> mementoList = new ArrayList<>();

    public void add(UserMemento userMemento) {
        this.mementoList.add(userMemento);
    }

    public UserMemento get(int index) {
        return this.mementoList.get(index);
    }
}
