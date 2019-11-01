package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;
import java.nio.file.Paths;

public class Model {
    public static int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private  int currentLevel = 1;

    private String levelsFilePath = new File("").getAbsolutePath() + "/4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt";
    private LevelLoader levelLoader = new LevelLoader(Paths.get(levelsFilePath));

    public void restartLevel(int level) {
        this.gameObjects = this.levelLoader.getLevel(level);
    }

    public void restart() {
        this.restartLevel(this.currentLevel);
    }

    public void startNextLevel() {
        this.currentLevel++;
        this.restart();
    }

    public void move(Direction direction) {

    }

    public GameObjects getGameObjects() {
        return this.gameObjects;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
