package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {
    int hash;
    Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry entry = (Entry) o;
        return Objects.equals(this.key, entry.key) &&
                Objects.equals(this.value, entry.value);
    }

    @Override
    public String toString() {
        return this.key + "=" + this.value;
    }
}
