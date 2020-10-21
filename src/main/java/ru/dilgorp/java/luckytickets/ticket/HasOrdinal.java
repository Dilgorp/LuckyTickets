package ru.dilgorp.java.luckytickets.ticket;

/**
 * Предоставляет метод, возвращающий порядковый номер
 */
public interface HasOrdinal {

    /**
     * Реализация по умолчанию, при необходимости переопределить
     *
     * @return порядковый номер
     */
    default Integer getOrdinal(){
        return null;
    }
}
