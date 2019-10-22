package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("ab", null));      // false
        System.out.println(isOneEditAway("ab", ""));        // false
        System.out.println(isOneEditAway("abcd", "ab"));    // false
        System.out.println(isOneEditAway("abcde", "b"));    // false
        System.out.println(isOneEditAway("xzzz", "zxzz"));  // false
        System.out.println(isOneEditAway("asdfg", "aZdf")); // false
        System.out.println(isOneEditAway("poiuy", "poud")); // false
        System.out.println("============================");
        System.out.println(isOneEditAway("", ""));          // true
        System.out.println(isOneEditAway("a", ""));         // true
        System.out.println(isOneEditAway("qert", "qwert")); // true
        System.out.println(isOneEditAway("abcd", "abd"));   // true
        System.out.println(isOneEditAway("zzz", "zzzz"));   // true
        System.out.println(isOneEditAway("xzzz", "zzzz"));  // true
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        if (first.equals(second)) {
            return true;
        }

        int firstLength = first.length();
        int secondLength = second.length();

        if (firstLength == secondLength) {
            return isOneEditAwayHelperSameSize(first, second);
        }

        if ((firstLength + 1) == secondLength) {
            return isOneEditAwayHelperSmallBig(first, second);
        }

        if ((firstLength - 1) == secondLength) {
            return isOneEditAwayHelperSmallBig(second, first);
        }

        return false;
    }

    private static boolean isOneEditAwayHelperSameSize(String first, String second) {
        int mismatchCount = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                mismatchCount++;
            }
        }

        return mismatchCount == 1;
    }

    private static boolean isOneEditAwayHelperSmallBig(String smaller, String bigger) {
        int smallerLength = smaller.length();

        if (smallerLength == 0) {
            return true;
        }

        int modificationsCount = 0;

        for (int sm = 0, bg = 0; sm < smallerLength; sm++, bg++) {
            char smallerChar = smaller.charAt(sm);
            char biggerChar = bigger.charAt(bg);

            if (smallerChar != biggerChar) {
                if (++modificationsCount > 1) {
                    return false;
                }

                biggerChar = bigger.charAt(++bg);

                if (smallerChar != biggerChar) {
                    return false;
                }
            }
        }

        return true;
    }
}
