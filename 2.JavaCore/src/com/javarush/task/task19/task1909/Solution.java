package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
            char c = (char) reader.read();

            if (c == '.') {
                c = '!';
            }

            data.append(c);
        }
        reader.close();

        String result = String.valueOf(data);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        writer.write(result);
        writer.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt
//C:\Users\DenG14\Desktop\For_Tests\Result.txt

//34.rbvtr/tgr.tre,ced.,32432\./\,.