package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    final int x;

    BinaryRepresentationTask(int x) { this.x = x; }

    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);

        if (b > 0) {
            BinaryRepresentationTask task1 = new BinaryRepresentationTask(a);
            task1.fork();
            BinaryRepresentationTask task2 = new BinaryRepresentationTask(b);
            return task2.compute() + task1.join();
        }
        return result;
    }
}
