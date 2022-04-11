package com.dscfgos.patterns.creational.builder;

import java.time.LocalDateTime;

public class ImmutableUser {
    private final String firstname;
    private final String lastname;
    private final String gender;
    private final String address;
    private final LocalDateTime birthday;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public ImmutableUser(UserBuilder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.gender = builder.gender;
        this.address = builder.address;
        this.birthday = builder.birthday;
    }

    @Override
    public String toString() {
        return "Immutable User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    public static class UserBuilder {
        private final String firstname;   //REQUIRED FIELDS
        private final String lastname;    //REQUIRED FIELDS
        private String gender;
        private String address;
        private LocalDateTime birthday;

        public UserBuilder(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public UserBuilder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder withBirthday(LocalDateTime birthday) {
            this.birthday = birthday;
            return this;
        }

        public ImmutableUser build() {
            return new ImmutableUser(this);
        }
    }
}
