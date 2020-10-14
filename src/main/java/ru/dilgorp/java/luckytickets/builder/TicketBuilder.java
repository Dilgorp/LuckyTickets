package ru.dilgorp.java.luckytickets.builder;

import ru.dilgorp.java.luckytickets.ticket.AbstractTicket;

public interface TicketBuilder {
    /**
     * @return построенный билет
     */
    AbstractTicket build();

    /**
     * Фиксирует длину номера билета
     *
     * @param numberLength длина номера билета
     * @return текущий строитель
     */
    TicketBuilder setNumberLength(int numberLength);

    /**
     * Фиксирует номер билета
     *
     * @param number номер билета
     * @return текущий строитель
     */
    TicketBuilder setNumber(int number);
}
