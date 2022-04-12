package com.dscfgos.patterns.creational;

import com.dscfgos.patterns.creational.builder.ImmutableUser;
import com.dscfgos.patterns.creational.builder.UserBuilder;
import com.dscfgos.patterns.creational.factory_method.*;
import com.dscfgos.patterns.creational.prototype.CloneableUser;
import com.dscfgos.patterns.creational.singleton.EagerSingleton;
import com.dscfgos.patterns.creational.singleton.LazySingleton;
import com.dscfgos.patterns.creational.singleton.ThreadSafeSingleton;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

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

        assertAll(
                () -> assertEquals("User{firstname='Uncle', lastname='Dave Code'}", user.toString()),
                () -> assertEquals("Immutable User{firstname='Uncle', lastname='Dave Code'}", immutableUser.toString())
        );
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

    @org.junit.jupiter.api.Test
    void testFactoryMethod() {
        var shapeFactory = new ShapeFactory();
        var shape1 = shapeFactory.geShape(ShapeType.CIRCLE);
        var shape2 = shapeFactory.geShape(ShapeType.SQUARE);
        var shape3 = shapeFactory.geShape(ShapeType.TRIANGLE);

        shape1.draw();
        shape2.draw();
        shape3.draw();

        assertAll(
                () -> assertTrue(shape1 instanceof Circle),
                () -> assertTrue(shape2 instanceof Square),
                () -> assertTrue(shape3 instanceof Triangle)
        );
    }

    @org.junit.jupiter.api.Test
    void testSingleton() {
        var lazyInstance1 = LazySingleton.getInstance();
        var lazyInstance2 = LazySingleton.getInstance();

        var eagerInstance1 = EagerSingleton.getInstance();
        var eagerInstance2 = EagerSingleton.getInstance();

        var theadSafeInstance1 = ThreadSafeSingleton.getInstance();
        var theadSafeInstance2 = ThreadSafeSingleton.getInstance();

        assertAll(
                () -> assertEquals(lazyInstance1, lazyInstance2),
                () -> assertEquals(eagerInstance1, eagerInstance2),
                () -> assertEquals(theadSafeInstance1, theadSafeInstance2)
        );
    }
}