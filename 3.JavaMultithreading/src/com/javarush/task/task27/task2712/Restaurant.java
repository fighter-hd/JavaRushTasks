package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();


    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        Cook cook1 = new Cook("Махмуд");
        cook1.addObserver(waiter);
        cook1.setQueue(orderQueue);

        Cook cook2 = new Cook("Фатуш");
        cook2.addObserver(waiter);
        cook2.setQueue(orderQueue);

        Thread threadCook1 = new Thread(cook1);
        Thread threadCook2 = new Thread(cook2);

        threadCook1.setDaemon(true);
        threadCook2.setDaemon(true);

        threadCook1.start();
        threadCook2.start();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }

        RandomOrderGeneratorTask randomOrderGeneratorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(randomOrderGeneratorTask);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

//        DirectorTablet directorTablet = new DirectorTablet();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();
    }
}