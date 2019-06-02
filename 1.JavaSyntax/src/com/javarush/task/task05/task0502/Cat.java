package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        return (this.strength * this.weight + this.age * 0.1) > (anotherCat.weight * anotherCat.strength + anotherCat.age * 0.1);
    }

    public static void main(String[] args) {

    }
}
