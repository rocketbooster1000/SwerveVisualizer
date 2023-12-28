package root.graphics;

import java.awt.event.ActionEvent;

import root.Globals;
import root.model.SwerveBase;

public class HeadingControlPanel extends ControlPanel{
    public HeadingControlPanel(){
        super("Heading", SwerveBaseAnimatable.getFormatHeading(Globals.CURRENT_HEADING));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            Globals.CURRENT_HEADING = Math.toRadians(Double.parseDouble(this.textField.getText()));
        } catch (Exception ex){}
        super.actionPerformed(e);
    }

    @Override
    public void refresh(){
        textField.setText(SwerveBaseAnimatable.getFormatHeading(Globals.CURRENT_HEADING));
    }
}