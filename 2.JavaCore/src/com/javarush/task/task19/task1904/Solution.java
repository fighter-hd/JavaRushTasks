package com.javarush.task.task19.task1904;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        //этот метод только для проверки работы, для задания не требовался, но и с ним валидатор принял

        String fileName = "C:\\Users\\DenG14\\Desktop\\For_Tests\\1.txt";
        FileReader fileReader = new FileReader(fileName);

        PersonScanner psa = new PersonScannerAdapter(new Scanner(fileReader));
        psa.read();
        psa.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person;

            String data = fileScanner.nextLine();

            String[] dataArray = data.split(" ");

            String firstName = dataArray[1];
            String middleName = dataArray[2];
            String lastName = dataArray[0];
            String strBDate = dataArray[3] + " " + dataArray[4] + " " + dataArray[5];

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            Date birth = new Date();
            try {
                birth = dateFormat.parse(strBDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            person = new Person(firstName, middleName, lastName, birth);

            System.out.println(person);

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
