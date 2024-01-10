package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Window
{
    JFrame frame;
    int pomodorosToday;
    JButton toggleButton;
     Window() throws IOException {
         this.pomodorosToday = 0;
        this.frame = new JFrame();
        this.frame.setTitle("Pomodoro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.toggleButton = new JButton("start");
        this.toggleButton.setBackground(Color.WHITE);

         this.toggleButton.setBounds(40,40, 100,60);
        this.frame.setSize(400,400);
        this.frame.add(this.toggleButton);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

}
