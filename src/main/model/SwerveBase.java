package main.model;

import javax.swing.JPanel;

import main.util.Algorithims;
import main.util.Animatable;
import main.util.Globals;
import main.util.Vector;

import java.awt.Color;
import java.awt.Graphics;

public class SwerveBase implements Animatable{
    private SwerveModule fL, fR, bL, bR;

    private double heading;
    private JPanel panel;

    public enum ModuleLocation{
        FL, FR, BL, BR
    }

    public SwerveBase(JPanel panel){
        fL = new SwerveModule(ModuleLocation.FL);
        fR = new SwerveModule(ModuleLocation.FR);
        bL = new SwerveModule(ModuleLocation.BL);
        bR = new SwerveModule(ModuleLocation.BR);

        heading = 0;
        this.panel = panel;
    }

    public void drive(double forward, double strafe, double rot){
        Vector[] vectors = Algorithims.returnSwerve(new Vector(new Vector.VectorRectangular(forward, strafe)), rot, heading);

        fL.setState(vectors[0]);
        fR.setState(vectors[1]);
        bL.setState(vectors[2]);
        bR.setState(vectors[3]);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(Globals.WIDTH / 2 - Globals.SWERVE_WIDTH / 2, Globals.HEIGHT / 2 - Globals.SWERVE_HEIGHT / 2, Globals.SWERVE_WIDTH, Globals.SWERVE_HEIGHT);
        fL.draw(g);
        fR.draw(g);
        bL.draw(g);
        bR.draw(g);
    }

    @Override
    public void update(){
        this.drive(0.5, 0, 1);
        heading += Math.PI / 180;
    }




}
