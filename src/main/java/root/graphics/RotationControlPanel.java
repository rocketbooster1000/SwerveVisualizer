package root.graphics;

import java.awt.event.*;

import root.Globals;

public class RotationControlPanel extends ControlPanel{
    public RotationControlPanel(){
        super("Rotation", String.format("%,.1f", Math.toDegrees(Globals.MAX_ROTATION_SPEED)));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            Globals.MAX_ROTATION_SPEED = Math.toRadians(Double.parseDouble(textField.getText()));
          } catch (Exception exception){}
          
        textField.setText(String.format("%.1f", Math.toDegrees(Globals.MAX_ROTATION_SPEED)));

        super.actionPerformed(e);
    }
}
