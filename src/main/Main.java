package main;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.Timer;

import main.graphics.SwervePanel;
import main.util.Globals;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Test");
        frame.setSize(Globals.WIDTH, Globals.HEIGHT);

        SwervePanel panel = new SwervePanel();
        panel.setBackground(Color.WHITE);

        Container c = frame.getContentPane();
        c.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.repaint();

        Timer timer = new Timer(30, panel);
        timer.start();
    }
}
