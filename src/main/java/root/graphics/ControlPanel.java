package root.graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import root.Globals;
import root.Globals.KeyBindingActions;
import root.Globals.KeyBindingStrings;
import root.util.ActionPerformable;

public class ControlPanel extends JPanel implements ActionListener {

  private JButton confirmButton;
  private ActionPerformable action;
  private Runnable refr;
  protected JTextField textField;

  private int width, height, offset;

  // Constructor
  public ControlPanel(String labelString, String initialString, Runnable refr, ActionPerformable action, int width, int height, int offset) {
    super(new GridLayout(1, 3));

    // super();
    this.width = width;
    this.height = height;
    this.offset = offset;

    
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

    this.add(new JLabel("  " + labelString + "  "));
    this.add(this.textField);
    this.add(this.confirmButton);

    this.refr = refr;
    this.action = action;

    this.setBounds();
  }
  

  
  // Called when the roll button is clicked
  public void actionPerformed(ActionEvent e) {
    this.action.actionPerformed(e);
    SwerveFrame.getInstance().requestFocus();
  }

  public void refresh(){
    this.refr.run();
    this.setBounds();
  }

  public void setText(String text){
    this.textField.setText(text);
  }

  public String getText(){
    return this.textField.getText();
  }

  private void setBounds(){
    super.setBounds(0, Globals.HEIGHT - this.offset - this.height, this.width, this.height);
  }

  public boolean isInFocus(){
    return this.textField.isFocusOwner();
  }
}
