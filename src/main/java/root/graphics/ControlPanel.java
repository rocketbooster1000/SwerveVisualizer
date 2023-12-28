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
import root.model.SwerveBase;

public class ControlPanel extends JPanel implements ActionListener {

  private JFrame parentFrame;
  private JButton confirmButton;
  protected JTextField textField;

  // Constructor
  public ControlPanel(String labelString, String initialString) {
    super(new GridLayout(1, 3));

    // super();


    
    this.textField = new JTextField(initialString);
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
    this.add(new JLabel("  " + labelString + "  "));
    this.add(this.textField);
    this.add(this.confirmButton);

    this.setVisible(true);
  }
  

  
  // Called when the roll button is clicked
  public void actionPerformed(ActionEvent e) {

    SwerveFrame.getInstance().requestFocus();
  }

  public void refresh(){

  }
}
