package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static CurrencyManipulatorFactory instance = new CurrencyManipulatorFactory();
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String currencyCodeSmallCase = currencyCode.toLowerCase();

        if (map.containsKey(currencyCodeSmallCase)) {
            return map.get(currencyCodeSmallCase);

        } else {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCodeSmallCase, manipulator);
            return manipulator;
        }
    }

    public static CurrencyManipulatorFactory getInstance() {
        return instance;
    }
}
