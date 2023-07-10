package org.example.welcomeWindow;

import org.example.gameWindow.GameFrame;

import javax.swing.*;

public class GameFrameWelcome extends JFrame{
    GamePanelWelcome welcomePanel;

    public GameFrameWelcome() {
        welcomePanel = new GamePanelWelcome();
        this.add(welcomePanel);
        this.setTitle("Welcome");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
