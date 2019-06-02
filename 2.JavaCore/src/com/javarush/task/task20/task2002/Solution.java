package com.javarush.task.task20.task2002;

import javafx.scene.input.DataFormat;

import java.io.*;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt");
            OutputStream outputStream = new FileOutputStream(yourFile, false);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User("fName1", "lName1", new Date(2146990000), true, User.Country.UKRAINE);
            User user2 = new User();
            User user3 = new User("fName2", "lName2", new Date(2146999000), false, User.Country.OTHER);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.close();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            inputStream.close();
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.users.get(2).getBirthDate().getTime());
            System.out.println(loadedObject.users.get(2).getBirthDate().getTime());
            System.out.println(javaRush.users.get(2).getBirthDate().equals(loadedObject.users.get(2).getBirthDate()));
            System.out.println(javaRush.users.get(2).equals(loadedObject.users.get(2)));
            System.out.println();

            System.out.println(loadedObject.equals(javaRush));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(outputStream));

            if (users.size() > 0) {
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate());
                    writer.println(user.isMale());
                    writer.println(user.getCountry());
                }
            }

            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                String firstName = checkString(reader.readLine());
                String lastName = checkString(reader.readLine());
                Date birthDate = null;
                boolean isMale = false;
                User.Country country = null;

                String birthString = reader.readLine();
                if (! birthString.equals("null")) {
                    DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    birthDate = dateFormat.parse(birthString);
                }

                if (checkString(reader.readLine()).equals("true")) {
                    isMale = true;
                }

                switch (reader.readLine()) {
                    case "UKRAINE":
                        country = User.Country.UKRAINE;
                        break;
                    case "RUSSIA":
                        country = User.Country.RUSSIA;
                        break;
                    case "OTHER":
                        country = User.Country.OTHER;
                        break;
                }

                users.add(new User(firstName, lastName, birthDate, isMale, country));
            }
        }

        private String checkString(String data) {
            String result = null;
            if (data != null && ! data.equals("null")) {
                result = data;
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
