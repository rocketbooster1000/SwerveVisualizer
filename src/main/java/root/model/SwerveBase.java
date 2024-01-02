package root.model;

import root.util.Algorithims;
import root.util.Vector;

public class SwerveBase{
    protected SwerveModule fL, fR, bL, bR;

    private double heading;
    private double maxRotation;

    public enum ModuleLocation{
        FL, FR, BL, BR
    }

    public SwerveBase(double maxRot){
        fL = new SwerveModule(ModuleLocation.FL);
        fR = new SwerveModule(ModuleLocation.FR);
        bL = new SwerveModule(ModuleLocation.BL);
        bR = new SwerveModule(ModuleLocation.BR);

        this.maxRotation = maxRot;

        this.heading = 0;
    }

    public SwerveBase(){
        this(Math.toRadians(1));
    }

    public void drive(double forward, double strafe, double rot, boolean inverted){
        Vector[] vectors = Algorithims.returnSwerve(new Vector(new Vector.VectorRectangular(forward, strafe)), rot, heading);

        fL.setState(vectors[0]);
        fR.setState(vectors[1]);
        bL.setState(vectors[2]);
        bR.setState(vectors[3]);

        if (inverted) this.heading -= maxRotation * rot;
        else this.heading += maxRotation * rot;

        this.heading = Math.toRadians((Math.toDegrees(heading) % 360 + 360) % 360);
    }

    public void drive(double forward, double strafe, double rot){
        this.drive(forward, strafe, rot, false);
    }



    public void setMaxRotation(double newRot){
        this.maxRotation = newRot;
    }

    public void setHeading(double newHeading){
        this.heading = newHeading;
    }

    public void resetHeading(){
        this.heading = 0;
    }

    public double getMaxRotation(){
        return this.maxRotation;
    }

    public double getHeading(){
        return this.heading;
    }

    public double getHeadingDegrees(){
        return Math.toDegrees(this.heading);
    }

    public String getFormatHeading(){
        if (Double.compare(heading, 0) == 0){
            return "Heading: " + 0.0;
        }
        return "Heading: " + String.format("%,.1f", Math.toDegrees(2 * Math.PI - heading));
    }

    public String toString(){
        return "fl: " + fL.toString() + "\nfr: " + fR.toString() + "\nbl: " + bL.toString() + "\nbr: " + bR.toString();
    }
}
