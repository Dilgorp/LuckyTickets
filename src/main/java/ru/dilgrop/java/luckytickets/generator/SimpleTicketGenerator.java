package ru.dilgrop.java.luckytickets.generator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleTicketGenerator implements TicketGenerator {

    private List<String> tickets;
    private final int numberLength;

    public SimpleTicketGenerator(int numberLength) {
        this.numberLength = numberLength;
    }

    /*
     * Выводит на экран все счастливые билеты.
     * При необходимости вычисляет счастливые билеты.
     */
    @Override
    public void printAll() {
        if (tickets == null) {
            computeTickets();
        }

        tickets.forEach(System.out::println);
    }

    /*
     * Выводит на экран количество счастливых билетов.
     * При необходимости вычисляет счастливые билеты.
     */
    @Override
    public void printCount() {
        if (tickets == null) {
            computeTickets();
        }

        System.out.printf("Lucky tickets count: %d%n", tickets.size());
    }

    private void computeTickets() {
        tickets = IntStream.range(0, (int) Math.pow(10d, numberLength))
                .parallel()
                .mapToObj(this::getDigits)
                .filter(this::isLucky)
                .map(this::digitsToString)
                .collect(Collectors.toList());
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

    private boolean isLucky(int[] digits) {
        int middle = digits.length / 2
                + ((digits.length % 2 == 0) ? 0 : 1);

        return Arrays.stream(digits, 0, middle).sum() ==
                Arrays.stream(digits, middle, digits.length).sum();
    }

    private String digitsToString(int[] digits) {
        StringBuilder builder = new StringBuilder();
        for (int digit : digits) {
            builder.append(digit);
        }
        return builder.toString();
    }
}