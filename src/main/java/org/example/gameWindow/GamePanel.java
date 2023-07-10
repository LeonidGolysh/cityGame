package org.example.gameWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private static final int GAME_WIDTH = 400;
    private static final int GAME_HEIGHT = 500;
    private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    private JButton button;
    private JLabel textInWindow;
    private JLabel timerLabel;
    private JTextField inputField;
    private String nickName;
    private Timer timer;
    private int secondsElapsed;

    GamePanel(String nickName) {
        this.nickName = nickName;
        this.secondsElapsed = 0;
        this.setPreferredSize(SCREEN_SIZE);
        this.setLayout(new BorderLayout());

        createTextInWindow();
        createButton();
        createInputField();

        createTimerLabel();
        startTimer();
    }

    private void createTextInWindow() {
        textInWindow = new JLabel("Ім'я гравця: " + nickName);
        textInWindow.setHorizontalAlignment(JLabel.CENTER);
        this.add(textInWindow, BorderLayout.NORTH);
    }
    private void createButton() {
        button = new JButton("Зробити хід");
        this.add(button, BorderLayout.SOUTH);
        button.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(GamePanel.this).dispose();
        });
    }

    private void createInputField() {
        JPanel container = new JPanel(new BorderLayout());
        inputField = new JTextField();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        int topPadding = 10;
        int leftPadding = 0;
        int bottomPadding = 0;
        int rightPadding = 0;

        Border emptyBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        textInWindow.setBorder(emptyBorder);

//        this.add(inputField, BorderLayout.NORTH);
        container.add(textInWindow);
        container.add(Box.createVerticalStrut(10));
        container.add(inputField);
        this.add(container, BorderLayout.NORTH);
    }

    private void createTimerLabel() {
        timerLabel = new JLabel("Time Elapsed: 0 sec");
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(timerLabel);
    }

    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsElapsed++;
                updateTimerLabel();
            }
        });
        timer.start();
    }

    private void updateTimerLabel() {
        timerLabel.setText("Time Elapsed: " + secondsElapsed + " sec");
    }
}
