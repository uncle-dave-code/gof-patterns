package com.dscfgos.patterns.behavioral.chain_responsibility;

public class FirstTaskHandler extends ChainHandler {

    public FirstTaskHandler(ChainHandler nextChainHandler) {
        super(nextChainHandler);
    }

    @Override
    public Request handleRequest(Request request) {
        if (request == Request.DO_FIRST) {
            System.out.println("Doing First Handler Task!!!");
            return request;
        } else if (this.getNextChainHandler() != null) {
            System.out.println("Pass Handler Task from First!!!");
            return this.getNextChainHandler().handleRequest(request);
        } else {
            throw new RuntimeException("Bad chain handler");
        }

    }
}
