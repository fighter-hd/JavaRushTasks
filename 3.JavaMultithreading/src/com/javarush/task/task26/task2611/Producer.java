package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        int i = 1;
        try {
            while (true) {
                thread.setName("[thread-" + i + "]");
                map.put(String.valueOf(i), "Some text for " + i);
                i++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " thread was terminated");
        }
    }
}
