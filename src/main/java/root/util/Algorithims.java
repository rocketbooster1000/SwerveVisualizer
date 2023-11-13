package root.util;

public class Algorithims {
    
    //vector calculations for coaxial swerve (r = direction, theta = power)
    public static Vector[] returnSwerve(Vector drive, double rotation, double heading){
        double offsetTheta = Math.PI / 4;
        double rotPower = 0.8;

        Vector correctedDrive = drive.rotate(heading);
        Vector FL = correctedDrive.add(new Vector(new Vector.VectorPolar(rotation * rotPower, offsetTheta)));
        Vector FR = correctedDrive.add(new Vector(new Vector.VectorPolar(rotation * rotPower, Math.PI - offsetTheta)));
        Vector BL = correctedDrive.add(new Vector(new Vector.VectorPolar(rotation * rotPower, -offsetTheta)));
        Vector BR = correctedDrive.add(new Vector(new Vector.VectorPolar(rotation * rotPower, Math.PI + offsetTheta)));

        return neutralize(FL, FR, BL, BR);
    }

    //coaxial swerve
    //rescales four vectors such that max r = 1
    //ensures motor never tries to set more power than possible
    public static Vector[] neutralize(Vector one, Vector two, Vector three, Vector four){
        double max = Math.max(Math.max(one.r, two.r),
                Math.max(three.r, four.r));
        return new Vector[] {new Vector(new Vector.VectorPolar(one.r / max, one.theta)),
                            new Vector(new Vector.VectorPolar(two.r / max, two.theta)),
                            new Vector(new Vector.VectorPolar(three.r / max, three.theta)),
                            new Vector(new Vector.VectorPolar(four.r / max, four.theta))};
    }
}
