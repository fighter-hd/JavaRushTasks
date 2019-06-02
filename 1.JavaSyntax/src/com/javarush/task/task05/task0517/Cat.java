package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat(String name) {
        this.name = name;
        weight = 5;
        age = 3;
        color = "white";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "white";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 5;
        color = "white";
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
        age = 3;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 3;
    }

    public static void main(String[] args) {

    }
}
