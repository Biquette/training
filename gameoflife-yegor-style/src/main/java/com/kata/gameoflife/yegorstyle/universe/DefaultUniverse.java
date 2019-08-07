package com.kata.gameoflife.yegorstyle.universe;

import com.kata.gameoflife.yegorstyle.utils.Coordinates;
import com.kata.gameoflife.yegorstyle.NaturalSelection;
import com.kata.gameoflife.yegorstyle.cell.Cell;
import com.kata.gameoflife.yegorstyle.grid.Grid;
import com.kata.gameoflife.yegorstyle.printer.Printer;

public class DefaultUniverse implements Universe {

    private Grid grid;

    public DefaultUniverse(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void goForwardInTime(int numberOfTurns) {
        while (numberOfTurns > 0) {
            numberOfTurns--;
            this.evolve();
        }
    }

    private void evolve() {
        this.exploreGrid();
        this.migrateFullGrid();
    }

    private void exploreGrid() {
        for (int i = 0; i < this.grid.xSize(); i++) {
            for (int j = 0; j < this.grid.ySize(); j++) {
                Coordinates currentCoordinates = new Coordinates(i, j);
                Cell cell = this.grid.get(currentCoordinates);
                if (cell.isAlive()) {
                    this.indicateLivingStateToNeighbours(currentCoordinates);
                }
            }
        }
    }

    private void migrateFullGrid() {
        for (int i = 0; i < this.grid.xSize(); i++) {
            for (int j = 0; j < this.grid.ySize(); j++) {
                Coordinates currentCoordinates = new Coordinates(i, j);
                this.grid.set(currentCoordinates, new NaturalSelection(this.grid.get(currentCoordinates)).cell());
            }
        }
    }

    private void indicateLivingStateToNeighbours(Coordinates studiedCellCoordinates) {
        for (int i = studiedCellCoordinates.x() - 1; i <= studiedCellCoordinates.x() + 1; i++) {
            for (int j = studiedCellCoordinates.y() - 1; j <= studiedCellCoordinates.y() + 1; j++) {

                Coordinates neighbourCoordinates = new Coordinates(i, j);
                if (this.grid.isInsideBounds(neighbourCoordinates)) {
                    Cell cell = this.grid.get(neighbourCoordinates);

                    if (!this.isSameLocation(studiedCellCoordinates, neighbourCoordinates)) {
                        cell.hasALivingNeighbour();
                    }
                }
            }
        }
    }

    private boolean isSameLocation(Coordinates first, Coordinates second) {
        return first.x() == second.x() && first.y() == second.y();
    }

    @Override
    public Printer print(Printer media) {
        return this.grid.print(media);
    }
}