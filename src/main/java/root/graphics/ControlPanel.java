package root.graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import root.Globals;
import root.Globals.KeyBindingActions;
import root.Globals.KeyBindingStrings;

public class ControlPanel extends JPanel implements ActionListener {

  private JFrame parentFrame;
  private JButton confirmButton, otherButton;
  private JTextField textField;
  private JLabel headingLabel;

  // Constructor
  public ControlPanel(JFrame frame) {
    super(new GridLayout(2, 3));

    // super();

    this.parentFrame = frame;

    
    this.textField = new JTextField(String.format("%,.1f", Math.toDegrees(Globals.MAX_ROTATION_SPEED)), 10);
    this.textField.setEditable(true);
    this.textField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
    this.textField.setBackground(Color.WHITE);
    // this.textField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("W"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("S"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("A"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("D"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("J"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("L"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("B"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    this.textField.getInputMap().put(KeyStroke.getKeyStroke("H"), KeyBindingStrings.REQUEST_EMPTY_ACTION);
    
    this.textField.getActionMap().put(KeyBindingStrings.REQUEST_EMPTY_ACTION, KeyBindingActions.EMPTY_ACTION);
        
    
    
    
    this.confirmButton = new JButton("OK");
    this.confirmButton.addActionListener(this);
    this.confirmButton.setBorderPainted(true);

    // this.otherButton = new JButton("OK");
    // this.otherButton.addActionListener(this);
    
    
    // changeColor("Background", this.confirmButton, Color.GRAY);
    add(new JLabel("  Rotation Speed  "));
    add(this.textField);
    add(this.confirmButton);
    
    add(new JLabel("  Heading  "));
    // add(this.otherButton);
    add(new JLabel());
    add(new JLabel());
    
  }
  
  public ControlPanel(){
    this(null);
  }
  
  // Called when the roll button is clicked
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand());
    try{
      Globals.MAX_ROTATION_SPEED = Math.toRadians(Double.parseDouble(textField.getText()));
    } catch (Exception exception){}
    
    textField.setText(String.format("%.1f", Math.toDegrees(Globals.MAX_ROTATION_SPEED)));
    
    
    
    
    try {
      parentFrame.requestFocus();
    } catch (NullPointerException npe){}
    
    
  }
  
  public static void changeColor(String typeOfColor, Component component, Color color)
  {
    if (typeOfColor.equals("Background"))
    {
        component.setBackground(color);
    }
    else if (typeOfColor.equals("Foreground"))
    {
        component.setForeground(color);
    }

    if (component instanceof Container)
    {
        for (Component child : ((Container) component).getComponents())
        {
            changeColor(typeOfColor, child, color);
        }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Example");
    frame.setLayout(null);
    SwervePanel panel = new SwervePanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(10, 10, Globals.WIDTH, Globals.HEIGHT);
    ControlPanel panel2 = new ControlPanel();
    panel2.setBackground(Color.GREEN);
    panel2.setBounds(Globals.WIDTH - 300, Globals.HEIGHT - 100, 300, 100);
    frame.add(panel2, JLayeredPane.PALETTE_LAYER);
    frame.add(panel, JLayeredPane.DEFAULT_LAYER);
    frame.setSize(Globals.WIDTH + 100, Globals.HEIGHT+ 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    // Timer timer = new Timer(30, panel);
    // timer.start();
  }


}
