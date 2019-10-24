package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String currencyCodeUpperCase = currencyCode.toUpperCase();

        if (map.containsKey(currencyCodeUpperCase)) {
            return map.get(currencyCodeUpperCase);

        } else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCodeUpperCase);
            map.put(currencyCodeUpperCase, manipulator);
            return manipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
