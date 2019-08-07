package com.kata.gameoflife.yegorstyle.grid;

import com.kata.gameoflife.yegorstyle.cell.Cell;
import com.kata.gameoflife.yegorstyle.utils.Coordinates;
import com.kata.gameoflife.yegorstyle.printer.Printer;

public interface Grid {

    void set(Coordinates coordinates, Cell cell);

    Cell get(Coordinates coordinates);

    boolean isInsideBounds(Coordinates coordinates);

    int xSize();

    int ySize();

    Printer print(Printer media);
}