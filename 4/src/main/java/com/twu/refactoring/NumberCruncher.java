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

    public int countOdd() {
        int count = 0;
        for (int number : numbers) {
            if (number % 2 == 1) count++;
        }
        return count;
    }

    public int countPositive() {
        int count = 0;
        for (int number : numbers) {
            if (number >= 0) count++;
        }
        return count;
    }

    public int countNegative() {
        int count = 0;
        for (int number : numbers) {
            if (number < 0) count++;
        }
        return count;
    }
}
