package root;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import root.graphics.SwervePanel;

public class Main {
    public static void main(String[] args) throws Exception {
        Globals.REQUESTED_FORWARD = 0;
        Globals.REQUESTED_STRAFE = 0;
        Globals.REQUESTED_ROTATION = 0;
        Globals.RESET_REQUESTED = false;
        Globals.SHOW_HEADING = true;
        
        JFrame frame = new JFrame("Swerve Visualizer v0.2.0-alpha2");
        frame.setSize(Globals.WIDTH, Globals.HEIGHT);

        SwervePanel panel = new SwervePanel(frame);
        panel.setBackground(Color.WHITE);

        Container c = frame.getContentPane();
        c.add(panel);

        // frame.addKeyListener(panel);

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.basic");
            System.out.println(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){}

        

        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        

        panel.repaint();

        Timer timer = new Timer(30, panel);
        timer.start();
    }
}
