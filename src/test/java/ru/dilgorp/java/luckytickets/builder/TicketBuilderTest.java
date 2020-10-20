package ru.dilgorp.java.luckytickets.builder;

import org.junit.Test;
import ru.dilgorp.java.luckytickets.builder.impl.TicketBuilderImpl;
import ru.dilgorp.java.luckytickets.ticket.Lucky;
import ru.dilgorp.java.luckytickets.ticket.Ticket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Набор тестов для класса {@link TicketBuilder}
 */
public class TicketBuilderTest {

    /**
     * Проверяем, что формируется билет
     */
    @Test
    public void buildIsCorrect() {
        // Given
        int numberLength = 6;
        int number = 10;

        TicketBuilder ticketBuilder = new TicketBuilderImpl()
                .setNumber(number)
                .setNumberLength(numberLength);

        // when
        Lucky ticketByBuilder = ticketBuilder.build();

        // then
        assertNotNull(ticketByBuilder);
    }

    /**
     * Проверяем, что формируется корректный билет
     */
    @Test
    public void buildCorrectTicketIsCorrect() {
        // Given
        int numberLength = 6;
        int number = 10;
        Lucky ticket = new Ticket(numberLength, number);

        TicketBuilder ticketBuilder = new TicketBuilderImpl()
                .setNumber(number)
                .setNumberLength(numberLength);

        // when
        Lucky ticketByBuilder = ticketBuilder.build();

        // then
        assertEquals(ticket, ticketByBuilder);
    }

    /**
     * Проверяем, что при попытке повторного использования билдера выкидывается исключение {@link IllegalStateException}
     */
    @Test
    public void buildReuseException() {
        // Given
        int numberLength = 6;
        int number = 10;

        TicketBuilder ticketBuilder = new TicketBuilderImpl()
                .setNumber(number)
                .setNumberLength(numberLength);

        ticketBuilder.build();

        // when
        Exception exception = null;
        try {
            ticketBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        // then
        assertNotNull(exception);
        assertEquals(IllegalStateException.class, exception.getClass());
        assertEquals("Данный строитель уже использовался ранее!", exception.getMessage());
    }

    /**
     * Проверяем, что при передаче некорректных данных, вылетает исключение,
     * генерируемое конструктором билета
     */
    @Test
    public void ticketConstructorException() {
        // Given
        int numberLength = 6;
        int number = -10;

        TicketBuilder ticketBuilder = new TicketBuilderImpl()
                .setNumber(number)
                .setNumberLength(numberLength);

        // when
        Exception exception = null;
        try {
            ticketBuilder.build();
        } catch (Exception e) {
            exception = e;
        }

        // then
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
}