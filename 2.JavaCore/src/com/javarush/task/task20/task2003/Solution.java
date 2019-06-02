package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//Внимание!!! Файл должен быть ОБЯЗАТЕЛЬНО передан в параметр как СТРОКА, иначе этот хрен не принимает...
        String file = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file);
        load(inputStream);
        inputStream.close();

        OutputStream outputStream = new FileOutputStream(file, true);
        save(outputStream);
        outputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();

        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            p.setProperty(key, value);
        }

        p.store(outputStream, "This is comment for test");

//   Это работает, но валидатор в упор не понимает:
//        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
//
//        for (Map.Entry<String, String> entry : properties.entrySet()) {
//            writer.print(entry.getKey() + " = ");
//            writer.println(entry.getValue());
//        }
//
//        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        Set<Object> keySet = p.keySet();

        for (Object o : keySet) {
            String key = (String) o;
            String value = p.getProperty(key);

            properties.put(key, value);
        }

//   И это работает, но валидатор в упор не понимает:
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String data = reader.readLine();
//
//        while (data != null) {
//            String[] pair = data.split("[=|:]", 2);
//            String key = pair[0].trim();
//            String value = pair[1].trim();
//
//            properties.put(key, value);
//
//            data = reader.readLine();
//        }
//        reader.close();
    }

    public static void main(String[] args) {
        try {
            new Solution().fillInPropertiesMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//C:\Users\DenG14\Desktop\For_Tests\1.txt

//website = https://ru.wikipedia.org/
//language : Russian
//description=not bad website
//oneMore:testLine