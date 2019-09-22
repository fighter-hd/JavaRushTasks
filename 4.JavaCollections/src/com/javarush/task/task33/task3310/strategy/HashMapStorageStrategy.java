package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

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
        for (Map.Entry<Long, String> entry : this.data.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }

        return null;
    }

    @Override
    public String getValue(Long key) {
        return this.data.get(key);
    }
}
