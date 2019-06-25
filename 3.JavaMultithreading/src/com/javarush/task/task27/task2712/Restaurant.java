package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        Cook cook1 = new Cook("Махмуд");
        Cook cook2 = new Cook("Фатуш");
        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        Tablet tablet1 = new Tablet(1);
        Tablet tablet2 = new Tablet(2);
        Tablet tablet3 = new Tablet(3);
        Tablet tablet4 = new Tablet(4);

        tablet1.addObserver(cook1);
        tablet2.addObserver(cook1);
        tablet3.addObserver(cook2);
        tablet4.addObserver(cook2);

        tablet1.createTestOrder();
        tablet2.createTestOrder();
        tablet3.createTestOrder();
        tablet4.createTestOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
