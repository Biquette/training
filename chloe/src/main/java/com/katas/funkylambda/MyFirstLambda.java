package com.katas.funkylambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author © Kysofer & Biquette
 */
public class MyFirstLambda {
    List<String> names = Arrays.asList("babar", "tom", "pikachu", "pinky pie", "Romuald");

    public void searchList(Predicate<String> predicate) {
        for (String name : names) {
            if (predicate.test(name)) {
                System.out.println(name);
            }
        }
    }

    public static void main(String[] args) {
        MyFirstLambda lambda = new MyFirstLambda();
        lambda.searchList((String name) -> {
            return name.length() < 5;
        });
        lambda.searchList((String name) -> {
            return name.length() < 7;
        });
        lambda.searchList((String name) -> {
            return name.length() < 9;
        });
    }
}
