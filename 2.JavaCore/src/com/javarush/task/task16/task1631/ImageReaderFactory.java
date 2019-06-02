package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes) throws IllegalArgumentException {
        ImageReader reader;

        try {
            switch (imageTypes) {
                case JPG:
                    reader = new JpgReader();
                    break;
                case BMP:
                    reader = new BmpReader();
                    break;
                case PNG:
                    reader = new PngReader();
                    break;
                default :
                    throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return reader;
    }
}
