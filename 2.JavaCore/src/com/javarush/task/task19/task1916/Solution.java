package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader1 = new FileReader(bufferedReader.readLine());
        FileReader fileReader2 = new FileReader(bufferedReader.readLine());
        bufferedReader.close();

        BufferedReader reader1 = new BufferedReader(fileReader1);
        List<String> list1 = new ArrayList<>();

        while (reader1.ready()) {
            list1.add(reader1.readLine());
        }
        reader1.close();
        fileReader1.close();

        BufferedReader reader2 = new BufferedReader(fileReader2);
        List<String> list2 = new ArrayList<>();

        while (reader2.ready()) {
            list2.add(reader2.readLine());
        }
        reader2.close();
        fileReader2.close();

        int index1 = 0;
        int index2 = 0;

        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1).equals(list2.get(index2))) {
                lines.add(new LineItem(Type.SAME, list1.get(index1)));
                index1++;
                index2++;

            } else if (index1 + 1 < list1.size() && list2.get(index2).equals(list1.get(index1 + 1))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(index1)));
                index1++;

            } else if (index2 + 1 < list2.size() && list1.get(index1).equals(list2.get(index2 + 1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(index2)));
                index2++;

            } else if (index1 + 1 == list1.size() && index2 + 1 == list2.size()) {
                String fromFile1 = list1.get(index1);
                String fromFile2 = list2.get(index2);

                if (fromFile1.compareTo(fromFile2) < 0) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(index1)));
                    lines.add(new LineItem(Type.ADDED, list2.get(index2)));
                    index1++;
                    index2++;
                }

                if (fromFile1.compareTo(fromFile2) > 0) {
                    lines.add(new LineItem(Type.ADDED, list2.get(index2)));
                    lines.add(new LineItem(Type.REMOVED, list1.get(index1)));
                    index1++;
                    index2++;
                }
            }
        }

        if (index1 == list1.size() && index2 < list2.size()) {
            lines.add(new LineItem(Type.ADDED, list2.get(index2)));

        } else if (index2 == list2.size() && index1 < list1.size()) {
            lines.add(new LineItem(Type.REMOVED, list1.get(index1)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

//C:\Users\DenG14\Desktop\For_Tests\1.txt
//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt

//line1     line1
//line2
//line3     line3
//line4
//line5     line5
//          line0
//line1