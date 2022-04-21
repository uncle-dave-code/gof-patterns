package com.dscfgos.patterns.behavioral.chain_responsibility;

public class ChainResponsibility {

    private FirstTaskHandler chain;

    public ChainResponsibility() {
        this.createChain();
    }

    private void createChain() {
        this.chain = new FirstTaskHandler(new SecondTaskHandler(new ThirdTaskHandler(null)));
    }

    public Request processChain(Request request) {
        return this.chain.handleRequest(request);
    }
}
