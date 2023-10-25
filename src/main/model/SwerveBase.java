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
        this.drive(Globals.REQUESTED_FORWARD, Globals.REQUESTED_STRAFE, Globals.REQUESTED_ROTATION);
        // System.out.println("forward: " + Globals.REQUESTED_FORWARD);
        // System.out.println("strafe" + Globals.REQUESTED_STRAFE);
        // System.out.println("rot: " + Globals.REQUESTED_ROTATION);
        heading += Globals.MAX_ROTATION_SPEED * Globals.REQUESTED_ROTATION;
        if (Globals.RESET_REQUESTED){
            heading = 0;
            Globals.RESET_REQUESTED = false;
        }
    }

    public String toString(){
        return "fl: " + fL.toString() + "\nfr: " + fR.toString() + "\nbl: " + bL.toString() + "\nbr: " + bR.toString();
    }




}
