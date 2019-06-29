package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int maxTile;
    int score;

    public Model() {
        resetGameTiles();
    }

    void resetGameTiles() {
        maxTile = 0;
        score = 0;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();

        for (Tile[] tiles : gameTiles) {
            for (Tile tile : tiles) {
                if (tile.isEmpty()) {
                    emptyTiles.add(tile);
                }
            }
        }

        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0) {
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        List<Tile> emptyTiles = new ArrayList<>();
        List<Tile> nonEmptyTiles = new ArrayList<>();

        boolean isChanged = false;

        for (Tile tile : tiles) {
            if (tile.isEmpty()) {
                emptyTiles.add(tile);
            } else {
                nonEmptyTiles.add(tile);
            }
        }

        Tile[] newTiles = new Tile[tiles.length];

        for (int i = 0; i < nonEmptyTiles.size(); i++) {
            newTiles[i] = nonEmptyTiles.get(i);
        }

        for (int i = 0; i < emptyTiles.size(); i++) {
            newTiles[i + nonEmptyTiles.size()] = emptyTiles.get(i);
        }

        for (int i = 0; i < tiles.length; i++) {
            if (newTiles[i] != tiles[i]) {
                isChanged = true;
                break;
            }
        }

        for (int i = 0; i < newTiles.length; i++) {
            tiles[i] = newTiles[i];
        }

        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value > 0) {
                isChanged = true;

                tiles[i].value *= 2;
                tiles[i + 1].value = 0;

                score += tiles[i].value;

                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }

        return isChanged;
    }

    private void rotateClockwiseBy90() {
        int length = gameTiles.length;
        Tile[][] turnedGameTiles = new Tile[length][length];

        for (int row = 0; row < length; row++) {
            for (int column = 0; column < length; column++) {
                turnedGameTiles[column][length - 1 - row] = gameTiles[row][column];
            }
        }

        gameTiles = turnedGameTiles;
    }

    void left() {
        boolean hasChange = false;
        for (Tile[] tiles : gameTiles) {
            if (mergeTiles(tiles) | compressTiles(tiles))
                hasChange = true;
        }

        if (hasChange)
            addTile();
    }

    void right() {
        rotateClockwiseBy90();
        rotateClockwiseBy90();

        left();

        rotateClockwiseBy90();
        rotateClockwiseBy90();
    }

    void up(){
        rotateClockwiseBy90();
        rotateClockwiseBy90();
        rotateClockwiseBy90();

        left();

        rotateClockwiseBy90();
    }

    void down(){
        rotateClockwiseBy90();

        left();

        rotateClockwiseBy90();
        rotateClockwiseBy90();
        rotateClockwiseBy90();
    }

//    public static void main(String[] args) {
//        Model m = new Model();
//
//        m.gameTiles = new Tile[][]{{new Tile(4), new Tile(4), new Tile(2), new Tile(0)},
//                                   {new Tile(4), new Tile(2), new Tile(0), new Tile(4)},
//                                   {new Tile(4), new Tile(4), new Tile(4), new Tile(0)},
//                                   {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}};
//
////        m.gameTiles = new Tile[][]{{new Tile(0), new Tile(2), new Tile(4), new Tile(8)},
////                                   {new Tile(0), new Tile(2), new Tile(4), new Tile(8)},
////                                   {new Tile(0), new Tile(2), new Tile(4), new Tile(8)},
////                                   {new Tile(0), new Tile(2), new Tile(4), new Tile(8)}};
//
//        for (Tile[] tiles : m.gameTiles) {
//            for (Tile tile : tiles) {
//                System.out.print(tile.value + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("=========================================================================================");
//
//        m.up();
//
//        for (Tile[] tiles : m.gameTiles) {
//            for (Tile tile : tiles) {
//                System.out.print(tile.value + " ");
//            }
//            System.out.println();
//        }
//
////        m.mergeTiles(m.gameTiles[0]);
////        m.mergeTiles(m.gameTiles[1]);
////        m.mergeTiles(m.gameTiles[2]);
////        m.mergeTiles(m.gameTiles[3]);
////
////        System.out.println("After merge");
////        for (Tile[] tiles : m.gameTiles) {
////            for (Tile tile : tiles) {
////                System.out.print(tile.value + " ");
////            }
////            System.out.println();
////        }
////        System.out.println("=========================================================================================");
////
////        m.compressTiles(m.gameTiles[0]);
////        m.compressTiles(m.gameTiles[1]);
////        m.compressTiles(m.gameTiles[2]);
////        m.compressTiles(m.gameTiles[3]);
////
////        System.out.println("After compress");
////        for (Tile[] tiles : m.gameTiles) {
////            for (Tile tile : tiles) {
////                System.out.print(tile.value + " ");
////            }
////            System.out.println();
////        }
////
////        System.out.println("\nScore = " + m.score);
////        System.out.println("Max tile = " + m.maxTile);
//    }
}