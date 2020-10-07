package ru.dilgrop.java.luckytickets;

import ru.dilgrop.java.luckytickets.generator.SimpleTicketGenerator;
import ru.dilgrop.java.luckytickets.generator.TicketGenerator;

public class LuckyTicketsApp {
    public static void main(String[] args) {
        TicketGenerator generator = new SimpleTicketGenerator(6);
        generator.printAll();
        generator.printCount();
    }
}
