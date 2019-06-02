package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        threads.get(3).start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        while (true) {

        }
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                throw new InterruptedException();
            } catch (InterruptedException exception) {
                System.out.println("InterruptedException");
            }
        }
    }
}

class Thread3 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Ура");
            try {
                sleep(500);
            } catch (InterruptedException exception) {
                System.out.println("\"Ура\" остановлено.");
            }
        }
    }
}

class Thread4 extends Thread implements Message {
    @Override
    public void run() {
        while (!this.isInterrupted()) {

        }
    }

    @Override
    public void showWarning() {
        this.interrupt();
    }
}

class Thread5 extends Thread {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String enteredData;
    int sumOfNumbers;

    @Override
    public void run() {
        try {
            enteredData = reader.readLine();
            while (!enteredData.equals("N")) {
                sumOfNumbers += Integer.parseInt(enteredData);
                enteredData = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sumOfNumbers);
    }
}