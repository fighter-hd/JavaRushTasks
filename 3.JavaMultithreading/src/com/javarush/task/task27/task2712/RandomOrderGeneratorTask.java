package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while( ! Thread.currentThread().isInterrupted()) {

            int random = (int) (Math.random() * tablets.size());
            Tablet randomTablet = tablets.get(random);
            randomTablet.createTestOrder();

            try {
                Thread.sleep(interval);
            } catch (InterruptedException ignore) {
                break;
            }
        }
    }
}