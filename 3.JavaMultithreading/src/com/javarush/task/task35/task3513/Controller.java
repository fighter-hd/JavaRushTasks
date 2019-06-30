package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    public void resetGame() {
        model.maxTile = 0;
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            resetGame();

        if ( ! model.canMove())
            view.isGameLost = true;

        if ( !view.isGameLost && !view.isGameWon) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                model.left();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                model.right();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                model.up();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                model.down();
            }
        }

        if (model.maxTile == WINNING_TILE)
            view.isGameWon = true;

        view.repaint();
    }

    Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    int getScore() {
        return model.score;
    }
}
