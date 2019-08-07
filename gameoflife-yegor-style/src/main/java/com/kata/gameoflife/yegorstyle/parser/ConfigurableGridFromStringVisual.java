package com.kata.gameoflife.yegorstyle.parser;

import com.kata.gameoflife.yegorstyle.utils.Coordinates;
import com.kata.gameoflife.yegorstyle.cell.Cell;
import com.kata.gameoflife.yegorstyle.cell.CellState;
import com.kata.gameoflife.yegorstyle.grid.ConfigurableGrid;
import com.kata.gameoflife.yegorstyle.utils.StringVisualRepresentation;

public class ConfigurableGridFromStringVisual {

    private String textualRepresentation;

    public ConfigurableGridFromStringVisual(String textualRepresentation) {
        this.textualRepresentation = textualRepresentation;
    }

    public ConfigurableGrid generate() {

        String[] lines = this.textualRepresentation.split("\n");
        ConfigurableGrid grid = new ConfigurableGrid(lines[0].length(), lines.length);

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            for (int j = 0; j < line.length(); j++) {
                grid.set(new Coordinates(i, j), new Cell(line.charAt(j) == StringVisualRepresentation.ALIVE_CELL_REPRESENTATION ? CellState.ALIVE : CellState.DEAD));
            }
        }

        return grid;
    }
}