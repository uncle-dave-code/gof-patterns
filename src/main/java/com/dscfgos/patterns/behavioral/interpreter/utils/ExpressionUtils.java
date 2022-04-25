package com.dscfgos.patterns.behavioral.interpreter.utils;

import com.dscfgos.patterns.behavioral.interpreter.Expression;
import com.dscfgos.patterns.behavioral.interpreter.NonTerminalExpression;
import com.dscfgos.patterns.behavioral.interpreter.arithmetic.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExpressionUtils {
    private final String operators = "[ +*\\-/]";
    private final String operatorsRegEx = "((?=" + operators + ")|(?<=" + operators + "))";

    public String evaluateExpression(String expression) {
        String postFixExpression = convertToPostFixExpression(expression);
        Expression<Double> output = getExpressionFromPostFix(postFixExpression);

        return output.interpret().toString();
    }

    private NonTerminalExpression<Double> getNonTerminalExpression(String operator) {
        NonTerminalExpression<Double> result = null;
        switch (operator) {
            case "+":
                result = new AdditionExpression();
                break;
            case "-":
                result = new SubstractExpression();
                break;
            case "*":
                result = new MultiplyExpression();
                break;
            case "/":
                result = new DivisionExpression();
                break;
        }
        return result;
    }

    private Expression<Double> getExpressionFromPostFix(String postfix) {
        Expression<Double> output = null;
        if (postfix != null && !postfix.isBlank()) {
            List<Expression<Double>> items = splitPostfixExpression(postfix);
            Stack<Expression<Double>> stack = new Stack<>();

            for (var item : items) {
                if (item instanceof NonTerminalExpression) {
                    Expression<Double> val1 = stack.pop();
                    Expression<Double> val2 = stack.isEmpty() ? new DoubleNumber((Double) null) : stack.pop();
                    ((NonTerminalExpression<Double>) item).setValues(val2, val1);

                    stack.push(new DoubleNumber(item.interpret()));
                } else {
                    stack.push(item);
                }
            }
            output = stack.pop();

        }
        return output;
    }

    private int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    private List<Expression<Double>> splitPostfixExpression(String postfix) {
        return (postfix != null && !postfix.isBlank()) ? Arrays.stream(postfix.split(operatorsRegEx)).filter(token -> token.trim().length() > 0).map(token -> {
            if (isOperator(token)) {
                return getNonTerminalExpression(token);
            } else {
                return new DoubleNumber(token);
            }
        }).collect(Collectors.toList()) : null;
    }

    private List<String> splitDirective(String context) {
        return (context != null && !context.isBlank())
                ? Arrays.stream(context.split(operatorsRegEx))
                .map(String::trim)
                .filter(trim -> trim.length() > 0).collect(Collectors.toList())
                : null;
    }

    private String convertToPostFixExpression(String context) {
        StringBuilder output = new StringBuilder();

        List<String> expression = splitDirective(context);
        if (expression != null && !expression.isEmpty()) {
            Stack<String> stack = new Stack<>();
            for (var item : expression) {
                // If current item is an '(' then push it to the stack
                if (item.equals("(")) {
                    stack.push(item);
                }
                // If current item is an ')' then pop an add to output until '(' is encountered.
                else if (item.equals(")")) {
                    while (!stack.isEmpty()) {
                        String data = stack.pop();
                        if (data.equals("(")) {
                            break;
                        }
                        output.append(" ").append(data);
                    }
                }
                // If current item is an operator
                else if (isOperator(item)) {
                    while (!stack.isEmpty() && getPrecedence(item) <= getPrecedence(stack.peek())) {
                        output.append(" ").append(stack.pop());
                    }
                    stack.push(item);
                }
                // If the current item is an operand, output it.
                else {
                    output.append(" ").append(item);
                }
            }

            while (!stack.isEmpty()) {
                if (Objects.equals(stack.peek(), "("))
                    return "Invalid Expression";
                output.append(" ").append(stack.pop());
            }
        }
        return output.toString();
    }

    private boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }


}