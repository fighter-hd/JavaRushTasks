package com.javarush.task.task02.task0213;

/*
Питомцам нужны люди

Создай объект типа Cat (кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
Присвой каждому животному владельца (owner).

Требования:
1. Программа не должна выводить текст на экран.
2. В методе main создай объекты типа Cat, Dog, Fish, Woman занеси их ссылки в переменные.
3. В методе main присвойте каждому животному владельца Woman.
4. Класс Cat, Dog, Fish должен содержать только одну переменную Woman owner.
5. Класс Woman не должен содержать переменных.
*/
public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Fish fish = new Fish();
        Woman woman = new Woman();

        cat.owner = woman;
        dog.owner = woman;
        fish.owner = woman;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
