package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        Player player = this.gameObjects.getPlayer();

        if (checkWallCollision(player, direction) || checkBoxCollisionAndMoveIfAvaliable(direction)) {
            return;
        }

        int[] deltaXandY = getDeltaXandY(direction);
        int deltaX = deltaXandY[0];
        int deltaY = deltaXandY[1];

        player.move(deltaX, deltaY);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for(GameObject wall : this.gameObjects.getWalls()) {

            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = gameObjects.getPlayer();
        GameObject objectByDirection = null;

        for (GameObject currentObject : gameObjects.getAll()) {
            if (!(currentObject instanceof Player) && !(currentObject instanceof Home) && player.isCollision(currentObject, direction)) {
                objectByDirection = currentObject;
                break;
            }
        }

        if (objectByDirection == null) {
            return false;
        }

        if (objectByDirection instanceof Box) {
            Box boxOnDirection = (Box) objectByDirection;

            if (checkWallCollision(boxOnDirection, direction)) {
                return true;
            }

            for (Box box : gameObjects.getBoxes()) {
                if (boxOnDirection.isCollision(box, direction)) {
                    return true;
                }
            }

            int[] deltaXandY = getDeltaXandY(direction);
            int deltaX = deltaXandY[0];
            int deltaY = deltaXandY[1];

            boxOnDirection.move(deltaX, deltaY);
        }

        return false;
    }

    private GameObject getGameObjectByDirection(GameObject gameObject, Direction direction) {
        GameObject objectByDirection = null;

        int gameObjectX = gameObject.getX();
        int gameObjectY = gameObject.getY();

        int[] nextXandY = getNextXandYbyDirection(direction, gameObjectX, gameObjectY);
        int nextX = nextXandY[0];
        int nextY = nextXandY[1];

        for (GameObject currentObject : this.gameObjects.getAll()) {
            if (nextX == currentObject.getX() && nextY == currentObject.getY()) {
                objectByDirection = currentObject;
                break;
            }
        }

        return objectByDirection;
    }

    private int[] getNextXandYbyDirection(Direction direction, int x, int y) {
        switch (direction) {
            case LEFT:
                x -= FIELD_CELL_SIZE;
                break;
            case RIGHT:
                x += FIELD_CELL_SIZE;
                break;
            case UP:
                y -= FIELD_CELL_SIZE;
                break;
            case DOWN:
                y += FIELD_CELL_SIZE;
                break;
        }

        return new int[]{x, y};
    }

    private int[] getDeltaXandY(Direction direction) {
        int deltaX = 0;
        int deltaY = 0;

        switch (direction) {
            case LEFT:
                deltaX -= FIELD_CELL_SIZE;
                break;
            case RIGHT:
                deltaX += FIELD_CELL_SIZE;
                break;
            case UP:
                deltaY -= FIELD_CELL_SIZE;
                break;
            case DOWN:
                deltaY += FIELD_CELL_SIZE;
                break;
        }

        return new int[] {deltaX, deltaY};
    }

    public void checkCompletion() {
        List<Box> boxList = new ArrayList<>();
        boxList.addAll(this.gameObjects.getBoxes());

        for (Home home : this.gameObjects.getHomes()) {
            for (int i = 0; i < boxList.size(); i++) {
                Box box = boxList.get(i);

                if (home.getX() == box.getX() && home.getY() == box.getY()) {
                    boxList.remove(i);
                    break;
                }
            }
        }

        if (boxList.size() == 0) {
            this.eventListener.levelCompleted(this.currentLevel);
        }
    }

    public GameObjects getGameObjects() {
        return this.gameObjects;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
