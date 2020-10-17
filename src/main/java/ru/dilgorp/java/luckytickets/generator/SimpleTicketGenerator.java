package ru.dilgorp.java.luckytickets.generator;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.dilgorp.java.luckytickets.builder.TicketBuilder;
import ru.dilgorp.java.luckytickets.filter.Filter;
import ru.dilgorp.java.luckytickets.ticket.AbstractTicket;
import ru.dilgorp.java.luckytickets.ticket.Lucky;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SimpleTicketGenerator implements TicketGenerator, ApplicationContextAware {

    private List<Lucky> tickets;

    private final int numberLength;
    private final Filter filter;

    private ApplicationContext context;

    public SimpleTicketGenerator(int numberLength, Filter filter) {
        this.numberLength = numberLength;
        this.filter = filter;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
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
                .filter(filter::doFilter)
                .mapToObj(
                        n -> {
                            TicketBuilder builder = context.getBean("ticketBuilder", TicketBuilder.class);
                            return builder.setNumberLength(numberLength).setNumber(n).build();
                        }
                )
                .filter(AbstractTicket::isLucky)
                .collect(Collectors.toList());
    }
}