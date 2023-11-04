package main.java.graphics;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel
    implements ActionListener
{

  // Constructor
  public ControlPanel()
  {
    JButton rollButton = new JButton("Roll");
    rollButton.addActionListener(this);
    add(rollButton);
  }

  // Called when the roll button is clicked
  public void actionPerformed(ActionEvent e)
  {

  }
}
