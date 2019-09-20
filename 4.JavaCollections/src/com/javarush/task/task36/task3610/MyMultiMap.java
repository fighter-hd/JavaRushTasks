package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return this.values().size();
    }

    @Override
    public V put(K key, V value) {

        if ( ! map.containsKey(key)) {
            List<V> values = new ArrayList<>();
            values.add(value);

            map.put(key, values);
            return null;
        }

        List<V> valuesByKey = map.get(key);
        V lastValue = valuesByKey.get(valuesByKey.size() - 1);

        if (valuesByKey.size() >= repeatCount) {
            valuesByKey.remove(0);
        }

        valuesByKey.add(value);
        return lastValue;
    }

    @Override
    public V remove(Object key) {
        if ( ! map.containsKey(key)) {
            return null;
        }

        V removedObject = null;
        List<V> valuesByKey = map.get(key);

        if (valuesByKey != null && valuesByKey.size() > 0) {
            removedObject = valuesByKey.get(0);
            valuesByKey.remove(0);
        }

        if (valuesByKey.isEmpty()) {
            map.remove(key);
        } else {
            map.put((K) key, valuesByKey);
        }

        for (Entry<K, List<V>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                map.remove(entry.getKey());
            }
        }

        return removedObject;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> allValues = new ArrayList<>();

        for (List<V> list : map.values()) {
            allValues.addAll(list);
        }

        return allValues;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}