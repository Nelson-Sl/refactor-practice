package com.twu.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumberCruncherTest {
    @Test
    public void shouldCountEvenAndOddNumbers() {
        int[] result = new NumberCruncher(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).countEvenAndOdd();
        int[] expected = new int[] {5,6};
        Assertions.assertEquals(result[0], expected[0]);
        Assertions.assertEquals(result[1], expected[1]);
    }

    @Test
    public void shouldCountPositiveAndNegativeNumbers() {
        int[] result = new NumberCruncher(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4).countPositiveAndNegative();
        int[] expected = new int[] {5,5};
        Assertions.assertEquals(result[0], expected[0]);
        Assertions.assertEquals(result[1], expected[1]);
    }
}
