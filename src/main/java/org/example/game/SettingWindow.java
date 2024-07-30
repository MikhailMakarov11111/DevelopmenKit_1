package org.example.game;

import org.example.game.GameWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WITHT = 230;
    private static final int HEIGHT = 350;
    private static final String SELECT_FIELD_SIZES = "Выбранный размер поля: ";
    private static final String INSTALLED_LENGTH = "Устанволенная длина: ";

    private JButton btnStart;
    JSlider sizeW = new JSlider(3, 10);
    JSlider sizeF = new JSlider(3,10);
    JRadioButton btn1 = new JRadioButton("Человек против компьютера");
    JRadioButton btn2 = new JRadioButton("Человек против человека");
    GameWindow gameWindow;


    SettingWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        btnStart = new JButton("Start new game");
        setLocationRelativeTo(gameWindow);
        setSize(WITHT, HEIGHT);

        // добавляем кнопку начала игры
        add(btnStart, BorderLayout.SOUTH);

        // создаем блок расширенных настроек
        JPanel settings = new JPanel(new GridLayout(3, 11));

        // создаем блок выбора режима игры
        JPanel typeGame = new JPanel(new GridLayout(3, 1));
        typeGame.add(new JLabel("Режим игры"));
        ButtonGroup group1 = new ButtonGroup();
        btn1.setSelected(true);
        group1.add(btn1);
        group1.add(btn2);
        typeGame.add(btn1);
        typeGame.add(btn2);


        // Выбор длины повторений для победы
        JPanel sizeWin = new JPanel(new GridLayout(3, 1));
        sizeWin.add(new JLabel("Выберите длинну для победы"));
        JLabel labelInstalledLength = new JLabel(INSTALLED_LENGTH);
        sizeWin.add(labelInstalledLength);
        sizeW.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int length = sizeW.getValue();
                labelInstalledLength.setText(INSTALLED_LENGTH + length);
            }
        });

        sizeWin.add(sizeW);

        // Выбор размеров поля
        JPanel sizeField = new JPanel(new GridLayout(3, 1));
        sizeField.add(new JLabel(SELECT_FIELD_SIZES));
        JLabel labelCurrentSize = new JLabel("Выбранный размер поля ");
        sizeField.add(labelCurrentSize);

        sizeF.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int size = sizeF.getValue();
                labelCurrentSize.setText(SELECT_FIELD_SIZES + size);
                sizeW.setMaximum(size);
            }
        });

        sizeField.add(sizeF);

        //Заполнение окна настроек
        settings.add(typeGame);
        settings.add(sizeWin);
        settings.add(sizeField);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        //Добавляем панель настроек на основное окно
        add(settings);

    }

    private void startNewGame() {
        int mode = 0;
        if (btn1.isSelected()){
            mode = 1;
        } else if (btn2.isSelected()) {
            mode = 2;
        }
        int sizeField = sizeF.getValue();
        int sizeWin = sizeW.getValue();
        gameWindow.startNewGame(mode, sizeField, sizeField, sizeWin);
        setVisible(false);
    }
}
