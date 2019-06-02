package com.javarush.task.task28.task2802;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = () -> System.out.println(Thread.currentThread().getName());
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private AtomicInteger threadCount = new AtomicInteger(0);
        private static AtomicInteger factoryCount = new AtomicInteger(0);
        private int factoryNumber;


        public AmigoThreadFactory() {
            factoryNumber = factoryCount.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            ThreadGroup group = Thread.currentThread().getThreadGroup();
            String threadName = String.format("%s-pool-%d-thread-%s", group.getName(),
                                                factoryNumber, threadCount.incrementAndGet());
            Thread t = new Thread(group, r, threadName);
            t.setPriority(Thread.NORM_PRIORITY);
            t.setDaemon(false);

            return t;
        }
    }
}
