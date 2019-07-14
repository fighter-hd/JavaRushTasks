package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

//        System.out.println("The list size is " + list.size());
//        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
//        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));
        System.out.println("For 3 parent is " + ((CustomTree) list).getParent("3"));
        System.out.println("For 4 parent is " + ((CustomTree) list).getParent("4"));
        System.out.println("For 5 parent is " + ((CustomTree) list).getParent("5"));
        System.out.println("For 6 parent is " + ((CustomTree) list).getParent("6"));
        System.out.println("For 7 parent is " + ((CustomTree) list).getParent("7"));
        System.out.println("For 8 parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("For 9 parent is " + ((CustomTree) list).getParent("9"));
        System.out.println("For 10 parent is " + ((CustomTree) list).getParent("10"));
        System.out.println("For 11 parent is " + ((CustomTree) list).getParent("11"));
        System.out.println("For 12 parent is " + ((CustomTree) list).getParent("12"));
        System.out.println("For 13 parent is " + ((CustomTree) list).getParent("13"));
        System.out.println("For 14 parent is " + ((CustomTree) list).getParent("14"));
        System.out.println("For 15 parent is " + ((CustomTree) list).getParent("15"));
        System.out.println("For 16 parent is " + ((CustomTree) list).getParent("16"));
        System.out.println("For 20 parent is " + ((CustomTree) list).getParent("20"));
    }
}