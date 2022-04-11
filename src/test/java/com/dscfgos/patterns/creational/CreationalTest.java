package com.dscfgos.patterns.creational;

import com.dscfgos.patterns.creational.builder.ImmutableUser;
import com.dscfgos.patterns.creational.builder.UserBuilder;
import com.dscfgos.patterns.creational.prototype.CloneableUser;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreationalTest {

    Logger logger = Logger.getLogger(CreationalTest.class.getName());

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void testBuilder() {
        var builder = new UserBuilder("Uncle", "Dave Code");
        var user = builder.withGender("Male")
                .withAddress("Some Address")
                .withBirthday(LocalDateTime.of(1979, Month.DECEMBER, 11, 0, 0))
                .build();


        var immutableUser = new ImmutableUser.UserBuilder("Uncle", "Dave Code")
                .withGender("Male")
                .withAddress("Some Address")
                .withBirthday(LocalDateTime.of(1979, Month.DECEMBER, 11, 0, 0))
                .build();

        logger.log(Level.INFO, user.toString());
        logger.log(Level.INFO, immutableUser.toString());

        assertEquals("User{firstname='Uncle', lastname='Dave Code'}", user.toString());
        assertEquals("Immutable User{firstname='Uncle', lastname='Dave Code'}", immutableUser.toString());
    }

    @org.junit.jupiter.api.Test
    void testPrototype() {
        var cloneableUser = new CloneableUser();
        cloneableUser.setFirstname("Uncle");
        cloneableUser.setLastname("Dave Code");
        cloneableUser.setGender("Male");
        cloneableUser.setAddress("Some Address");
        cloneableUser.setBirthday(LocalDateTime.of(1979, Month.DECEMBER, 11, 0, 0));

        var copyUser = cloneableUser.copy();

        logger.log(Level.INFO, copyUser.toString());

        assertEquals("User{firstname='Uncle', lastname='Dave Code'}", copyUser.toString());
    }
}