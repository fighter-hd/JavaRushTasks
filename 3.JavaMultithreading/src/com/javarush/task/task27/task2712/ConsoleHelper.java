package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();

    }


    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage("Введите строку/строки с названием нижеперечисленных блюд для их заказа." +
                     "\nВведите \"exit\" для формирования заказа.");
        writeMessage(Dish.allDishesToString());

        List<Dish> orderedDishes = new ArrayList<>();

        String order = readString();
        while ( ! order.equals("exit")) {
            switch (order) {
                case "Fish":
                    orderedDishes.add(Dish.Fish);
                    order = readString();
                    break;

                case "Steak":
                    orderedDishes.add(Dish.Steak);
                    order = readString();
                    break;

                case "Soup":
                    orderedDishes.add(Dish.Soup);
                    order = readString();
                    break;

                case "Juise":
                    orderedDishes.add(Dish.Juice);
                    order = readString();
                    break;

                case "Water":
                    orderedDishes.add(Dish.Water);
                    order = readString();
                    break;

                default:
                    writeMessage("Такого блюда нет в меню. Повторите снова.");
                    order = readString();
            }
        }

        return orderedDishes;
    }
}
