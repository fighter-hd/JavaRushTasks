package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x, double y, double radius) {
        this.radius = radius;
        this.y = y;
        this.x = x;
    }

    public Circle(double x, double y) {
        this.y = y;
        this.x = x;
    }

    public Circle(double x) {
        this.x = x;
    }

    public Circle() { }

    public static void main(String[] args) {

    }
}