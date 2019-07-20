package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static void convertToJSON(Writer writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File(fileName);

        T resultObject = mapper.readValue(file, clazz);

        return resultObject;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests\\JsonFile.txt";

        Dog dog = new Dog();
        dog.name = "Psina";
        dog.age = 2;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            convertToJSON(writer, dog);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Dog jsonDog = convertFromJsonToNormal(fileName, Dog.class);
            System.out.println(jsonDog);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

