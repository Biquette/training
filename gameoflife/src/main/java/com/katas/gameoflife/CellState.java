package com.katas.gameoflife;

/**
 * Created by Chloé Mahalin
 */
public enum CellState {
    ALIVE('*'), DEAD('.');

    private final char symbol;

    private CellState(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static CellState getStateFromSymbol(char symbol) {
        return symbol == '*' ? ALIVE : DEAD;
    }
}
