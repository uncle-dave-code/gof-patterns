package com.dscfgos.patterns.behavioral;

import com.dscfgos.patterns.behavioral.chain_responsibility.ChainResponsibility;
import com.dscfgos.patterns.behavioral.chain_responsibility.Request;

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
}