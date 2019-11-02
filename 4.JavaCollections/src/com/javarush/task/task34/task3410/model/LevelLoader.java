package com.javarush.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        if (level > 60) {
            level = level % 60;
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(levels.toFile())))) {
            String currentLine = reader.readLine();

            int sizeX = 0;
            int sizeY = 0;

            while (currentLine != null) {
                if (currentLine.matches("Maze: \\d\\d?") && currentLine.contains(String.valueOf(level))) {

                    while (currentLine != null) {
                        if (currentLine.matches("Size X: \\d\\d?")) {
                            sizeX = Integer.parseInt(currentLine.substring(8));
                        }

                        if (currentLine.matches("Size Y: \\d\\d?")) {
                            sizeY = Integer.parseInt(currentLine.substring(8));
                            currentLine = reader.readLine();
                            currentLine = reader.readLine();
                            currentLine = reader.readLine();
                            break;
                        }

                        currentLine = reader.readLine();
                    }

                    break;

                } else {
                    currentLine = reader.readLine();
                }
            }

            Set<Wall> walls = new HashSet<>();
            Set<Box> boxes = new HashSet<>();
            Set<Home> homes = new HashSet<>();
            Player player = null;

            int zeroX = Model.FIELD_CELL_SIZE / 2;
            int zeroY = Model.FIELD_CELL_SIZE / 2;

            int currentY = zeroY;

            for (int row = 0; row < sizeY; row++) {
                currentLine = reader.readLine();

                int currentX = zeroX;

                for (int column = 0; column < sizeX; column++) {
                    char currentChar = currentLine.charAt(column);

                    switch (currentChar) {
                        case 'X':
                            walls.add(new Wall(currentX, currentY));
                            break;
                        case '*':
                            boxes.add(new Box(currentX, currentY));
                            break;
                        case '&':
                            boxes.add(new Box(currentX, currentY));
                        case '.':
                            homes.add(new Home(currentX, currentY));
                            break;
                        case '@':
                            player = new Player(currentX, currentY);
                            break;
                    }

                    currentX += Model.FIELD_CELL_SIZE;
                }

                currentY += Model.FIELD_CELL_SIZE;
            }

            return new GameObjects(walls, boxes, homes, player);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
