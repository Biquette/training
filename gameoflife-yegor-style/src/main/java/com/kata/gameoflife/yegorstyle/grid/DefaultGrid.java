package com.kata.gameoflife.yegorstyle.grid;

import com.kata.gameoflife.yegorstyle.cell.Cell;
import com.kata.gameoflife.yegorstyle.utils.Coordinates;
import com.kata.gameoflife.yegorstyle.printer.Printer;

public class DefaultGrid implements Grid {

    private final Cell[][] matrix;
    private final int xSize;
    private final int ySize;

    public DefaultGrid(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.matrix = new Cell[xSize][ySize];
    }

    @Override
    public void set(Coordinates coordinates, Cell cell) {
        this.matrix[coordinates.x()][coordinates.y()] = cell;
    }

    @Override
    public Cell get(Coordinates coordinates) {
        return this.matrix[coordinates.x()][coordinates.y()];
    }

    @Override
    public boolean isInsideBounds(Coordinates coordinates) {
        return coordinates.x() >= 0 && coordinates.y() >= 0 && coordinates.x() < this.xSize && coordinates.y() < this.ySize;
    }

    @Override
    public int xSize() {
        return this.xSize;
    }

    @Override
    public int ySize() {
        return this.ySize;
    }


    @Override
    public Printer print(Printer media) {
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                media = this.matrix[i][j].print(media);

                if (j == this.ySize - 1 && i != this.xSize - 1) {
                    media = media.with("\n");
                }
            }
        }
        return media;
    }
}