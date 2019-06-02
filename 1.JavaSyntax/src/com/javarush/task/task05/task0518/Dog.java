package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/


public class Dog {
    String name;
    int height;
    String color;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int height) {
        this.height = height;
        this.name = name;
    }

    public Dog(String name, int height, String color) {
        this.color = color;
        this.height = height;
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
