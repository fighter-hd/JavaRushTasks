package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person father = new Person("firstName1", "lastName1", 49);
        Person mother = new Person("firstName2", "lastName1", 45);
        Person child1 = new Person("firstName3", "lastName1", 15);
        Person child2 = new Person("firstName4", "lastName1", 13);

        child1.setFather(father);
        child1.setMother(mother);
        child2.setFather(father);
        child2.setMother(mother);

        List<Person> list = new ArrayList<>();
        list.add(child1);
        list.add(child2);

        father.setChildren(list);
        mother.setChildren(list);

        OutputStream outputStream = new FileOutputStream("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt", false);
        ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
        father.writeExternal(objectOutput);
        mother.writeExternal(objectOutput);
        objectOutput.close();

        InputStream inputStream = new FileInputStream("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt");
        ObjectInput objectInput = new ObjectInputStream(inputStream);
        father.readExternal(objectInput);
        mother.readExternal(objectInput);
        objectInput.close();
    }
}

