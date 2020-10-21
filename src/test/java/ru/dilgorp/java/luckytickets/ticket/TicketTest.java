package ru.dilgorp.java.luckytickets.ticket;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Набор тестов для класса {@link Ticket}
 */
public class TicketTest{

    /**
     * Проверяем, что конструктор генерирует билет для корректных данных (номер билета)
     */
    @Test
    public void ticketConstructorIsCorrect(){
        // when
        Lucky ticket = new Ticket(6, 10);

        // then
        assertNotNull(ticket);
    }

    /**
     * Проверяет, что если на вход в конструктор поступило отричательное число,
     * то выкидываем исключение {@link IllegalArgumentException}
     */
    @Test
    public void negativeTicket(){

        // when
        Exception exception = null;
        try {
            new Ticket(6, -1);
        } catch (Exception e) {
            exception = e;
        }

        // then
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Билет не может иметь отрицательный номер!", exception.getMessage());
    }

    /**
     * Проверяет, что если на вход в конструктор поступило число выходящее за верхнюю границу,
     * то выкидываем исключение {@link IllegalArgumentException}
     */
    @Test
    public void beyondUpperLimit(){
        // when
        Exception exception = null;
        try {
            new Ticket(2, 100);
        } catch (Exception e) {
            exception = e;
        }

        // then
        assertNotNull(exception);
        assertEquals(IllegalArgumentException.class, exception.getClass());
        assertEquals("Выход за верхнюю границу!", exception.getMessage());
    }

    /**
     * Проверяем, что конструктор генерирует билет для корректных данных (минимальный номер билета)
     */
    @Test
    public void ticketConstructorIsCorrectMinNumber(){
        // when
        Lucky ticket = new Ticket(6, 0);

        // then
        assertNotNull(ticket);
    }

    /**
     * Проверяем, что конструктор генерирует билет для корректных данных (максимальный номер билета)
     */
    @Test
    public void ticketConstructorIsCorrectMaxNumber(){
        // when
        Lucky ticket = new Ticket(6, 999999);

        // then
        assertNotNull(ticket);
    }

    /**
     * Проверяем, что счастивый билет проверяется правильно
     */
    @Test
    public void ticketIsLuckyCorrect(){
        // when
        Lucky ticket = new Ticket(6, 123420);

        // then
        assertTrue(ticket.isLucky());
    }

    /**
     * Проверяем, что несчастивый билет проверяется правильно
     */
    @Test
    public void ticketIsNotLuckyCorrect(){
        // when
        Lucky ticket = new Ticket(6, 123421);

        // then
        assertFalse(ticket.isLucky());
    }

    @Test
    public void ticketOrdinal(){
        Lucky ticket = new Ticket(6, 123421);
        assertEquals(123421, ticket.getOrdinal().intValue());
    }
}