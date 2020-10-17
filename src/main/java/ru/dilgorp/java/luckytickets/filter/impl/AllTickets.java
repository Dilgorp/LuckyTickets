package ru.dilgorp.java.luckytickets.filter.impl;

import ru.dilgorp.java.luckytickets.filter.Filter;

public class AllTickets implements Filter {
    @Override
    public boolean doFilter(int n) {
        return true;
    }
}
