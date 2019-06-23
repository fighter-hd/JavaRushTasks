package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    }

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        } else {
            hits--;
        }
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getAmountPerOneSecond() {
        return amountPerOneDisplaying * 1000 / duration;
    }

    @Override
    public String toString() {
        return name + " is displaying... " + amountPerOneDisplaying
                + ", " + amountPerOneDisplaying * 1000 / duration;
    }
}
