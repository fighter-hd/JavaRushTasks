package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();

        int multiplicity = Model.FIELD_CELL_SIZE / 2;
        int count = 1;
        int currentValue = Model.FIELD_CELL_SIZE * multiplicity * count++;

        walls.add(new Wall(currentValue, currentValue));
        currentValue = Model.FIELD_CELL_SIZE * multiplicity * count++;

        boxes.add(new Box(currentValue, currentValue));
        currentValue = Model.FIELD_CELL_SIZE * multiplicity * count++;

        walls.add(new Wall(currentValue, currentValue));
        currentValue = Model.FIELD_CELL_SIZE * multiplicity * count++;

        homes.add(new Home(currentValue, currentValue));
        currentValue = Model.FIELD_CELL_SIZE * multiplicity * count++;

        walls.add(new Wall(currentValue, currentValue));
        currentValue = Model.FIELD_CELL_SIZE * multiplicity * count++;

        return new GameObjects(walls, boxes, homes, new Player(currentValue, currentValue));
    }
}
