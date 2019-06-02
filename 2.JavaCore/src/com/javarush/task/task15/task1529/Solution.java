package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String typeOfAircraft = buffer.readLine();

        if (typeOfAircraft.equals("helicopter")) {
            result = new Helicopter();
        } else if (typeOfAircraft.equals("plane")) {
            int numOfPassengers = Integer.parseInt(buffer.readLine());
            result = new Plane(numOfPassengers);
        }

        buffer.close();
    }
}
