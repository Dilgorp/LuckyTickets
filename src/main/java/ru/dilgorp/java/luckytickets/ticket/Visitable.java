package ru.dilgorp.java.luckytickets.ticket;

import java.util.function.Predicate;

/**
 * Служебный интерфейс шаблона Посетитель
 *
 * @param <T>
 */
public interface Visitable<T> {

    /**
     * Стандартный метод шаблона посетитель
     * @param visitor новая функциональность
     * @return результат вычислений
     */
    default boolean accept(Predicate<T> visitor){
        return true;
    }
}
