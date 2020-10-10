package ru.dilgorp.java.luckytickets.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.dilgorp.java.luckytickets.generator.SimpleTicketGenerator;
import ru.dilgorp.java.luckytickets.generator.TicketGenerator;

/**
 * Класс конфигурации приложения
 */

@SuppressWarnings("unused")
@Configuration
public class AppConfig {

    private static final int NUMBER_LENGTH = 6;
    private static final String NUMBER_LENGTH_NAME = "ru.dilgorp.java.luclytickets.number_length";

    /**
     *
     * @return длина билета
     */
    @Bean(NUMBER_LENGTH_NAME)
    public int numberLength(){
        return NUMBER_LENGTH;
    }

    /**
     * Возвращает генератор билетов
     * @param numberLength длина билетов
     * @return простая реализация генератора билета
     */
    @Bean
    public TicketGenerator ticketGenerator(@Qualifier(NUMBER_LENGTH_NAME) int numberLength){
        return new SimpleTicketGenerator(numberLength);
    }
}
