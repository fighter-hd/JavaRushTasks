package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        StringBuilder data = new StringBuilder();

        while (reader.ready()) {
            data.append(reader.readLine());
        }
        reader.close();

        String s = String.valueOf(data);

        String result = s.replaceAll("\\p{Punct}", "");

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        writer.write(result);
        writer.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt
//C:\Users\DenG14\Desktop\For_Tests\Result.txt

//S/T,A?R!T000.rb;v?tr /tgr.tr
//e,ce d. ,32 43!2\d.jyh/ \qwf
//dc ,5 .End!