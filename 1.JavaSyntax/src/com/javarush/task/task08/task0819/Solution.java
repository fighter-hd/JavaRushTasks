package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> iterator = cats.iterator();

        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> setOfCats = new HashSet<>();

        setOfCats.add(new Cat());
        setOfCats.add(new Cat());
        setOfCats.add(new Cat());

        return setOfCats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    public static class Cat {

    }
}
