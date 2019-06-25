package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Set<Cook> cooks = StatisticManager.getInstance().getCooks();

        Thread daemon = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if ( ! orderQueue.isEmpty() ) {
                        for (Cook cook : cooks) {
                            if ( ! cook.isBusy() )
                                cook.startCookingOrder(orderQueue.poll());
                        }
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        daemon.setDaemon(true);
        daemon.start();
    }


    @Override
    public void update(Observable o, Object arg) {
        try {
            orderQueue.put((Order) arg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
