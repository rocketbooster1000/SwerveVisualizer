package root.graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
  private JButton confirmButton;
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
    
    System.out.println(UIManager.getColor(this.textField));
    
    
    
    
    this.confirmButton = new JButton("OK");
    this.confirmButton.addActionListener(this);
    this.confirmButton.setBorderPainted(true);
    
    // changeColor("Background", this.confirmButton, Color.GRAY);
    add(new JLabel("  Rotation Speed  "));
    add(this.textField);
    add(this.confirmButton);
    
    add(new JLabel("  Heading  "));
    // add(new JLabel());
    // add(new JLabel());
    
  }
  
  public ControlPanel(){
    this(null);
  }
  
  // Called when the roll button is clicked
  public void actionPerformed(ActionEvent e) {
    try{
      Globals.MAX_ROTATION_SPEED = Math.toRadians(Double.parseDouble(textField.getText()));
      System.out.println(Globals.MAX_ROTATION_SPEED);
    } catch (Exception exception){
      System.out.println("exception");
    }
    
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
}
