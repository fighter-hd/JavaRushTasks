package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int maxTile;
    int score;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

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

    public boolean canMove() {
        if ( ! getEmptyTiles().isEmpty() )
            return true;

        for (int row = 0; row < gameTiles.length - 1; row++) {
            for (int column = 0; column < gameTiles.length - 1; column++) {
                int currentTileValue = gameTiles[row][column].value;

                if (currentTileValue == 0
                    || currentTileValue == gameTiles[row][column + 1].value
                    || currentTileValue == gameTiles[row + 1][column].value) {
                           return true;
                }
            }
        }

        for (int column = 0; column < gameTiles.length - 1; column++) {
            int currentTileValue = gameTiles[gameTiles.length - 1][column].value;

            if (currentTileValue == 0 || currentTileValue == gameTiles[gameTiles.length - 1][column + 1].value)
                return true;
        }

        for (int row = 0; row < gameTiles.length - 1; row++) {
            int currentTileValue = gameTiles[row][gameTiles.length - 1].value;

            if (currentTileValue == 0 || currentTileValue == gameTiles[row + 1][gameTiles.length - 1].value)
                return true;
        }

        return false;
    }

    private void saveState(Tile[][] allTiles) {
        int size = allTiles.length;

        Tile[][] copy = new Tile[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                Tile tileCopy = new Tile(allTiles[row][column].value);
                copy[row][column] = tileCopy;
            }
        }

        previousStates.push(copy);
        previousScores.push(score);

        isSaveNeeded = false;
    }

    void rollback() {
        if ( ! previousStates.empty() && ! previousScores.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
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
        if (isSaveNeeded)
            saveState(gameTiles);

        boolean hasChange = false;
        for (Tile[] tiles : gameTiles) {
            if (mergeTiles(tiles) | compressTiles(tiles))
                hasChange = true;
        }

        if (hasChange)
            addTile();

        isSaveNeeded = true;
    }

    void right() {
        saveState(gameTiles);

        rotateClockwiseBy90();
        rotateClockwiseBy90();

        left();

        rotateClockwiseBy90();
        rotateClockwiseBy90();
    }

    void up(){
        saveState(gameTiles);

        rotateClockwiseBy90();
        rotateClockwiseBy90();
        rotateClockwiseBy90();

        left();

        rotateClockwiseBy90();
    }

    void down(){
        saveState(gameTiles);

        rotateClockwiseBy90();

        left();

        rotateClockwiseBy90();
        rotateClockwiseBy90();
        rotateClockwiseBy90();
    }

    void randomMove() {
        int randomInt = ((int) (Math.random() * 100)) % 4;

        switch (randomInt) {
            case 0:
                left();
                break;

            case 1:
                right();
                break;

            case 2:
                up();
                break;

            case 3:
                down();
                break;
        }
    }

    boolean hasBoardChanged() {
        Tile[][] prevGameTiles = previousStates.peek();
        Tile[][] currentGameTiles = gameTiles;

        for (int row = 0; row < gameTiles.length; row++) {
            for (int column = 0; column < gameTiles.length; column++) {
                if (prevGameTiles[row][column].value != currentGameTiles[row][column].value)
                    return true;
            }
        }

        return false;
    }

    MoveEfficiency getMoveEfficiency(Move move) {
        move.move();

        if (!hasBoardChanged())
            return new MoveEfficiency(-1, 0, move);

        MoveEfficiency result =  new MoveEfficiency(getEmptyTiles().size(), score, move);
        rollback();

        return result;
    }

    void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());

        priorityQueue.add(getMoveEfficiency(this::left));
        priorityQueue.add(getMoveEfficiency(() -> right()));
        priorityQueue.add(getMoveEfficiency(this::up));
        priorityQueue.add(getMoveEfficiency(() -> down()));

        priorityQueue.peek().getMove().move();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

//    public static void main(String[] args) {
//        Model m = new Model();
//
////        m.gameTiles = new Tile[][]{{new Tile(4), new Tile(4), new Tile(2), new Tile(0)},
////                                   {new Tile(4), new Tile(2), new Tile(0), new Tile(4)},
////                                   {new Tile(4), new Tile(4), new Tile(4), new Tile(0)},
////                                   {new Tile(4), new Tile(4), new Tile(4), new Tile(4)}};
//
//        m.gameTiles = new Tile[][]{{new Tile(0), new Tile(2), new Tile(4), new Tile(8)},
//                                   {new Tile(0), new Tile(2), new Tile(4), new Tile(8)},
//                                   {new Tile(0), new Tile(2), new Tile(4), new Tile(8)},
//                                   {new Tile(0), new Tile(2), new Tile(4), new Tile(8)}};
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
//        boolean canMove = m.canMove();
//
//        for (Tile[] tiles : m.gameTiles) {
//            for (Tile tile : tiles) {
//                System.out.print(tile.value + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("\nCan move - " + canMove);
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