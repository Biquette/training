package com.katas.minesweeper;

/**
 * @author : Chloé Mahalin.
 * <p/>
 * L'avantage de l'array par rapport à la matrice consiste dans le nombre de pointeurs nécessaires.
 * Un array prend moins de mémoire d'une matrice
 */
public class ArrayArea implements IArea {

    protected final Square[] board;
    protected final int xSize;
    protected final int ySize;

    public ArrayArea(String... rows) {
        this.xSize = rows.length;
        this.ySize = rows[0].length();
        this.board = new Square[xSize * ySize];

        if (rows.length > 0 && !rows[0].isEmpty()) {
            for (int x = 0; x < this.xSize; x++) {
                for (int y = 0; y < this.ySize; y++) {
                    this.board[3 * y + x] = new Square();
                    this.board[3 * y + x].setState(MineState.getStateFromSymbol(rows[x].charAt(y)));
                }
            }
        }
    }

    @Override
    public int getXSize() {
        return this.xSize;
    }

    @Override
    public int getYSize() {
        return this.ySize;
    }

    @Override
    public boolean isAMine(int xCoordinate, int yCoordinate) {
        if (isBetween(xCoordinate, this.xSize) && this.isBetween(yCoordinate, this.ySize)) {
            return this.board[3 * yCoordinate + xCoordinate].getState() == MineState.MINE;
        }
        return false;
    }

    private boolean isBetween(int value, int max) {
        return 0 <= value && value < max;
    }

}
