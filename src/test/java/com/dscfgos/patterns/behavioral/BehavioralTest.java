package com.dscfgos.patterns.behavioral;

import com.dscfgos.patterns.behavioral.chain_responsibility.ChainResponsibility;
import com.dscfgos.patterns.behavioral.chain_responsibility.Request;
import com.dscfgos.patterns.behavioral.command.OperationA;
import com.dscfgos.patterns.behavioral.command.OperationB;
import com.dscfgos.patterns.behavioral.iterator.CustomCollection;
import com.dscfgos.patterns.behavioral.iterator.Item;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class BehavioralTest {

    Logger logger = Logger.getLogger(BehavioralTest.class.getName());

    @org.junit.jupiter.api.Test
    void testChainOfResponsibility() {
        ChainResponsibility chainResponsibility = new ChainResponsibility();

        assertAll(
                () -> assertEquals(Request.DO_FIRST, chainResponsibility.processChain(Request.DO_FIRST)),
                () -> assertEquals(Request.DO_SECOND, chainResponsibility.processChain(Request.DO_SECOND)),
                () -> assertEquals(Request.DO_THIRD, chainResponsibility.processChain(Request.DO_THIRD)),
                () -> assertThrows(RuntimeException.class, () -> chainResponsibility.processChain(Request.DO_FOURTH))
        );
    }

    @org.junit.jupiter.api.Test
    void testCommand() {
        var operations = List.of(
                new OperationA("1"),
                new OperationB("1"),
                new OperationA("2"),
                new OperationB("2"),
                new OperationA("3"),
                new OperationB("4")
        );

        for (var operation: operations) {
            operation.execute();
        }
    }

    @org.junit.jupiter.api.Test
    void testIterator() {
        var items = new Item[]{
                new Item("code1", "name1"),
                new Item("code2", "name2"),
                new Item("code3", "name3")};

        CustomCollection<Item> itemsCollection = new CustomCollection<>(items);

        var iterator = itemsCollection.getIterator();
        while (iterator.hasNext()){
            var item = iterator.next();
            System.out.printf("Code %s : Name: %s%n", item.getCode(), item.getName());
        }
    }
}