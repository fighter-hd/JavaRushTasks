package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread currentThread;

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(currentThread.getName());
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        currentThread = new Thread(this, threadName);
        currentThread.start();
    }

    @Override
    public void stop() {
        currentThread.interrupt();
    }
}
