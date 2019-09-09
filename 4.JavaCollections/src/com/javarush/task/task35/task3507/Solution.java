package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                                                        + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> resultSet = new HashSet<>();

        try {
            String decodePathToAnimals = URLDecoder.decode(pathToAnimals, "UTF-8");
            File[] files = new File(decodePathToAnimals).listFiles();

            for (File currentFile : files) {
                String packageName = Solution.class.getPackage().getName() + ".data";
                Class clazz = new AnimalClassLoader().animalLoadClass(currentFile.toPath(), packageName);

                if (Animal.class.isAssignableFrom(clazz)) {
                    Constructor constructor = clazz.getConstructor();
                    Animal animal = (Animal) constructor.newInstance();
                    resultSet.add(animal);
                }
            }

        } catch (Exception ignore) {
            //ignore
        }

        return resultSet;
    }

    private static class AnimalClassLoader extends ClassLoader {
        public Class<?> animalLoadClass(Path path, String packageName) throws ClassNotFoundException {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] buffer = Files.readAllBytes(path);
                return defineClass(className, buffer, 0, buffer.length);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
