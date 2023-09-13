package com.example.t1test.exception;

/**
 * Исключение на количество символов
 * @author Koryts Vladislav - koryts@mail.ru
 * @version 1.0
 */
public class SymbolsToMatchException extends Exception{
    /**
     * Конструктор исключения
     * @param message Сообщения при выбрасывании исключения
     */
    public SymbolsToMatchException(String message) {
        super(message);
    }
}
