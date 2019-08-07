package com.kata.gameoflife.yegorstyle.cell;

import com.kata.gameoflife.yegorstyle.printer.Printer;
import com.kata.gameoflife.yegorstyle.utils.StringVisualRepresentation;

public class Cell {

    private CellState state;
    private int numberOfNeighbours;

    public Cell(CellState cellState) {
        this.state = cellState;
        this.numberOfNeighbours = 0;
    }

    public CellState state() {
        return state;
    }

    public int numberOfNeighbours() {
        return numberOfNeighbours;
    }

    public boolean isAlive() {
        return state == CellState.ALIVE;
    }

    public void hasALivingNeighbour() {
        this.numberOfNeighbours++;
    }

    public Printer print(Printer media) {
        return media.with(String.valueOf(this.state == CellState.DEAD ? StringVisualRepresentation.DEAD_CELL_REPRESENTATION : StringVisualRepresentation.ALIVE_CELL_REPRESENTATION));
    }

}