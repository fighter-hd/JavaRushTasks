package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine();
        String grandmotherName = reader.readLine();
        String fatherName = reader.readLine();
        String motherName = reader.readLine();
        String sonName = reader.readLine();
        String daughterName = reader.readLine();

        Cat catGrandfather = new Cat(grandfatherName);
        Cat catGrandmother = new Cat(grandmotherName);
        Cat catFather = new Cat(fatherName, null, catGrandfather);
        Cat catMother = new Cat(motherName, catGrandmother, null);
        Cat catSon = new Cat(sonName, catMother, catFather);
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandfather);
        System.out.println(catGrandmother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            if (mother == null && father == null) {
                return "The cat's name is " + name + ", no mother, no father";
            } else if(mother == null && father != null) {
                    return "The cat's name is " + name + ", no mother, father is " + father.name;
                } else if(mother != null && father == null) {
                        return "The cat's name is " + name + ", mother is " + mother.name + ", no father";
                    } else {
                        return "The cat's name is " + name + ", mother is " + mother.name + ", father is " + father.name;
                        }

        }
    }

}
