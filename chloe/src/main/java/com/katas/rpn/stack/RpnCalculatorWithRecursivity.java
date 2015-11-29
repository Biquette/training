package com.katas.rpn.stack;

import com.katas.rpn.stack.operators.Operator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Chloé Mahalin
 */
public class RpnCalculatorWithRecursivity {

    public int calculate(String input) throws CalculationException {
        return calculate(reverse(input.split(" ")));
    }


    public static int calculate(List<String> tokens) {
        final String token = tokens.remove(0);
        if (isANumber(token)) {
            return Integer.valueOf(token);
        }
        else {
            return Operator.getOperatorFromString(token).compute(tokens);
        }
    }


    public List<String> reverse(String[] tokens) {
        List<String> list = new ArrayList<String>(Arrays.asList(tokens));
        Collections.reverse(list);
        return list;
    }


    public static boolean isANumber(String number) {
        return number.matches("[0-9]*");
    }

}
