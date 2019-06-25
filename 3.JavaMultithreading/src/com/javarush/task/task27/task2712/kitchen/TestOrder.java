package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        dishes = new ArrayList<>();

        for (int i = 0; i <= getRandomInt(); i++) {
            dishes.add(Dish.values()[getRandomInt()]);
        }
    }

    private int getRandomInt() {
        return (int) (Math.random() * Dish.values().length);
    }
}
