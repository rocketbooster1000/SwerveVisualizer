package root;
import java.awt.Color;
import java.awt.Container;

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

        System.out.println(SwerveFrame.getInstance().getInsets().top);
        // SwerveFrame.getInstance().setLayout(null);

        // ControlPanel pan = new ControlPanel(SwerveFrame.getInstance());
        // pan.setBackground(Color.GREEN);
        // pan.setBounds(Globals.WIDTH - 300, Globals.HEIGHT - 300, 300, 300);

        SwervePanel panel = new SwervePanel();
        panel.setBackground(Color.WHITE);
        // panel.setBackground(Color.WHITE);
        // panel.setBounds(0, 0, Globals.WIDTH, Globals.HEIGHT);
        // SwerveFrame.getInstance().add(pan);



        

        SwerveFrame.getInstance().add(panel);

        System.out.println(SwerveFrame.getInstance().getInsets().top);



        // SwerveFrame.getInstance().addKeyListener(panel);

        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // UIManager.setLookAndFeel("javax.swing.plaf.basic");
        } catch (Exception e){}

        System.out.println(SwerveFrame.getInstance().getInsets().top);


        SwerveFrame.getInstance().setFocusable(true);
        SwerveFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(SwerveFrame.getInstance().getInsets().top);

        SwerveFrame.getInstance().setVisible(true);

        System.out.println(SwerveFrame.getInstance().getInsets().top);

        

        panel.repaint();

        System.out.println(SwerveFrame.getInstance().getInsets().top);
        System.out.println(SwerveFrame.getInstance().getInsets().bottom);

        System.out.println(SwerveFrame.getInstance().getInsets().top - SwerveFrame.getInstance().getInsets().bottom);

        Timer timer = new Timer(30, panel);
        timer.start();
    }
}
