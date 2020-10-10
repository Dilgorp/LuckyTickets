package ru.dilgorp.java.luckytickets.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dilgorp.java.luckytickets.ticket.Lucky;
import ru.dilgorp.java.luckytickets.ticket.Ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SimpleTicketGenerator implements TicketGenerator {

    private List<Lucky> tickets;

    private final int numberLength;
    private final NumberType type;

    @Autowired
    public SimpleTicketGenerator(int numberLength, NumberType type) {
        this.numberLength = numberLength;
        this.type = type;
    }

    /**
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

    /**
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
                .filter(this::filterByType)
                .mapToObj(n -> new Ticket(numberLength, n))
                .filter(Ticket::isLucky)
                .collect(Collectors.toList());
    }

    private boolean filterByType(int i) {
        boolean result;

        switch (type) {
            case EVEN:
                result = i % 2 == 0;
                break;
            case ODD:
                result = i % 2 != 0;
                break;
            default:
                result = true;
                break;
        }

        return result;
    }
}