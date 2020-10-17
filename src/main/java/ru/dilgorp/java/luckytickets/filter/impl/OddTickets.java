package ru.dilgorp.java.luckytickets.filter.impl;

import ru.dilgorp.java.luckytickets.filter.Filter;

public class OddTickets implements Filter {
    @Override
    public boolean doFilter(int n) {
        return n % 2 != 0;
    }
}
