package ru.dilgorp.java.luckytickets.ticket;

public interface Lucky extends HasOrdinal, Visitable<HasOrdinal> {
    boolean isLucky();
}
