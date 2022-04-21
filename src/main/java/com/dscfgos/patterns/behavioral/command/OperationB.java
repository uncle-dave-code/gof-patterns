package com.dscfgos.patterns.behavioral.command;

public class OperationB implements Command {
    private final String operationName;

    public OperationB(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public void execute() {
        System.out.printf("Execute operation B: %s%n", operationName);
    }
}
