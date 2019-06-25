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
        int random = (int) (Math.random() * tablets.size());
        Tablet randomTablet = tablets.get(random);

        for (int i = 0; i < 4; i++) {
            randomTablet.createTestOrder();

            try {
                Thread.sleep(interval);
            } catch (InterruptedException ignore) {
                //ignore
            }
        }
    }
}
