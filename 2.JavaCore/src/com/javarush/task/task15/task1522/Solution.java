package com.javarush.task.task15.task1522;

import java.util.Scanner;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals(Planet.SUN)) {
            thePlanet = Sun.getInstance();
        } else if (input.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        } else if (input.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        } else {
            thePlanet = null;
        }
    }
}
