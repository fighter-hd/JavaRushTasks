package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    int number;
    String line;
    double d;

    public Solution(){

    }

    protected Solution(int number){
        this.number = number;
    }

    Solution(int number, String line){
        this(number);
        this.line = line;
    }

    private Solution(int number, String line, double d) {
        this(number, line);
        this.d = d;
    }
}

