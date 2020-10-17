package ru.dilgorp.java.luckytickets.filter.impl;

import ru.dilgorp.java.luckytickets.filter.Filter;

public class DivisibleByFiveTickets implements Filter {
    @Override
    public boolean doFilter(int n) {
        return n % 5 == 0;
    }
}
