package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rfile = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line;
        StringBuilder stb = new StringBuilder();
        try {
            while ((line=rfile.readLine())!=null) {
                stb.append(line+" ");
            }
        } finally {
            rfile.close();
        }
        StringBuilder result = getLine(stb.toString().trim().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        if (words.length == 0) {
            return builder;
        }

        List<LinkedList<String>> listOfSequences = new ArrayList<>();
        List<LinkedList<String>> listOfSingleWords = new ArrayList<>();

        for (String word :  words) {
            List<String> matchesList = new LinkedList<>(Arrays.asList(words));
            List<String> matchesListCopy = new LinkedList<>(matchesList);
            LinkedList<String> withoutMatchesList = new LinkedList<>();
            LinkedList<String> resultList = new LinkedList<>();

            String comparedWord = word;
            matchesList.remove(word);
            matchesListCopy.remove(word);

            while (true) {
                char lastOfFirst = Character.toLowerCase(comparedWord.charAt(comparedWord.length() - 1));
                boolean hasNextWord = false;

                for (String anotherWord : matchesList) {
                    char firstOfSecond = Character.toLowerCase(anotherWord.charAt(0));

                    if (lastOfFirst == firstOfSecond) {
                        hasNextWord = true;
                        resultList.add(comparedWord);
                        comparedWord = anotherWord;
                        matchesListCopy.remove(comparedWord);

                        if (matchesListCopy.isEmpty()) {
                            resultList.add(comparedWord);
                        }
                        break;
                    }
                }

                if ( ! hasNextWord) {
                    withoutMatchesList.add(comparedWord);
                    if (matchesListCopy.isEmpty()) {
                        break;
                    } else {
                        withoutMatchesList.addAll(matchesListCopy);
                        break;
                    }
                }
                matchesList = matchesListCopy;

                if (matchesList.isEmpty()) {
                    withoutMatchesList.add(comparedWord);
                    break;
                }
            }

            listOfSequences.add(resultList);
            listOfSingleWords.add(withoutMatchesList);
        }

        int longestSequence = listOfSequences.get(0).size();
        int indexOfLongest = 0;

//        System.out.print("Num " + 0 + ": ");
//        for (String string : listOfSequences.get(0)) {
//            System.out.print(string + " ");
//        }
//        System.out.print("|||| ");
//        for (String singleWord : listOfSingleWords.get(0)) {
//            System.out.print(singleWord + " ");
//        }
//        System.out.println();
        for (int i = 1; i < listOfSequences.size(); i++) {
            int currentSequenceSize = listOfSequences.get(i).size();
            if (currentSequenceSize == longestSequence) {
                String first = listOfSequences.get(indexOfLongest).getFirst();
                String second = listOfSequences.get(i).getFirst();

                if (first.compareTo(second) > 0) {
                    longestSequence = currentSequenceSize;
                    indexOfLongest = i;
                }

            } else if (currentSequenceSize > longestSequence) {
                longestSequence = currentSequenceSize;
                indexOfLongest = i;
            }

//            System.out.print("Num " + i + ": ");
//            for (String string : listOfSequences.get(i)) {
//                System.out.print(string + " ");
//            }
//            System.out.print("|||| ");
//            for (String s : listOfSingleWords.get(i)) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
        }

//        System.out.println();

        for (String word : listOfSequences.get(indexOfLongest)) {
            builder.append(word);
            builder.append(" ");
        }

        for (String word : listOfSingleWords.get(indexOfLongest)) {
            if (builder.lastIndexOf(word) == -1) {
                builder.append(word);
                builder.append(" ");
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder;
    }
}