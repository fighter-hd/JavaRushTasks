package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        int height = image.length;
        int width = image[0].length;

        if (x < 0 || y < 0 || x >= width || y >= height || image[y][x].equals(desiredColor)) {
            return false;
        }

        Color oldColor = image[y][x];

        image[y][x] = desiredColor;

        if ( y > 0 && image[y - 1][x] == oldColor) {
            paintFill(image, x, y - 1, desiredColor);
        }

        if ( (y < image.length - 1) && image[y + 1][x] == oldColor) {
            paintFill(image, x, y + 1, desiredColor);
        }

        if ( x > 0 && image[y][x - 1] == oldColor) {
            paintFill(image, x - 1, y, desiredColor);
        }

        if ( (x < image[0].length - 1) && image[y][x + 1] == oldColor) {
            paintFill(image, x + 1, y, desiredColor);
        }

        return true;
    }
}
