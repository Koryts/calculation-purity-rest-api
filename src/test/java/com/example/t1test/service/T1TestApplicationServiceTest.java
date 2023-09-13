package com.example.t1test.service;

import com.example.t1test.exception.SymbolsToMatchException;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тесты для подсчета частоты
 * @author Koryts Vladislav - koryts@mail.ru
 * @version 1.0
 */
class T1TestApplicationServiceTest {

    /**
     * Тест первый для {@link T1TestApplicationService#calculationPurity(String)}
     * @throws SymbolsToMatchException {@link SymbolsToMatchException#SymbolsToMatchException(String)} Исключение на количество букв во входной строке
     * @see T1TestApplicationService#calculationPurity(String)
     */
    @Test
    void testCalculationPurityMethod1() throws SymbolsToMatchException {
        T1TestApplicationService t1TestApplicationService = new T1TestApplicationService();
        //Ожидаемое значение
        Map<String, Integer> expected = new LinkedHashMap<>();
        //Значение из тестируемого метода
        Map<String, Integer> actual = t1TestApplicationService.calculationPurity("aaaaabcccc");
        expected.put("a", 5);
        expected.put("c", 4);
        expected.put("b", 1);
        //Сравнение значений
        assertEquals(expected, actual);
    }

    /**
     * Тест второй для {@link T1TestApplicationService#calculationPurity(String)}
     * @throws SymbolsToMatchException {@link SymbolsToMatchException#SymbolsToMatchException(String)} Исключение на количество букв во входной строке
     * @see T1TestApplicationService#calculationPurity(String)
     */
    @Test
    void testCalculationPurityMethod2() throws SymbolsToMatchException {
        T1TestApplicationService t1TestApplicationService = new T1TestApplicationService();
        //Ожидаемое значение
        Map<String, Integer> expected = new LinkedHashMap<>();
        //Значение из тестируемого метода
        Map<String, Integer> actual = t1TestApplicationService.calculationPurity("Я очень хочу у вас работать");
        expected.put(" ", 5);
        expected.put("а", 3);
        expected.put("о", 3);
        expected.put("т", 2);
        expected.put("у", 2);
        expected.put("ч", 2);
        expected.put("ь", 2);
        expected.put("р", 1);
        expected.put("с", 1);
        expected.put("х", 1);
        expected.put("Я", 1);
        expected.put("б", 1);
        expected.put("в", 1);
        expected.put("е", 1);
        expected.put("н", 1);
        //Сравнение значений
        assertEquals(expected, actual);
    }
}