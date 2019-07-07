package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame gameJFrame = new JFrame();

        gameJFrame.setTitle("2048");
        gameJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameJFrame.setSize(450,500);
        gameJFrame.setResizable(false);
        gameJFrame.add(controller.getView());
        gameJFrame.setLocationRelativeTo(null);
        gameJFrame.setVisible(true);
    }
}