package ru.dilgorp.java.luckytickets.filter.impl;

import org.junit.Test;
import ru.dilgorp.java.luckytickets.filter.Filter;

import static org.junit.Assert.*;

/**
 * Набор тестов для класса {@link AllTickets}
 */
public class AllTicketsTest {

    /**
     * Проверяем, что фильтр всегда возвращает true
     */
    @Test
    public void doFilter() {
        // when
        Filter filter = new AllTickets();

        //then
        assertTrue(filter.doFilter(0));
        assertTrue(filter.doFilter(-1));
        assertTrue(filter.doFilter(100000));
    }
}