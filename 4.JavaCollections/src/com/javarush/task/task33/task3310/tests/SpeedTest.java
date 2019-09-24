package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start = System.currentTimeMillis();

        for (String string : strings) {
            ids.add(shortener.getId(string));
        }

        long finish = System.currentTimeMillis();
        return finish - start;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start = System.currentTimeMillis();

        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }

        long finish = System.currentTimeMillis();
        return finish - start;
    }

    @Test
    public void testHashMapStorage() {
        StorageStrategy hashMapStrategy = new HashMapStorageStrategy();
        StorageStrategy hashBiMapStrategy = new HashBiMapStorageStrategy();

        Shortener shortener1 = new Shortener(hashMapStrategy);
        Shortener shortener2 = new Shortener(hashBiMapStrategy);

        Set<String> origStrings = new HashSet<>();

        for (int i = 0; i < 10_000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> idsSet1 = new HashSet<>();
        Set<Long> idsSet2 = new HashSet<>();

        Long shortenerIdsTime1 = getTimeToGetIds(shortener1, origStrings, idsSet1);
        Long shortenerIdsTime2 = getTimeToGetIds(shortener2, origStrings, idsSet2);

        Assert.assertTrue(shortenerIdsTime1 > shortenerIdsTime2);

        Long shortenerStringsTime1 = getTimeToGetStrings(shortener1, idsSet1, new HashSet<>());
        Long shortenerStringsTime2 = getTimeToGetStrings(shortener2, idsSet2, new HashSet<>());

        Assert.assertEquals(shortenerStringsTime1, shortenerStringsTime2, 30);
    }
}
