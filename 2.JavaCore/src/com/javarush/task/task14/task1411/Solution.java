package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> list = new ArrayList<>();
        String key = null;

        while ((key = reader.readLine()).equals("user") || key.equals("loser")
                || key.equals("coder") || key.equals("proger"))
        {
            switch (key) {
                case "user":
                    list.add(new Person.User());
                    break;
                case "loser":
                    list.add(new Person.Loser());
                    break;
                case "coder":
                    list.add(new Person.Coder());
                    break;
                case "proger":
                    list.add(new Person.Proger());
                    break;
            }
        }
        for (Person person : list) {
            doWork(person);
        }

    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        } else {
            ((Person.Proger) person).enjoy();
        }
    }
}
