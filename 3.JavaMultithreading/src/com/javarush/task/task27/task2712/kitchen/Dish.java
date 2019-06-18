package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

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
}
