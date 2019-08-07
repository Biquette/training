package com.kata.gameoflife.yegorstyle;

import com.kata.gameoflife.yegorstyle.grid.RandomGrid;
import com.kata.gameoflife.yegorstyle.printer.CustomStringPrinter;
import com.kata.gameoflife.yegorstyle.universe.DefaultUniverse;
import com.kata.gameoflife.yegorstyle.universe.Universe;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RandomUniverseTest {

    @Test
    public void when_generating_universe_cells_should_appear() {
        // Given
        Universe universe = new DefaultUniverse(new RandomGrid(7, 7));

        // When
        universe.goForwardInTime(1);

        // Then
        CustomStringPrinter media = new CustomStringPrinter();
        universe.print(media);
        String result = media.toCustomString();

        // Then
        Assertions.assertThat(result).contains("*", ".");
    }

}