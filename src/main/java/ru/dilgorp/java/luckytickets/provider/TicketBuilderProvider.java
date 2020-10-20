package ru.dilgorp.java.luckytickets.provider;

import ru.dilgorp.java.luckytickets.builder.TicketBuilder;

public interface TicketBuilderProvider {
    TicketBuilder getTicketBuilder();
}
