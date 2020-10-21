package ru.dilgorp.java.luckytickets.generator;

import ru.dilgorp.java.luckytickets.filter.Filter;
import ru.dilgorp.java.luckytickets.provider.TicketBuilderProvider;
import ru.dilgorp.java.luckytickets.ticket.Lucky;

public class DivisibleBySevenTicketGenerator extends SimpleTicketGenerator {
    public DivisibleBySevenTicketGenerator(int numberLength, Filter filter, TicketBuilderProvider ticketBuilderProvider) {
        super(numberLength, filter, ticketBuilderProvider);
    }

    @Override
    protected boolean doFilter(Lucky lucky) {
        return lucky.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 7 == 0);
    }
}
