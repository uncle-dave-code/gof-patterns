package com.dscfgos.patterns.behavioral.memento;

public final class UserMemento {
    private final long id;
    private final String email;
    private final String name;
    private final String lastName;

    public UserMemento(long id, String email, String name, String lastName) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
