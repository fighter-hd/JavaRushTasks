package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bReader = new BufferedReader(fileReader);

        while (bReader.ready()) {
            String line = bReader.readLine();
            String[] lines = line.split(" ");

            StringBuilder nameBuilder = new StringBuilder();

            for (int i = 0; i < lines.length - 3; i++) {
                nameBuilder.append(lines[i]);
                nameBuilder.append(" ");
            }

            int year = Integer.parseInt(lines[lines.length - 1]) - 1900;
            int month = Integer.parseInt(lines[lines.length - 2]) - 1;
            int day = Integer.parseInt(lines[lines.length - 3]);

            Date birth = new Date();
            birth.setYear(year);
            birth.setMonth(month);
            birth.setDate(day);
            birth.setHours(0);
            birth.setMinutes(0);

            PEOPLE.add(new Person(nameBuilder.toString().trim(), birth));
        }

        bReader.close();
        fileReader.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt

//Sidorov Sergey 30 08 1993
//Kozlova Nadezhda-Anna 02 06 1972
//Ivanov Ivan Ivanovich 15 04 1975
//Vasiliy 09 11 1984
