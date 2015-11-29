package com.katas.rpn.ast;

/**
 *
 * @author Chloé Mahalin
 */
public class NodeFactory {
    public static Node literal(int value) {
        return new Literal(value);
    }

    public static Node add(Node left, Node right) {
        return new BinaryOperation(left, right, BinaryOperator.PLUS);
    }

    public static Node sub(Node left, Node right) {
        return new BinaryOperation(left, right, BinaryOperator.MINUS);
    }

    public static Node sqrt(Node left) {
        return new UnaryOperation(left, UnaryOperator.SQRT);
    }
}
