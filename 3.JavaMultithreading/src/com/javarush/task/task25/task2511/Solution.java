package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                StringBuilder hidedThreadName = new StringBuilder();

                for (int i = 0; i < t.getName().length(); i++) {
                    hidedThreadName.append('*');
                }

                String newName = String.valueOf(hidedThreadName);
                System.out.println(e.getMessage().replaceAll(t.getName(), newName));
            }
        };    //init handler here

    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution s = new Solution(new TimerTask() {
            @Override
            public void run() {
                int i = 1 / 0;
            }
        });

        s.run();
    }
}