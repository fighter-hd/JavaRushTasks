package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;

    public Field(View view) {
        this.view = view;
    }

    @Override
    public void paint(Graphics g) {
        new Player(50, 80).draw(g);
        new Box(1, 1).draw(g);
        new Box(200, 250).draw(g);
    }
}
