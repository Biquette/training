package com.kata.gameoflife.yegorstyle.grid;

import com.kata.gameoflife.yegorstyle.cell.Cell;
import com.kata.gameoflife.yegorstyle.utils.Coordinates;
import com.kata.gameoflife.yegorstyle.cell.CellState;
import com.kata.gameoflife.yegorstyle.printer.Printer;

public class RandomGrid implements Grid {

    private Grid grid;

    public RandomGrid(int xSize, int ySize) {
        this.grid = new DefaultGrid(xSize, ySize);
        this.populateWithRandomCells();
    }

    private void populateWithRandomCells() {
        for (int i = 0; i < this.grid.xSize(); i++) {
            for (int j = 0; j < this.grid.ySize(); j++) {
                this.grid.set(new Coordinates(i, j), new Cell(randomBoolean() ? CellState.ALIVE : CellState.DEAD));
            }
        }
    }

    private boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    @Override
    public void set(Coordinates coordinates, Cell cell) {
        this.grid.set(coordinates, cell);
    }

    @Override
    public Cell get(Coordinates coordinates) {
        return this.grid.get(coordinates);
    }

    @Override
    public boolean isInsideBounds(Coordinates coordinates) {
        return this.grid.isInsideBounds(coordinates);
    }

    @Override
    public int xSize() {
        return this.grid.xSize();
    }

    @Override
    public int ySize() {
        return this.grid.ySize();
    }

    @Override
    public Printer print(Printer media) {
        return this.grid.print(media);
    }
}