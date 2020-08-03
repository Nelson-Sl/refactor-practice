package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int[] countEvenAndOdd() {
        int even = 0;
        int odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) even++;
            else if (number % 2 == 1) odd++;
        }
        return new int[] {even, odd};
    }

    public int[] countPositiveAndNegative() {
        int positive = 0;
        int negative = 0;
        for (int number : numbers) {
            if (number >= 0) positive++;
            else negative++;
        }
        return new int[] {positive, negative};
    }
}
