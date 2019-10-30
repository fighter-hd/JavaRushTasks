package com.javarush.task.task40.task4004;

import javafx.scene.shape.Polygon;

import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// код в комментариях - вариант который валидатор не принял
public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        boolean res = false;
        int j=polygon.size()-1;

        for (int i = 0; i < polygon.size(); i++) {
            if ((((polygon.get(i).y < point.y) && (point.y < polygon.get(j).y)) || ((polygon.get(j).y <= point.y) && (point.y < polygon.get(i).y))) &&
                    (point.x > (polygon.get(j).x - polygon.get(i).x) * (point.y - polygon.get(i).y) / (polygon.get(j).y - polygon.get(i).y) + polygon.get(i).x))
                res = !res;
            j=i;
        }

        return res;

// вариант 1:
//        int pointCount = polygon.size();
//
//        for(int i = pointCount - 1; i > 0; i--) {
//            if( ! vectorMultiply(polygon.get(i), polygon.get(i - 1), point)) {
//                return false;
//            }
//        }
//
//        return vectorMultiply(polygon.get(0), polygon.get(pointCount - 1), point);

// вариант 2:
//        Polygon realPolygon = new Polygon();
//        Double[] doubleArray = new Double[polygon.size() * 2];
//
//        for (int i = 0, j = 0; i < doubleArray.length; i += 2, j++) {
//            doubleArray[i] = (double) polygon.get(j).x;
//            doubleArray[i + 1] = (double) polygon.get(j).y;
//        }
//
//        realPolygon.getPoints().addAll(doubleArray);
//        return realPolygon.contains(point.x, point.y);
    }

//    private static boolean vectorMultiply(Point A, Point B, Point C) {
//        int multiplyPointCbyY = (B.x-A.x) * (C.y - A.y);
//        int multiplyPointCbyX = (B.y-A.y) * (C.x - A.x);
//
//        return (multiplyPointCbyY -  multiplyPointCbyX) >= 0;
//    }
}