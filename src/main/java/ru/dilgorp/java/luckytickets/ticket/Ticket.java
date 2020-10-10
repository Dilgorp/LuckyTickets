package ru.dilgorp.java.luckytickets.ticket;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ticket implements Lucky {

    private final int numberLength;
    private final int[] digits;

    public Ticket(int numberLength, int number) {
        this.numberLength = numberLength;
        this.digits = getDigits(number);
    }

    @Override
    public boolean isLucky() {
        int middle = digits.length / 2
                + ((digits.length % 2 == 0) ? 0 : 1);

        return Arrays.stream(digits, 0, middle).sum() ==
                Arrays.stream(digits, middle, digits.length).sum();
    }

    private int[] getDigits(int number) {
        int[] digits = new int[numberLength];

        for (int j = number, count = 0; j > 0; j /= 10) {
            digits[count++] = j % 10;
        }

        return reverseArray(digits);
    }

    private int[] reverseArray(int[] digits) {
        int maxIdx = digits.length - 1;
        return IntStream.range(0, digits.length)
                .map(i -> digits[maxIdx - i])
                .toArray();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int digit : digits) {
            builder.append(digit);
        }
        return builder.toString();
    }
}
