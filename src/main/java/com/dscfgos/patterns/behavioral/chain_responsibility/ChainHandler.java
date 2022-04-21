package com.dscfgos.patterns.behavioral.chain_responsibility;

public abstract class ChainHandler {

    private final ChainHandler nextChainHandler;

    public ChainHandler(ChainHandler nextChainHandler) {
        this.nextChainHandler = nextChainHandler;
    }

    public abstract Request handleRequest(Request request);

    public ChainHandler getNextChainHandler() {
        return nextChainHandler;
    }
}
