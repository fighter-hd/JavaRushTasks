package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surname;
        private int age;
        private boolean sex;
        private Human father;
        private Human mother;

        public Human (){}

        public Human (String name) {
            this.name = name;
        }

        public Human (String name, String surname) {
            this(name);
            this.surname = surname;
        }

        public Human (String name, String surname, int age) {
            this(name, surname);
            this.age = age;
        }

        public Human (String name, String surname, int age, boolean sex) {
            this(name, surname, age);
            this.sex = sex;
        }

        public Human (String name, String surname, int age, boolean sex, Human father) {
            this(name, surname, age, sex);
            this.father = father;
        }

        public Human (String name, String surname, int age, boolean sex, Human father, Human mother) {
            this(name, surname, age, sex, father);
            this.mother = mother;
        }

        public Human (String name, int age, String surname, boolean sex, Human father, Human mother) {
            this(name, surname, age, sex, father, mother);
        }

        public Human (String name, int age, String surname, Human father, Human mother, boolean sex) {
            this(name, surname, age, sex, father, mother);
        }

        public Human (boolean sex, String name, int age, String surname, Human father, Human mother) {
            this(name, surname, age, sex, father, mother);
        }
    }
}
