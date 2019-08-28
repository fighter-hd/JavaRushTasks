package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here

        V value = cache.get(key);

        if (value != null) {
            return value;

        } else {
            Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
            value = constructor.newInstance(key);

            put(value);

            return value;
        }
    }

    public boolean put(V obj) {
        //TODO add your code here
        K key = null;

        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            key = (K) method.invoke(obj);

        } catch (Exception ignore) {
            return false;
        }

        cache.put(key, obj);

        return true;
    }

    public int size() {
        return cache.size();
    }
}
