/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.katas.rpn.ast;

/**
 *
 * @author Chloé Mahalin
 */
public class Literal implements Node {

    private final int literal;


    public Literal(int literal) {
        this.literal = literal;
    }


    public int getLiteral() {
        return literal;
    }


    @Override
    public String render() {
        return Integer.toString(literal);
    }


    @Override
    public int eval() {
        return literal;
    }


    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitLiteral(this);
    }
}
