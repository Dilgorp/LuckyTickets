package ru.dilgorp.java.luckytickets.generator;

import ru.dilgorp.java.luckytickets.filter.Filter;
import ru.dilgorp.java.luckytickets.provider.TicketBuilderProvider;
import ru.dilgorp.java.luckytickets.ticket.Lucky;

public class EvenTicketGenerator extends SimpleTicketGenerator {
    public EvenTicketGenerator(int numberLength, Filter filter, TicketBuilderProvider ticketBuilderProvider) {
        super(numberLength, filter, ticketBuilderProvider);
    }

    /**
     *
     * @param lucky билет для фитрации
     * @return true, если билет четный
     */
    @Override
    protected boolean doFilter(Lucky lucky) {
        return lucky.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 2 == 0);
    }
}
