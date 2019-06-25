package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;


    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);

            if (order.isEmpty()) {
                return null;
            }

            createOrderHelper(order);

        } catch (IOException logged) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }

    public void createTestOrder() {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);

            if (testOrder.isEmpty()) {
                return;
            }

            createOrderHelper(testOrder);

        } catch (IOException logged) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the testOrder " + testOrder);
        }
    }

    private void createOrderHelper(Order order) {
        ConsoleHelper.writeMessage(order.toString());

        try {
            queue.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
        manager.processVideos();
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number +
                '}';
    }
}
