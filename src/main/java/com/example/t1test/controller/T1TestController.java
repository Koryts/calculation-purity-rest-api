package com.example.t1test.controller;

import com.example.t1test.exception.SymbolsToMatchException;
import com.example.t1test.service.T1TestApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Класс с логикой RestAPI
 * @author Koryts Vladislav - koryts@mail.ru
 * @version 1.0
 */
@AllArgsConstructor
@RestController
@RequestMapping("/purity")
public class T1TestController {

    T1TestApplicationService t1TestApplicationService;

    /**
     *
     * @param symbols Строка для подсчета
     * @return Возвращает частоту каждого символа с помощью метода {@link T1TestApplicationService#calculationPurity(String)}
     * @throws SymbolsToMatchException {@link SymbolsToMatchException#SymbolsToMatchException(String)} Исключение на количество букв во входной строке
     */
    @GetMapping
    public Map<String, Integer> getPurity(@RequestParam("symbols") String symbols) throws SymbolsToMatchException {
        return t1TestApplicationService.calculationPurity(symbols);
    }
}
