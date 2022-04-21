package com.dscfgos.patterns.behavioral.chain_responsibility;

public class ThirdTaskHandler extends ChainHandler {

    public ThirdTaskHandler(ChainHandler nextChainHandler) {
        super(nextChainHandler);
    }

    @Override
    public Request handleRequest(Request request) {
        if (request == Request.DO_THIRD) {
            System.out.println("Doing Third Handler Task!!!");
            return request;
        } else if (this.getNextChainHandler() != null) {
            System.out.println("Pass Handler Task from Third!!!");
            return this.getNextChainHandler().handleRequest(request);
        } else {
            throw new RuntimeException("Bad chain handler");
        }

    }
}
