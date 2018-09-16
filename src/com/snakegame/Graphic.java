package com.snakegame;

import javax.swing.*;
import java.awt.*;

public class Graphic extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, 128, 128);
    }
}
