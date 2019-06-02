package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name = bfr.readLine();

        int y = Integer.parseInt(bfr.readLine());
        int m = Integer.parseInt(bfr.readLine());
        int d = Integer.parseInt(bfr.readLine());

        //  или так:
        // System.out.println("Меня зовут " + name + ".\nЯ родился " + d + "." + m + "." + y);

        //  или так
        Date birthday = new Date(y - 1900, m - 1, d);

        SimpleDateFormat form = new SimpleDateFormat("d.M.y");

        System.out.println("Меня зовут " + name + ".\nЯ родился " + form.format(birthday));
    }
}
