package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder();

        for (Dish dish : values()) {
            result.append(dish + ", ");
        }

        int lastIndex = result.length();
        result.deleteCharAt(--lastIndex);
        result.deleteCharAt(--lastIndex);

        return result.toString();
    }

    public int getDuration() {
        return duration;
    }
}
