package com.dscfgos.patterns.creational.prototype;

import java.time.LocalDateTime;

public class CloneableUser implements Prototype<CloneableUser> {
    private String firstname;
    private String lastname;
    private String gender;
    private String address;
    private LocalDateTime birthday;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public CloneableUser copy() {
        CloneableUser copyCloneableUser = new CloneableUser();
        copyCloneableUser.setFirstname(this.firstname);
        copyCloneableUser.setLastname(this.lastname);
        copyCloneableUser.setGender(this.gender);
        copyCloneableUser.setAddress(this.address);
        copyCloneableUser.setBirthday(this.birthday);
        return copyCloneableUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
