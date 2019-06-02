package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            Set<Wheel> wheelsSet = new HashSet<>();

            if (loadWheelNamesFromDB().length != 4) {
                throw new IllegalArgumentException();
            }

            for (String s : loadWheelNamesFromDB()) {
                wheelsSet.add(Wheel.valueOf(s));
            }

            wheels = new LinkedList<>(wheelsSet);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        for (Wheel wheel : new Car().wheels) {
            System.out.println(wheel);
        }
    }
}
