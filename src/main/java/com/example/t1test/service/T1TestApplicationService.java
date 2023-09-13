package com.example.t1test.service;

import com.example.t1test.exception.SymbolsToMatchException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс с основной логикой этого маленького проекта
 * @author Koryts Vladislav - koryts@mail.ru
 * @version 1.0
 */
@Service
public class T1TestApplicationService {

    /**
     * Метод для подсчета частоты символов в заданной строке
     * @param symbols Строка символов
     * @return Буква и количество ее повторений в строке
     * @throws SymbolsToMatchException {@link SymbolsToMatchException#SymbolsToMatchException(String)} Исключение на количество букв во входной строке
     */
    public Map<String, Integer> calculationPurity(String symbols) throws SymbolsToMatchException {
        if (symbols.length() >= 300){
            throw new SymbolsToMatchException(String.format("Ну слишком уж много символов! Ты задал: '%s', а максимум 300", symbols.length()));
        }
        Map<String, Integer> purity = new HashMap<>();
        for(int i =0; i <= symbols.length()-1; i++){
            if (!purity.containsKey(String.valueOf(symbols.charAt(i)))) {
                Integer quantity = StringUtils.countOccurrencesOf(symbols, String.valueOf(symbols.charAt(i)));
                purity.put(String.valueOf(symbols.charAt(i)), quantity);
            }
        }

        return purity.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
