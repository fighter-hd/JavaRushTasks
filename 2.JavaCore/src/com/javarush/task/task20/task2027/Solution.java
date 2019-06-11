package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

//Это мой вариант, работает, но валидатор не принял
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> resultList = detectAllWords(crossword,"leo", "home", "sun", "same", "god", "red", "mo");

        for (Word word : resultList) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();

        for (String checkedWord : words) {
            Word currentWord = new Word(checkedWord);
            detectCurrentWord(crossword, currentWord);
            list.add(currentWord);
        }

        return list;
    }

    private static void detectCurrentWord(int[][] crossword, Word word) {
        char firstChar = word.text.charAt(0);

        for (int row = 0; row < crossword.length; row++) {
            for (int column = 0; column < crossword[row].length; column++) {

                if (firstChar == crossword[row][column]) {
                    int secondCharIndex = 1;
                    boolean secondCharFound = findSecondChar(crossword, word, secondCharIndex, row, column);

                    if (secondCharFound) {
                        word.setStartPoint(column, row);
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private static boolean findSecondChar(int[][] crossword, Word word, int charIndex,
                                          int row, int column) throws ArrayIndexOutOfBoundsException {
        boolean result = false;
        char nextChar = word.text.charAt(charIndex);
        int deltaRow = 0;
        int deltaColumn = 0;

        try {
            if (nextChar == crossword[row][column + 1]) {
                deltaColumn += 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row][column - 1]) {
                deltaColumn -= 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row + 1][column]) {
                deltaRow += 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row - 1][column]) {
                deltaRow -= 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row + 1][column + 1]) {
                deltaColumn += 1;
                deltaRow += 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row + 1][column - 1]) {
                deltaColumn -= 1;
                deltaRow += 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row - 1][column + 1]) {
                deltaColumn += 1;
                deltaRow -= 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        try {
            if (nextChar == crossword[row - 1][column - 1]) {
                deltaColumn -= 1;
                deltaRow -= 1;
                return findNextChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn);
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {
            //continue checking
        }

        return false;
    }

    private static boolean findNextChar(int[][] crossword, Word word, int charIndex, int row, int column,
                                        int deltaRow, int deltaColumn) throws ArrayIndexOutOfBoundsException {
        boolean result = true;
        row += deltaRow;
        column += deltaColumn;

        char nextChar = 0;
        if (charIndex != word.text.length() - 1) {
            nextChar = word.text.charAt(++charIndex);
        } else {
            word.setEndPoint(column, row);
            return result;
        }

        row += deltaRow;
        column += deltaColumn;

        if (result
            && charIndex == word.text.length() - 1
            && checkLastChar(crossword, word, charIndex, row, column, deltaRow, deltaColumn)) {

                word.setEndPoint(column, row);

        } else {
            if (nextChar == crossword[row][column]) {
                result = findNextChar(crossword, word, ++charIndex, row, column, deltaRow, deltaColumn);
            } else {
                result = false;
            }
        }

        return result;
    }

    private static boolean checkLastChar(int[][] crossword, Word word, int charIndex, int row, int column,
                                         int deltaRow, int deltaColumn) throws ArrayIndexOutOfBoundsException {
        boolean result = true;
        char lastChar = word.text.charAt(charIndex);

        if (lastChar != crossword[row][column]) {
            result = false;
        }

        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

//Тот вариант что принял валидатор
//public class Solution {
//    public static void main(String[] args) {
//        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//        };
//        List<Word> words = detectAllWords(crossword, "home", "same", "oln", "re");
//        for (Word w :
//                words) {
//            System.out.println(w);
//        }
//
//        /*
//Ожидаемый результат
//home - (5, 3) - (2, 0)
//same - (1, 1) - (4, 1)
//         */
//    }
//    //create array of possible directions
//    private static String[] directions(int[][] crossword, int x, int y, int secondChar) {
//        StringBuilder resultBuilder = new StringBuilder();
//        if (y > 0) {
//            if (crossword[y - 1][x] == secondChar) resultBuilder.append("N ");
//        }
//        if (x < crossword[y].length - 1 && y > 0) {
//            if (crossword[y - 1][x + 1] == secondChar) resultBuilder.append("NE ");
//        }
//        if (x < crossword[y].length - 1) {
//            if (crossword[y][x + 1] == secondChar) resultBuilder.append("E ");
//        }
//        if (y < crossword.length - 1 && x < crossword[y].length - 1) {
//            if (crossword[y + 1][x + 1] == secondChar) resultBuilder.append("SE ");
//        }
//        if (y < crossword.length - 1) {
//            if (crossword[y + 1][x] == secondChar) resultBuilder.append("S ");
//        }
//        if (x > 0 && y < crossword.length - 1) {
//            if (crossword[y + 1][x - 1] == secondChar) resultBuilder.append("SW ");
//        }
//        if (x > 0) {
//            if (crossword[y][x - 1] == secondChar) resultBuilder.append("W ");
//        }
//        if (x > 0 && y > 0) {
//            if (crossword[y - 1][x - 1] == secondChar) resultBuilder.append("NW ");
//        }
//        return resultBuilder.toString().split(" ");
//    }
//    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//        List<Word> result = new ArrayList<>();
//        for (String word :
//                words) {
//            boolean found = false;
//            for (int y = 0; y < crossword.length; y++) {
//                for (int x = 0; x < crossword[y].length; x++) {
//                    if (word.charAt(0) == crossword[y][x]) {
//                        for (String direction :
//                                directions(crossword, x, y, word.charAt(1))) {
//                            if (!direction.equals("")) {
//                                int tempX = x, tempY = y;
//                                StringBuilder sb = new StringBuilder();
//                                sb.append((char) crossword[tempY][tempX]);
//                                while (!sb.toString().equals(word)) {
//                                    //switch can be moved out to another method
//                                    switch (direction) {
//                                        case "S": {
//                                            tempY++;
//                                            break;
//                                        }
//                                        case "N": {
//                                            tempY--;
//                                            break;
//                                        }
//                                        case "E": {
//                                            tempX++;
//                                            break;
//                                        }
//                                        case "W": {
//                                            tempX--;
//                                            break;
//                                        }
//                                        case "NE": {
//                                            tempX++;
//                                            tempY--;
//                                            break;
//                                        }
//                                        case "NW": {
//                                            tempX--;
//                                            tempY--;
//                                            break;
//                                        }
//                                        case "SW": {
//                                            tempX--;
//                                            tempY++;
//                                            break;
//                                        }
//                                        case "SE": {
//                                            tempX++;
//                                            tempY++;
//                                            break;
//                                        }
//
//                                    }
//                                    try {
//                                        sb.append((char) crossword[tempY][tempX]);
//                                    } catch (ArrayIndexOutOfBoundsException e) {
//                                        break;
//                                    }
//
//                                }
//                                if (sb.toString().equals(word)) {
//                                    found = true; //prevents multiple additions of same word
//                                    result.add(new Word(sb.toString()));
//                                    result.get(result.size() - 1).setStartPoint(x, y);
//                                    result.get(result.size() - 1).setEndPoint(tempX, tempY);
//                                }
//
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
//
//    public static class Word {
//        private String text;
//        private int startX;
//        private int startY;
//        private int endX;
//        private int endY;
//
//        public Word(String text) {
//            this.text = text;
//        }
//
//        public void setStartPoint(int i, int j) {
//            startX = i;
//            startY = j;
//        }
//
//        public void setEndPoint(int i, int j) {
//            endX = i;
//            endY = j;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
//        }
//    }
//}
