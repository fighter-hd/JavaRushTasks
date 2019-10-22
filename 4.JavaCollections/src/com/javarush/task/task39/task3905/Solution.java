package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color R = Color.RED;
        Color O = Color.ORANGE;
        Color V = Color.VIOLET;

        Color[][] image =  new Color[][] {{R,R,R,R,O,O},
                                          {O,R,O,O,R,R},
                                          {R,R,R,R,O,O},
                                          {O,O,R,R,R,R},
                                          {O,R,R,R,O,R},
                                          {R,O,O,O,O,R},
                                          {O,O,R,R,R,R} };

        PhotoPaint paint = new PhotoPaint();
        System.out.println(paint.paintFill(image, 2, 2, V));

        for (int row = 0; row < image.length; row++) {
            for (int column = 0; column < image[row].length; column++) {
                String color;
                Color c = image[row][column];

                if (c.equals(Color.RED)) {
                    color = "R";
                } else if (c.equals(Color.ORANGE)) {
                    color = "O";
                } else {
                    color = "V";
                }

                System.out.print(color + ",");
            }
            System.out.println();
        }
    }
}
