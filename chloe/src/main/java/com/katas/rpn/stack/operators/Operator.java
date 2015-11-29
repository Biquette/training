package com.katas.rpn.stack.operators;

import static com.katas.rpn.stack.RpnCalculatorWithRecursivity.calculate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Chloé Mahalin
 */
public enum Operator implements IOperator {

    DIVIDED("/") {
            @Override
            public int compute(List<String> numbers) {
                int b = calculate(numbers);
                int a = calculate(numbers);
                return a / b;
            }
        },
    MINUS("-") {
            @Override
            public int compute(List<String> numbers) {
                int b = calculate(numbers);
                int a = calculate(numbers);
                return a - b;
            }
        },
    MULTIPLIED("*") {
            @Override
            public int compute(List<String> numbers) {
                int b = calculate(numbers);
                int a = calculate(numbers);
                return a * b;
            }
        },
    PLUS("+") {
            @Override
            public int compute(List<String> numbers) {
                int b = calculate(numbers);
                int a = calculate(numbers);
                return a + b;
            }
        },
    SQRT("sqrt") {
            @Override
            public int compute(List<String> numbers) {
                return (int) Math.sqrt(calculate(numbers));
            }
        },
    MAX("max") {
            @Override
            public int compute(List<String> numbers) {
                List<Integer> values = new ArrayList<Integer>();
                while (!numbers.isEmpty()) {
                    values.add(calculate(numbers));
                }
                return Collections.max(values);
            }
        },
    MIN("min") {
            @Override
            public int compute(List<String> numbers) {
                return 0;
            }
        },
    SQUARED("squared") {
            @Override
            public int compute(List<String> numbers) {
                return (int) Math.pow(calculate(numbers), 2);
            }
        };

    protected String symbol;


    private Operator(String symbol) {
        this.symbol = symbol;
    }


    public String getSymbol() {
        return symbol;
    }


    public static Operator getOperatorFromString(String stringOperator) {

        for (Operator operator : Operator.values()) {
            if (operator.getSymbol().equals(stringOperator)) {
                return operator;
            }
        }
        throw new RuntimeException("No operator for " + stringOperator);
    }

}
