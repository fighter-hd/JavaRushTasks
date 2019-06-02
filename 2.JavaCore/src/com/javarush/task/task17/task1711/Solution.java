package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
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

    public static void main(String[] args) {
        if (args.length > 1) {
            switch (args[0]) {
                case "-c":
                    try {
                        synchronized (allPeople) {
                            actionC(args);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;

                case "-u":
                    try {
                        synchronized (allPeople) {
                            actionU(args);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;

                case "-d":
                    synchronized (allPeople) {
                        actionD(args);
                    }
                    break;

                case "-i":
                    synchronized (allPeople) {
                        actionI(args);
                    }
                    break;
            }
        }
    }

    private static void actionC(String[] args) throws ParseException {
        int i = 1;
        do {
            nameFromConsole = args[i++];
            sex = args[i++];
            birth = formatForEnteredDate.parse(args[i++]);
            createHuman();
            System.out.println(allPeople.size() - 1);
        } while (i < args.length);
    }

    private static void actionU(String[] args) throws ParseException {
        int i = 1;
        do {
            id = Integer.parseInt(args[i++]);
            nameFromConsole = args[i++];
            sex = args[i++];
            birth = formatForEnteredDate.parse(args[i++]);

            person = allPeople.get(id);

            person.setName(nameFromConsole);
            person.setSex(defineSex(sex));
            person.setBirthDate(birth);
        } while (i < args.length);
    }

    private static void actionD(String[] args) {
        List<String> listOfID = new ArrayList<>();

        for (String arg : args) {
            listOfID.add(arg);
        }
        listOfID.remove(0);

        for (String s : listOfID) {
            id = Integer.parseInt(s);

            person = allPeople.get(id);

            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }

    private static void actionI(String[] args) {
        List<String> listOfID = new ArrayList<>();

        for (String arg : args) {
            listOfID.add(arg);
        }
        listOfID.remove(0);

        for (String s : listOfID) {
            id = Integer.parseInt(s);
            person = allPeople.get(id);

            System.out.print(person.getName() + " ");

            if (person.getSex().equals(Sex.MALE)) {
                System.out.print("м ");
            } else {
                System.out.print("ж ");
            }

            String birthForOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDate());
            System.out.print(birthForOutput + "\n");
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
