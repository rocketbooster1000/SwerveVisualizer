package main.java.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import main.java.Globals;
import main.java.Globals.KeyBindingActions;
import main.java.Globals.KeyBindingStrings;
import main.java.util.Animatable;

public class SwervePanel extends JPanel implements ActionListener{
    private Animatable base;
    // JTextField wonText;

    // Font displayFont;

    // JFrame parentFrame;
    
    public SwervePanel(JFrame frame){
        super();
        this.base = new SwerveBaseAnimatable();


        // this.parentFrame = frame;

        // displayFont = new Font("Monospaced", Font.BOLD, 16);

        // wonText = new JTextField("  0", 20);
        // wonText.setFont(displayFont);
        // // wonText.setEditable(false);
        // wonText.setBackground(Color.WHITE);
        // add(wonText);

        // JButton button = new JButton("OK");

        // add(button);

        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("pressed W"), KeyBindingStrings.REQUEST_FORWARD);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("pressed S"), KeyBindingStrings.REQUEST_BACK);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("pressed A"), KeyBindingStrings.REQUEST_STRAFE_LEFT);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("pressed D"), KeyBindingStrings.REQUEST_STRAFE_RIGHT);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("pressed J"), KeyBindingStrings.REQUEST_ROTATION_LEFT);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("pressed L"), KeyBindingStrings.REQUEST_ROTATION_RIGHT);
        
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("released W"), KeyBindingStrings.REQUEST_RELEASE_FORWARD);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("released S"), KeyBindingStrings.REQUEST_RELEASE_FORWARD);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("released A"), KeyBindingStrings.REQUEST_RELEASE_STRAFE);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("released D"), KeyBindingStrings.REQUEST_RELEASE_STRAFE);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("released J"), KeyBindingStrings.REQUEST_RELEASE_ROTATION);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("released L"), KeyBindingStrings.REQUEST_RELEASE_ROTATION);
        
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("B"), KeyBindingStrings.REQUEST_RESET_HEADING);
        this.getInputMap(Globals.IFW).put(KeyStroke.getKeyStroke("H"), KeyBindingStrings.REQUEST_TOGGLE_HEADING);

        this.getActionMap().put(KeyBindingStrings.REQUEST_FORWARD, KeyBindingActions.FORWARD_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_BACK, KeyBindingActions.BACKWARDS_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_STRAFE_LEFT, KeyBindingActions.STRAFE_LEFT_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_STRAFE_RIGHT, KeyBindingActions.STRAFE_RIGHT_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_ROTATION_LEFT, KeyBindingActions.TURN_LEFT_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_ROTATION_RIGHT, KeyBindingActions.TURN_RIGHT_ACTION);

        this.getActionMap().put(KeyBindingStrings.REQUEST_RELEASE_FORWARD, KeyBindingActions.RELEASE_FORWARD_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_RELEASE_STRAFE, KeyBindingActions.RELEASE_STRAFE_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_RELEASE_ROTATION, KeyBindingActions.RELEASE_ROTATION_ACTION);
        
        this.getActionMap().put(KeyBindingStrings.REQUEST_RESET_HEADING, KeyBindingActions.RESET_HEADING_ACTION);
        this.getActionMap().put(KeyBindingStrings.REQUEST_TOGGLE_HEADING, KeyBindingActions.TOGGLE_HEADING_ACTION);

        add(new ControlPanel(frame));




    }

    public SwervePanel(){
        this(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.base.draw(g);



        // displayFont = new Font(Font.MONOSPACED, Font.BOLD, Globals.WIDTH / 32);
        // wonText.setText(" Rotation speed; " + String.format("%,.1f", Math.toDegrees(Globals.MAX_ROTATION_SPEED)));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.base.update();
        repaint();

        Globals.WIDTH = this.getWidth();
        Globals.HEIGHT = this.getHeight();

        // parentFrame.requestFocus();
    }

    // @Override public void keyTyped(KeyEvent e) {}
    
    // @Override
    // public void keyPressed(KeyEvent e) {
    //     switch (e.getKeyChar()){
    //         case 'w': Globals.REQUESTED_FORWARD = 1; break;
    //         case 'a': Globals.REQUESTED_STRAFE = -1; break;
    //         case 's': Globals.REQUESTED_FORWARD = -1; break;
    //         case 'd': Globals.REQUESTED_STRAFE = 1; break;
    //         case 'j': Globals.REQUESTED_ROTATION = -1; break;
    //         case 'l': Globals.REQUESTED_ROTATION = 1; break;
    //         case 'b': Globals.RESET_REQUESTED = true; break;
    //     }
    // }
    
    // @Override
    // public void keyReleased(KeyEvent e) {
    //     switch (e.getKeyChar()){
    //         case 'w': Globals.REQUESTED_FORWARD =0; break;
    //         case 'a': Globals.REQUESTED_STRAFE = 0; break;
    //         case 's': Globals.REQUESTED_FORWARD = 0; break;
    //         case 'd': Globals.REQUESTED_STRAFE = 0; break;
    //         case 'j': Globals.REQUESTED_ROTATION = 0; break;
    //         case 'l': Globals.REQUESTED_ROTATION = 0; break;
    //         case 'h': Globals.SHOW_HEADING = !Globals.SHOW_HEADING; break;
    //     }
    // }
}
