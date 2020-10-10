package ru.dilgorp.java.luckytickets;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dilgorp.java.luckytickets.configuration.AppConfig;
import ru.dilgorp.java.luckytickets.generator.TicketGenerator;

public class LuckyTicketsApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.dilgorp.java.luckytickets");

        context.register(AppConfig.class);

        TicketGenerator generator = context.getBean(TicketGenerator.class);
        generator.printAll();
        generator.printCount();
    }
}
