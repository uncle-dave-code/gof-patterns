package com.dscfgos.patterns.creational.builder;

import java.time.LocalDateTime;

public class UserBuilder {
    private final String firstname;   //REQUIRED FIELDS
    private final String lastname;    //REQUIRED FIELDS
    private String gender;
    private String address;
    private LocalDateTime birthday;

    public UserBuilder(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserBuilder withGender(String gender){
        this.gender = gender;
        return this;
    }

    public UserBuilder withAddress(String address){
        this.address = address;
        return this;
    }

    public UserBuilder withBirthday(LocalDateTime birthday){
        this.birthday = birthday;
        return this;
    }

    public User build(){
        User user = new User();
        user.setFirstname(this.firstname);
        user.setLastname(this.lastname);
        user.setGender(this.gender);
        user.setAddress(this.address);
        user.setBirthday(this.birthday);

        return user;
    }
}
