package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }

    public void addAmount(int denomination, int count) {
        Integer previousAmountByNominal = denominations.get(denomination);

        if (previousAmountByNominal != null) {
            count += previousAmountByNominal;
        }

        denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int totalAmount = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }

        return totalAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
