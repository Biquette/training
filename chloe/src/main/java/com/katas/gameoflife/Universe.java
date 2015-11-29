package com.katas.gameoflife;

/**
 * Created by Chloé Mahalin
 */
public class Universe {

    // Variable final pour des variables jamais réinitialisées après le constructeur :
    private CellState[][] universe;

    // Variable final pour des variables jamais réinitialisées après le constructeur :
    private int xSize;

    // Variable final pour des variables jamais réinitialisées après le constructeur :
    private int ySize;

    private Universe(int xSize, int ySize) {
        this.universe = new CellState[xSize][ySize];
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public int getXSize() {
        return this.xSize;
    }

    public int getYSize() {
        return this.ySize;
    }

    public void setCellState(int xCoordinate, int yCoordinate, CellState newState) {
        this.universe[xCoordinate][yCoordinate] = newState;
    }

    private boolean isBetween(int value, int min, int max) {
        return min <= value && value < max;
    }

    public CellState getCellState(int xCoordinate, int yCoordinate) {
        if (this.isBetween(xCoordinate, 0, this.xSize) && this.isBetween(yCoordinate, 0, this.ySize)) {
            return this.universe[xCoordinate][yCoordinate];
        }

        if (xCoordinate >= 0 && yCoordinate >= 0 && xCoordinate < this.getXSize() && yCoordinate < this.getYSize()) {
            return this.universe[xCoordinate][yCoordinate];
        }
        return CellState.DEAD;
    }

    @Override
    public String toString() {
        // @Bichon : Si tu connais (à peu près) la taille finale de ta String, alors indique la dans le constructeur du StringBuilder :
        StringBuilder toReturn = new StringBuilder();

        for (int x = 0; x < this.xSize; x++) {
            for (int y = 0; y < this.ySize; y++) {
                toReturn.append(this.universe[x][y].getSymbol());
            }
            if (x < this.getXSize() - 1) {
                // Les String sont très coûteuses à instancier, il vaut mieux ajouter un char qu'un String :
                toReturn.append("\n");
            }
        }

        return toReturn.toString();
    }

    public static Universe createUniverse(String... universeLines) {
        Universe toReturn = new Universe(0, 0);
        if (universeLines.length > 0 && !universeLines[0].isEmpty()) {
            toReturn = new Universe(universeLines.length, universeLines[0].length());

            for (int i = 0; i < toReturn.getXSize(); i++) {
                for (int j = 0; j < toReturn.getYSize(); j++) {
                    toReturn.setCellState(i, j, CellState.getStateFromSymbol(universeLines[i].charAt(j)));
                }
            }
        }
        return toReturn;
    }

    public static Universe createUniverse(int xSize, int ySize) {
        return new Universe(xSize, ySize);
    }
}
