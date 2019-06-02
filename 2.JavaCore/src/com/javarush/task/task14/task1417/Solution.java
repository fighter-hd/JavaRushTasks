package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        private List<Money> allMoney;

        Person(String name) {
            this.name = name;
            allMoney = new ArrayList<Money>();
            allMoney.add(new Hrivna(5000.35));
            allMoney.add(new Ruble(3000.79));
            allMoney.add(new USD(200.50));
        }

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}

