package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution s1 = new Solution();
        s1.innerClasses[0] = s1.new InnerClass();
        s1.innerClasses[1] = s1.new InnerClass();

        Solution s2 = new Solution();
        s2.innerClasses[0] = s2.new InnerClass();
        s2.innerClasses[1] = s2.new InnerClass();


        return new Solution[]{s1, s2};
    }

    public static void main(String[] args) {

    }
}
