package root;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import root.graphics.SwerveFrame;
import root.graphics.SwervePanel;

public class Main {
    public static void main(String[] args) throws Exception {
        Globals.REQUESTED_FORWARD = 0;
        Globals.REQUESTED_STRAFE = 0;
        Globals.REQUESTED_ROTATION = 0;
        Globals.RESET_REQUESTED = false;
        
        SwerveFrame.getInstance();

        SwervePanel panel = new SwervePanel();
        panel.setBackground(Color.WHITE);
        SwerveFrame.getInstance().add(panel);

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){}

        SwerveFrame.getInstance().setFocusable(true);
        SwerveFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwerveFrame.getInstance().setVisible(true);

        panel.repaint();

        Timer timer = new Timer(30, panel);
        timer.start();
    }
}
