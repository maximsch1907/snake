package com.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphic extends JPanel {
    private static final int GRID_SIZE = 20;

    private GameField game;
    private Timer timerDrawGame;
    private Image background, body,
            head, emptyField, finishGame;
    private JLabel scoreLabel;
    private JButton restartGameButton, closeGameButton;

    Graphic() {
        game = new GameField();
        game.startGame();

        timerDrawGame = new Timer(17,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        repaint();
                    }
                });
        timerDrawGame.start();
        setLayout(null);

        scoreLabel = new JLabel("Score: ");
        scoreLabel.setForeground(Color.BLACK);
        scoreLabel.setFont(new Font("serif", 0, 32));
        scoreLabel.setBounds(630, 200, 150, 50);
        add(scoreLabel);

        restartGameButton = new JButton("Restart game");
        restartGameButton.setForeground(Color.PINK);
        restartGameButton.setFont(new Font("serif",
                2, 24));
        restartGameButton.setBounds(630, 30, 150, 50);
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });
        add(restartGameButton);

        closeGameButton = new JButton("Exit");
        closeGameButton.setForeground(Color.RED);
        closeGameButton.setFont(new Font("serif", 0, 20));
        closeGameButton.setBounds(630, 100, 150,
                50);
        closeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(this.closeGameButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO: - draw snake

        g.setColor(Color.BLUE);
        for (int i = 0; i <= this.game.field.length; i++) {
            g.drawLine(10 + i * GRID_SIZE,
                    10,
                    10 + i * GRID_SIZE,
                    610);
            g.drawLine(10,
                    10 + i * GRID_SIZE,
                    610,
                    10 + i * GRID_SIZE);
        }
    }
}
