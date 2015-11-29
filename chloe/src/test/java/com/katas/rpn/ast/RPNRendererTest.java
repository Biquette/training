/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.katas.rpn.ast;

import org.junit.Test;


/**
 *
 * @author Chloé Mahalin
 */
public class RPNRendererTest {

    @Test
    public void test_with_one_literal() {
//        Assert.assertEquals("4", render(literal(4)));
    }


    @Test
    public void test_with_addition() {
//        Assert.assertEquals("1 1 +", render(add(literal(1), literal(1))));
    }


    @Test
    public void test_with_deep_addition() {
//        Assert.assertEquals("1 1 + 2 +", render(add(add(literal(1), literal(1)), literal(2))));
//        Assert.assertEquals("1 1 2 + +", render(add(literal(1), add(literal(1), literal(2)))));
    }


    @Test
    public void test_with_subtraction() {
//        Assert.assertEquals("1 1 -", render(sub(literal(1), literal(1))));
    }


    @Test
    public void test_with_sqrt() {
//        Assert.assertEquals("1 sqrt", render(sqrt(literal(1))));
    }


    @Test
    public void test_with_complex() {
//        Assert.assertEquals("1 sqrt 1 +", render(add(sqrt(literal(1)), literal(1))));
    }

    private static String render(Node node) {
        RPNRenderer renderer = new RPNRenderer();
        node.accept(renderer);
        return renderer.render();
    }
}
