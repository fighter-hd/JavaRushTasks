package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

public class HashBiMapStorageStrategy implements StorageStrategy {
    private HashBiMap data = HashBiMap.create();

    @Override
    public boolean containsKey(Long key) {
        return this.data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return this.data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        this.data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return (Long) this.data.inverse().get(value);
    }

    @Override
    public String getValue(Long key) {
        return (String) this.data.get(key);
    }
}
