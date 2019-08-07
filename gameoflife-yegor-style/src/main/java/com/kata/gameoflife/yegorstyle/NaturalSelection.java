package com.kata.gameoflife.yegorstyle;

import com.kata.gameoflife.yegorstyle.cell.Cell;
import com.kata.gameoflife.yegorstyle.cell.CellState;

public class NaturalSelection {

    private final Cell cell;

    public NaturalSelection(Cell cell) {
        this.cell = cell;
    }

    private Cell investigateSustainability() {
        if (this.isConcernedByUnderpopulation() || this.isConcernedByOverPopulation()) {
            return new Cell(CellState.DEAD);
        } else if (this.hasThreeLivingNeighbours()) {
            return new Cell(CellState.ALIVE);
        }
        //else : no change
        return new Cell(this.cell.state());
    }

    private boolean isConcernedByOverPopulation() {
        return this.cell.numberOfNeighbours() > 3;
    }

    private boolean hasThreeLivingNeighbours() {
        return this.cell.numberOfNeighbours() == 3;
    }

    private boolean isConcernedByUnderpopulation() {
        return this.cell.numberOfNeighbours() < 2;
    }

    public Cell cell() {
        return this.investigateSustainability();
    }

}