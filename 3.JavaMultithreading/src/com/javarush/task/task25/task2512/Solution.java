package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<Throwable> list = new ArrayList<>();

        list.add(e);

        while (e.getCause() != null) {
            list.add(e);
            e = e.getCause();
        }

        list.add(e);

        for (int i = list.size() - 1; i > 0 ; i--) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new Error("11fyg11", new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
        });

        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();
    }
}
