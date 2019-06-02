package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("Child 1", true, 19);
        Human child2 = new Human("Child 2", false, 15);
        Human child3 = new Human("Child 3", true, 13);
        Human papa = new Human("Papa", true, 42, child1, child2, child3);
        Human mama = new Human("Mama", false, 43, child1, child2, child3);
        Human ded1 = new Human("Ded1", true, 67, papa);
        Human ded2 = new Human("Ded2", true, 70, mama);
        Human babka1 = new Human("Babka1", false, 64, papa);
        Human babka2 = new Human("Babka2", false, 68, mama);

        List<Human> list = Arrays.asList(ded1, ded2, babka1, babka2, papa, mama, child1, child2, child3);

        list.forEach(System.out::println);
    }

    public static class Human {
        String name;
        int age;
        boolean sex;
        List<Human> children = new ArrayList<>();

        Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        Human (String name, boolean sex, int age, Human... humans) {
            this(name, sex, age);
            for (Human human : humans) {
                children.add(human);
            }
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
