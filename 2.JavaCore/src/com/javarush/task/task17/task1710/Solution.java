package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();
    static Person person;
    static String nameFromConsole;
    static String sex;
    static Date birth;
    static int id;

    static DateFormat formatForEnteredDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0].charAt(1)) {

            case 'c':
                nameFromConsole = args[1];
                sex = args[2];
                birth = formatForEnteredDate.parse(args[3]);
                createHuman();
                System.out.println(allPeople.size() - 1);
                break;

            case 'u':
                id = Integer.parseInt(args[1]);
                nameFromConsole = args[2];
                birth = formatForEnteredDate.parse(args[4]);

                person = allPeople.get(id);

                person.setName(nameFromConsole);
                person.setSex(defineSex(args[3]));
                person.setBirthDate(birth);
                break;

            case 'd':
                id = Integer.parseInt(args[1]);

                person = allPeople.get(id);

                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;

            case 'i':
                id = Integer.parseInt(args[1]);

                person = allPeople.get(id);

                System.out.print(person.getName() + " ");

                if (person.getSex().equals(Sex.MALE)) {
                    System.out.print("м ");
                } else {
                    System.out.print("ж ");
                }

                String birthForOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate());
                System.out.print(birthForOutput);

                break;
        }
    }

    public static void createHuman() {
        switch (defineSex(sex)) {
            case MALE:
                allPeople.add(Person.createMale(nameFromConsole, birth));
                break;

            case FEMALE:
                allPeople.add(Person.createFemale(nameFromConsole, birth));
                break;
        }
    }

    public static Sex defineSex(String sex) {
        if (sex.equals("ж")) {
            return Sex.FEMALE;
        } else {
            return Sex.MALE;
        }
    }
}
