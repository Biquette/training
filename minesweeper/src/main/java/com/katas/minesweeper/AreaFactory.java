package com.katas.minesweeper;

/**
 * @author Chloé Mahalin
 */
public class AreaFactory {

    public static IArea createNewArea(String type, String... rows) {
        if ("square".equals(type)) {
            SquareArea area = new SquareArea(rows);
            return area;
        } else if ("array".equals(type)) {
            ArrayArea area = new ArrayArea(rows);
            return area;
        }
        return null;
    }

}
