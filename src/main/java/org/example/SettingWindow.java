package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WITHD = 230;
    private static final int HEIGHT = 350;

    private JButton btnStart;

    SettingWindow(GameWindow gameWindow){
        btnStart = new JButton("Start new game");
        setLocationRelativeTo(gameWindow);
        setSize(WITHD, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0,3,3,3);
            }
        });

        add(btnStart);
    }

}
