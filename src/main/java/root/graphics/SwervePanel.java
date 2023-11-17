package root.graphics;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import root.Globals;
import root.Globals.KeyBindingActions;
import root.Globals.KeyBindingStrings;
import root.util.Animatable;

public class SwervePanel extends JPanel implements ActionListener{
    private Animatable base;
    private ControlPanel panel;
    private JFrame parentFrame;
    // JTextField wonText;

    // Font displayFont;

    // JFrame parentFrame;
    
    public SwervePanel(JFrame frame){
        super();
        this.setLayout(null);
        this.base = new SwerveBaseAnimatable();

        this.parentFrame = frame;


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

        panel = new ControlPanel(frame);
        panel.setBounds(0, Globals.HEIGHT - Globals.CONTROL_HEIGHT - frame.getInsets().bottom - frame.getInsets().top, Globals.CONTROL_WIDTH, Globals.CONTROL_HEIGHT);
        this.add(panel, JLayeredPane.PALETTE_LAYER);
        System.out.println(frame.getInsets().top);

    }

    public SwervePanel(){
        this(null);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.base.draw(g);

        this.panel.refresh();        


        // displayFont = new Font(Font.MONOSPACED, Font.BOLD, Globals.WIDTH / 32);
        // wonText.setText(" Rotation speed; " + String.format("%,.1f", Math.toDegrees(Globals.MAX_ROTATION_SPEED)));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.base.update();
        repaint();

        Globals.WIDTH = this.getWidth();
        Globals.HEIGHT = this.getHeight();
        try{
            panel.setBounds(0, Globals.HEIGHT - Globals.CONTROL_HEIGHT , Globals.CONTROL_WIDTH, Globals.CONTROL_HEIGHT);
        } catch (NullPointerException exception){}
    }
}
