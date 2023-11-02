package main.java.model;

import main.java.util.Algorithims;
import main.java.util.Vector;

public class SwerveBase{
    protected SwerveModule fL, fR, bL, bR;

    protected double heading;

    public enum ModuleLocation{
        FL, FR, BL, BR
    }

    public SwerveBase(){
        fL = new SwerveModule(ModuleLocation.FL);
        fR = new SwerveModule(ModuleLocation.FR);
        bL = new SwerveModule(ModuleLocation.BL);
        bR = new SwerveModule(ModuleLocation.BR);

        heading = 0;
    }

    public void drive(double forward, double strafe, double rot){
        Vector[] vectors = Algorithims.returnSwerve(new Vector(new Vector.VectorRectangular(forward, strafe)), rot, heading);

        fL.setState(vectors[0]);
        fR.setState(vectors[1]);
        bL.setState(vectors[2]);
        bR.setState(vectors[3]);
    }

    public String toString(){
        return "fl: " + fL.toString() + "\nfr: " + fR.toString() + "\nbl: " + bL.toString() + "\nbr: " + bR.toString();
    }
}
