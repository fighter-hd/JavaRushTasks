package com.javarush.task.task35.task3513;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

    public Model() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
    }
}
