package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this == null && o == null) {
            return true;
        }

        if (this != null && o == null) {
            return false;
        }

        if (! (o instanceof Solution)) {
            return false;
        }
        Solution n = (Solution) o;

        return ((n.first == null && first == null) || n.first.equals(first)) &&
                ((n.last == null && last == null) || n.last.equals(last));
    }

    public int hashCode() {
        if (first == null && last == null) {
            return 0;
        }

        if (first == null) {
            return 1;
        }

        if (last == null) {
            return 2;
        }

        return first.length() * last.length() + 3;
    }

    public static void main(String[] args) {
        Set<Solution> set = new HashSet<>();

        Solution s1 = new Solution("", "");
        Solution s2 = new Solution("", "");

        set.add(s1);
        System.out.println(set.contains(s2));
        System.out.println(s1.equals(s2));
    }
}
