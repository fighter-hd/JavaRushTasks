package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Cook cook = new Cook("Махмуд");
        cook.addObserver(new Waiter());

        Tablet tablet = new Tablet(1);
        tablet.addObserver(cook);

        tablet.createOrder();
    }
}
