package com.katas.gameoflife;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Chloé Mahalin
 */
public class GameOfLifeTest {

@Test
    public void test_cell_count_no_living_neighbours() {
        checkCountNeighbours(0,0,0,Universe.createUniverse(
                "*..",
                "...",
                "..."));
    }

    @Test
     public void test_cell_count_two_living_neighbours() {
        checkCountNeighbours(2,0,0,Universe.createUniverse(
                "**.",
                ".*.",
                "..."));
    }

    @Test
    public void test_cell_count_three_living_neighbours() {
        checkCountNeighbours(3,1,1,Universe.createUniverse(
                ".*.",
                ".**",
                "*.."));
    }

    @Test
    public void test_cell_count_three_living_neighbours_edge() {
        checkCountNeighbours(3,2,2,Universe.createUniverse(
                ".*.",
                ".**",
                "***"));
    }

    public void checkCountNeighbours(int numberOfNeighboursExpected, int xCoordinate, int yCoordinate, Universe universe) {
        GameOfLife lifeGame = new GameOfLife();
        Assert.assertEquals(numberOfNeighboursExpected, lifeGame.countLivingNeighbours(xCoordinate,yCoordinate,universe));
    }

   @Test
    public void test_cell_is_alive_due_to_alive_before_and_enough_neighbours() {
        checkCellStateAccordingToNumberOfNeighbours(CellState.ALIVE, CellState.ALIVE,2);
        checkCellStateAccordingToNumberOfNeighbours(CellState.ALIVE, CellState.ALIVE,3);
    }

    @Test
    public void test_cell_is_dead_due_to_not_enough_population() {
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.ALIVE,1);
    }

    @Test
    public void test_cell_is_dead_due_to_overpopulation() {
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.ALIVE,4);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.ALIVE,5);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.ALIVE,6);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.ALIVE,7);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.ALIVE,8);
    }

    @Test
    public void test_cell_is_dead_because_dead_before_and_no_three_neighbours() {
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,0);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,1);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,2);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,4);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,5);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,6);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,7);
        checkCellStateAccordingToNumberOfNeighbours(CellState.DEAD, CellState.DEAD,8);
    }

    @Test
    public void test_cell_is_alive_because_dead_before_and_three_neighbours() {
        checkCellStateAccordingToNumberOfNeighbours(CellState.ALIVE, CellState.DEAD,3);
    }

    public void checkCellStateAccordingToNumberOfNeighbours(CellState expected, CellState actual, int numberOfNeighbours) {
        GameOfLife lifeGame = new GameOfLife();
        Assert.assertEquals(expected, lifeGame.calculateCellState(actual, numberOfNeighbours));
    }
}
