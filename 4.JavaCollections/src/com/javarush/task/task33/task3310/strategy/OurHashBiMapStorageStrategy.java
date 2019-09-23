package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> k2v = new HashMap<>();
    private HashMap<String, Long> v2k = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return this.k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return this.v2k.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        this.k2v.put(key, value);
        this.v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        return this.v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return this.k2v.get(key);
    }
}
