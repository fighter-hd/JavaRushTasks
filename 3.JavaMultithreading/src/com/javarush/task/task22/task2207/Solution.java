package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())))) {

            List<String> list = new ArrayList<>();

            while(reader.ready()) {
                String[] workArray = reader.readLine().split(" ");
                for (String aWord : workArray) {
                    list.add(aWord);
                }
            }

            //так как первым символом в файле с кодировкой UTF-8 идёт служебный символ "ВОМ" его нужно убрать
            //для корректного сравнения с первым словом
            if (list.get(0).contains("\uFEFF")) {
                list.set(0, list.get(0).substring(1));
            }

            for (int i = 0; i < list.size() - 1; i++) {
                String first = list.get(i);

                for (int j = i + 1; j < list.size(); j++) {
                    String second = list.get(j);
                    StringBuilder builder = new StringBuilder(second);

                    if (first.equals(builder.reverse().toString())) {
                        Pair pair = new Pair();
                        pair.first = first;
                        pair.second = second;

                        if ( ! result.contains(pair)) {
                            result.add(pair);
                        }
                    }
                }
            }

            for (Pair pair : result) {
                System.out.println(pair);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
}

/*
рот тор торт о
о тот тот тот
 */
