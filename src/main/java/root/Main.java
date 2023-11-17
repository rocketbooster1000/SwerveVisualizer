package root;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import root.graphics.ControlPanel;
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
        frame.setVisible(true);

        System.out.println(frame.getInsets().top);
        // frame.setLayout(null);

        // ControlPanel pan = new ControlPanel(frame);
        // pan.setBackground(Color.GREEN);
        // pan.setBounds(Globals.WIDTH - 300, Globals.HEIGHT - 300, 300, 300);

        SwervePanel panel = new SwervePanel(frame);
        panel.setBackground(Color.WHITE);
        // panel.setBackground(Color.WHITE);
        // panel.setBounds(0, 0, Globals.WIDTH, Globals.HEIGHT);
        // frame.add(pan);



        

        frame.add(panel);

        System.out.println(frame.getInsets().top);



        // frame.addKeyListener(panel);

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.basic");
        } catch (Exception e){}

        System.out.println(frame.getInsets().top);


        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(frame.getInsets().top);

        frame.setVisible(true);

        System.out.println(frame.getInsets().top);

        

        panel.repaint();

        System.out.println(frame.getInsets().top);
        System.out.println(frame.getInsets().bottom);

        System.out.println(frame.getInsets().top - frame.getInsets().bottom);

        Timer timer = new Timer(30, panel);
        timer.start();
    }
}
