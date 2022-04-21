package com.dscfgos.patterns.behavioral.command;

public class OperationA implements Command {
    private final String operationName;

    public OperationA(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public void execute() {
        System.out.printf("Execute operation A: %s%n", operationName);
    }
}
