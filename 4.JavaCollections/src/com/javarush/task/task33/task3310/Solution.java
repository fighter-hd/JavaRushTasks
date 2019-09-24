package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new OurHashBiMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new HashBiMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new FileStorageStrategy(), 3);
        System.out.println("=========================================================================================");
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> setIds = new TreeSet<>();

        for (String string : strings) {
            setIds.add(shortener.getId(string));
        }

        return setIds;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> setStrings = new TreeSet<>();

        for (Long key : keys) {
            setStrings.add(shortener.getString(key));
        }

        return setStrings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> randomStrings = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++) {
            randomStrings.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Set<Long> idSet = new HashSet<>();

        Date start = new Date();
        for (String string : randomStrings) {
            idSet.add(shortener.getId(string));
        }
        Date finish = new Date();

        Helper.printMessage(String.valueOf(finish.getTime() - start.getTime()));

        Set<String> setForTest = new HashSet<>();

        start = new Date();
        for (Long id : idSet) {
            setForTest.add(shortener.getString(id));
        }
        finish = new Date();

        Helper.printMessage(String.valueOf(finish.getTime() - start.getTime()));

        if (randomStrings.equals(setForTest)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
}
