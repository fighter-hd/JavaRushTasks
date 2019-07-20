package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Dog {
    public String name;
    public int age;

    @Override
    public String toString() {
        return "Name - " + name + ", age - " + age;
    }
}
