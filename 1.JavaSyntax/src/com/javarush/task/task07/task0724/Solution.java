package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Human grandpa1 = new Human("Дед 1", true, 65);
        Human grandpa2 = new Human("Дед 2", true, 68);
        Human grandma1 = new Human("Бабка 1", false, 62);
        Human grandma2 = new Human("Бабка 2", false, 70);
        Human father = new Human("Вася", true, 40, grandpa1, grandma1);
        Human mother = new Human("Оля", false, 36, grandpa2, grandma2);
        Human child1 = new Human("Валя", false, 16, father, mother);
        Human child2 = new Human("Саня", true, 12, father, mother);
        Human child3 = new Human("Валя", false, 10, father, mother);

        List<Human> family = Arrays.asList(grandpa1, grandma1, grandpa2, grandma2,
                father, mother, child1, child2, child3);

        for (Human human : family) {
            System.out.println(human.toString());
        }
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human (String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}