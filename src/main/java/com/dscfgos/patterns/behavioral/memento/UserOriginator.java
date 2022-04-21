package com.dscfgos.patterns.behavioral.memento;

public class UserOriginator {
    private long id;
    private String email;
    private String name;
    private String lastName;

    public UserOriginator(long id, String email, String name, String lastName) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserMemento createMemento() {
        return new UserMemento(this.id, this.email, this.name, this.lastName);
    }

    public void restore(UserMemento userMemento) {
        this.id = userMemento.getId();
        this.email = userMemento.getEmail();
        this.name = userMemento.getName();
        this.lastName = userMemento.getLastName();
    }

    @Override
    public String toString() {
        return "UserOriginator{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
