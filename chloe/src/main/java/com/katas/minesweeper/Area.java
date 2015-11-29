package com.katas.minesweeper;

/**
 * @author Chloé Mahalin
 */
public class Area {

    private MineState[][] board;

    private int xSize;

    private int ySize;

    private Area(int x, int y) {
        board = new MineState[x][y];
        this.xSize = x;
        this.ySize = y;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void setValue(int xCoordinate, int yCoordinate, MineState value) {
        this.board[xCoordinate][yCoordinate] = value;
    }

    public boolean isAMine(int xCoordinate, int yCoordinate) {
        if (xCoordinate >= 0 && yCoordinate >= 0 && xCoordinate < this.getXSize() && yCoordinate < this.getYSize()) {
            return this.board[xCoordinate][yCoordinate] == MineState.MINE;
        }
        return false;
    }

    public static Area generate(String... rows) {
        Area constructedBoard = new Area(0, 0);
        if (rows.length > 0 && !rows[0].isEmpty()) {
            constructedBoard = new Area(rows.length, rows[0].length());

            for (int i = 0; i < rows.length; i++) {
                for (int j = 0; j < rows[i].length(); j++) {
                    constructedBoard.setValue(i, j, MineState.getStateFromSymbol(rows[i].charAt(j)));
                }
            }
        }
        return constructedBoard;
    }
}

