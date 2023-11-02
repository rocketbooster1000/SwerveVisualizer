package main.java.util;

public class Vector {
    public double r, theta;
    public double x, y;

    public Vector(VectorRectangular rectangular){
        this.x = rectangular.x;
        this.y = rectangular.y;
        this.r = Math.hypot(rectangular.x, rectangular.y);
        this.theta = Math.atan2(rectangular.y, rectangular.x);
    }

    public Vector(VectorPolar polar){
        this.r = polar.r;
        this.theta = polar.theta;
        this.x = polar.r * Math.cos(polar.theta);
        this.y = polar.r * Math.sin(polar.theta);
    }

    public double getR(){
        return r;
    }

    public double getTheta(){
        return (theta);
    }

    public Vector rotate(double deg){
        return new Vector(new VectorPolar(this.r, (this.theta) + deg));
    }

    public Vector add(Vector other){
        return new Vector(new VectorRectangular(this.x + other.x, this.y + other.y));
    }


    public static class VectorRectangular{
        public double x, y;

        public VectorRectangular(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static class VectorPolar{
        public double r, theta;

        public VectorPolar(double r, double theta){
            this.r = r;
            this.theta = theta;
        }
    }

    public String toString(){
        return "" + this.r + " r | " + this.theta + " theta";
    }
}
