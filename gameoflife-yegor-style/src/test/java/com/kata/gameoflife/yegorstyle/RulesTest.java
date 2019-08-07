package com.kata.gameoflife.yegorstyle;

import com.kata.gameoflife.yegorstyle.parser.ConfigurableGridFromStringVisual;
import com.kata.gameoflife.yegorstyle.printer.CustomStringPrinter;
import com.kata.gameoflife.yegorstyle.universe.DefaultUniverse;
import com.kata.gameoflife.yegorstyle.universe.Universe;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RulesTest {

    @Test
    public void any_live_cell_with_one_live_neighbours_dies() {
        this.verifyOutputGivenInput("*..\n**.\n..*", 1, "**.\n**.\n.*.");
    }

    @Test
    public void any_live_cell_with_zero_live_neighbours_dies() {
        this.verifyOutputGivenInput("*..\n...\n...", 1, "...\n...\n...");
    }

    @Test
    public void any_live_cell_with_four_live_neighbours_dies() {
        this.verifyOutputGivenInput("***\n**.\n...", 1, "*.*\n*.*\n...");
    }

    @Test
    public void any_live_cell_with_five_live_neighbours_dies() {
        this.verifyOutputGivenInput("***\n.*.\n.**", 1, "***\n...\n.**");
    }

    @Test
    public void any_live_cell_with_six_live_neighbours_dies() {
        this.verifyOutputGivenInput("***\n***\n*..", 1, "*.*\n..*\n*..");
    }

    @Test
    public void any_live_cell_with_seven_live_neighbours_dies() {
        this.verifyOutputGivenInput("***\n***\n**.", 1, "*.*\n...\n*.*");
    }

    @Test
    public void any_live_cell_with_eight_live_neighbours_dies() {
        this.verifyOutputGivenInput("***\n***\n***", 1, "*.*\n...\n*.*");
    }

    @Test
    public void any_live_cell_with_two_live_neighbours_lives_unchanged_to_the_next_generation() {
        this.verifyOutputGivenInput("**.\n*..\n...", 1, "**.\n**.\n...");
    }

    @Test
    public void any_live_cell_with_three_live_neighbours_lives_unchanged_to_the_next_generation() {
        this.verifyOutputGivenInput("**.\n**.\n...", 1, "**.\n**.\n...");
    }

    @Test
    public void any_dead_cell_with_exactly_three_live_neighbours_will_come_to_life() {
        this.verifyOutputGivenInput("**.\n*..\n...", 1, "**.\n**.\n...");

    }

    private void verifyOutputGivenInput(String originalUniverse, int numberOfTurns, String expectedOutput) {
        // Given
        Universe universe = new DefaultUniverse(
                new ConfigurableGridFromStringVisual(originalUniverse).generate()
        );

        // When
        universe.goForwardInTime(numberOfTurns);

        // Then
        CustomStringPrinter media = new CustomStringPrinter();
        universe.print(media);
        String result = media.toCustomString();

        // Then
        Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

}