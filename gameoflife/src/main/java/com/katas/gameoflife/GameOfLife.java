package com.katas.gameoflife;

/**
 * @author Chloé Mahalin
 */
public class GameOfLife {


    public String evolve(int numberOfSteps, Universe universe) {
        if (universe != null && universe.getXSize() > 0 && universe.getYSize() > 0) {
            for (int step = 0; step < numberOfSteps; step++) {
                universe = evolve(universe);
            }
        }

        return universe.toString();
    }

    public Universe evolve(Universe universe) {
        Universe toReturn = Universe.createUniverse(universe.getXSize(), universe.getYSize());
        for (int x = 0; x < universe.getXSize(); x++) {
            for (int y = 0; y < universe.getYSize(); y++) {
                toReturn.setCellState(x, y, calculateCellState(universe.getCellState(x, y), countLivingNeighbours(x, y, universe)));
            }
        }
        return toReturn;
    }

    public int countLivingNeighbours(int xCoordinate, int yCoordinate, Universe universe) {
        int counter = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (isNotCurrentCell(dx, dy) && isCellAlive(universe, xCoordinate, dx, yCoordinate, dy)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean isCellAlive(Universe universe, int xCoordinate, int dx, int yCoordinate, int dy) {
        return universe.getCellState(xCoordinate + dx, yCoordinate + dy) == CellState.ALIVE;
    }

    private boolean isNotCurrentCell(int dx, int dy) {
        return dx != 0 || dy != 0;
    }


    public CellState calculateCellState(CellState cellState, int numberOfNeighbours) {
        if ((cellState == CellState.ALIVE && (numberOfNeighbours == 2 || numberOfNeighbours == 3))
                || (cellState == CellState.DEAD && numberOfNeighbours == 3)) {
            return CellState.ALIVE;
        }
        return CellState.DEAD;
    }


}
