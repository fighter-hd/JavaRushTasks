package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        if (first == null && last == null) {
            return 0;
        }

        return first.length() * last.length() + 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (this != null && o == null) return false;

        if ( ! (o instanceof Solution)) return false;

        Solution n = (Solution) o;

        return ((n.first == null && first == null) || n.first.equals(first)) &&
                ((n.last == null && last == null) || n.last.equals(last));
    }

    public static void main(String[] args) {
        Set<Solution> set = new HashSet<>();

        Solution s1 = new Solution("Mickey", "Mouse");
        set.add(s1);

        Solution s2 = new Solution("Mickey", "Mouse");
        System.out.println(set.contains(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
