package com.dscfgos.patterns.behavioral.chain_responsibility;

public class SecondTaskHandler extends ChainHandler {

    public SecondTaskHandler(ChainHandler nextChainHandler) {
        super(nextChainHandler);
    }

    @Override
    public Request handleRequest(Request request) {
        if (request == Request.DO_SECOND) {
            System.out.println("Doing Second Handler Task!!!");
            return request;
        } else if (this.getNextChainHandler() != null) {
            System.out.println("Pass Handler Task from Second!!!");
            return this.getNextChainHandler().handleRequest(request);
        } else {
            throw new RuntimeException("Bad chain handler");
        }
    }
}
