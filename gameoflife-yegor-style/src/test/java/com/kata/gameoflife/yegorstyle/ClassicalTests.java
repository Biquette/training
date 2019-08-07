package com.kata.gameoflife.yegorstyle;

import com.kata.gameoflife.yegorstyle.parser.ConfigurableGridFromStringVisual;
import com.kata.gameoflife.yegorstyle.printer.CustomStringPrinter;
import com.kata.gameoflife.yegorstyle.universe.DefaultUniverse;
import com.kata.gameoflife.yegorstyle.universe.Universe;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ClassicalTests {

    @Test
    public void no_cell_at_first_during_three_turns() {
        this.verifyOutputGivenInput("...\n...\n...", 3, "...\n...\n...");
    }


    @Test
    public void full_of_cell_at_first_during_three_turns() {
        this.verifyOutputGivenInput("***\n***\n***", 3, "...\n...\n...");
    }


    @Test
    public void random_test_during_three_turns() {
        this.verifyOutputGivenInput("*.*\n.**\n*.*", 3, "...\n.**\n...");
    }


    @Test
    public void check_each_turn_for_three_turns() {
        this.verifyOutputGivenInput("*.*\n.**\n*.*", 1, "..*\n*.*\n..*");
        this.verifyOutputGivenInput("..*\n*.*\n..*", 1, ".*.\n..*\n.*.");
        this.verifyOutputGivenInput(".*.\n..*\n.*.", 1, "...\n.**\n...");


        this.verifyOutputGivenInput("*.*\n.**\n*.*", 3, "...\n.**\n...");
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