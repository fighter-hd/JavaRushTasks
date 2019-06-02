package com.javarush.task.Excercise.ClassesAndKkonsrucktors;

/*
    Сайт знакомств

    Вы создаете базу данных пользователей для сайта знакомств.
    Да вот беда — вы подзабыли в каком порядке их нужно указывать, а технического задания под рукой нет.
    Спроектируйте класс User,  у которого будут поля — имя (String) возраст (short) и рост (int).
    Создайте для него неоходимое количество конструкторов, чтобы имя, возраст и рост можно было указывать в любом порядке.
*/

public class User {

    String name;
    short age;
    int height;

    User (String name, short age, int height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    User (String name, int height, short age){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    User (short age, String name, int height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    User (int height, String name, short age){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    User (int height, short age, String name){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    User (short age, int height, String name){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
