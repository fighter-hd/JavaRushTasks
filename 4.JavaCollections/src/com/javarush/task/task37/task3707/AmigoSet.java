package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, collection.size()/.75f + 1);
        this.map = new HashMap<>(capacity);

        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o) == o;
    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> cloneSet = (AmigoSet<E>) super.clone();
            cloneSet.map = (HashMap<E, Object>) this.map.clone();
            return cloneSet;

        } catch (Exception e) {
            throw new InternalError();
        }
    }
}
