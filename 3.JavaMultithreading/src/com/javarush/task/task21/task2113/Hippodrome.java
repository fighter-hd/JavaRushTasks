package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Loshadka1", 3, 0));
        horses.add(new Horse("Loshadka2", 3, 0));
        horses.add(new Horse("Loshadka3", 3, 0));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    void move() {
        for (Horse hors : horses) {
            hors.move();
        }
    }

    void print() {
        for (Horse hors : horses) {
            hors.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        Horse theWinner = null;

        for (Horse hors : horses) {
            if (theWinner == null) {
                theWinner = hors;
            }

            if (hors.getDistance() > theWinner.getDistance()) {
                theWinner = hors;
            }
        }

        return theWinner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
