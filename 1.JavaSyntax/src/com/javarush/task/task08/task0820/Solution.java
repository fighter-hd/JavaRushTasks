package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> catsSet = new HashSet<Cat>();

        catsSet.add(new Cat());
        catsSet.add(new Cat());
        catsSet.add(new Cat());
        catsSet.add(new Cat());

        return catsSet;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> dogsSet = new HashSet<>();

        dogsSet.add(new Dog());
        dogsSet.add(new Dog());
        dogsSet.add(new Dog());

        return dogsSet;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> pets = new HashSet<>();

        pets.addAll(dogs);
        pets.addAll(cats);

        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        Iterator<Object> iterator = pets.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        for (Object pet : pets) {
//            System.out.println(pet);
//        }
    }

    public static class Dog {

    }

    public static class Cat {

    }
}
