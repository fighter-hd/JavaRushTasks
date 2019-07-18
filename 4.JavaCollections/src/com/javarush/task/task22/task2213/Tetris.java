package com.javarush.task.task22.task2213;

public class Tetris {
    static Tetris game;
    private Field field;
    private Figure figure;

    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    void run() {

    }

    void step() {
        
    }

    public Field getField() {
        return field;
    }

    public Figure getFigure() {
        return figure;
    }
}
