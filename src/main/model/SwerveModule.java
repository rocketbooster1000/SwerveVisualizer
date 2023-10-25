package main.model;

import java.awt.Color;
import java.awt.Graphics;

import main.model.SwerveBase.ModuleLocation;
import main.util.Animatable;
import main.util.Globals;
import main.util.Vector;

public class SwerveModule implements Animatable{
    private double power, rotate;
    private ModuleLocation location;

    public SwerveModule(ModuleLocation location){
        this.location = location;
    }

    public void setState(Vector vector){
        this.power = vector.r;
        this.rotate = vector.theta;
    }

    @Override
    public void draw(Graphics g){
        double rot = this.rotate + Math.PI / 2;
        int startX;
        int startY;
        switch (location){
            case FL:
                startX = Globals.WIDTH / 2 - Globals.SWERVE_WIDTH / 2;
                startY = Globals.HEIGHT / 2 - Globals.SWERVE_HEIGHT / 2;
                break;
            case FR:
                startX = Globals.WIDTH / 2 + Globals.SWERVE_WIDTH / 2;
                startY = Globals.HEIGHT / 2 - Globals.SWERVE_HEIGHT / 2;
                break;
            case BL:
                startX = Globals.WIDTH / 2 - Globals.SWERVE_WIDTH / 2;
                startY = Globals.HEIGHT / 2 + Globals.SWERVE_HEIGHT / 2;
                break;
            default:
                startX = Globals.WIDTH / 2 + Globals.SWERVE_WIDTH / 2;
                startY = Globals.HEIGHT / 2 + Globals.SWERVE_HEIGHT / 2;
                break;
        }
        int endX = startX - (int)(30 * power * Math.cos(rot));
        int endY = startY - (int)(30 * power * Math.sin(rot));
        int arrowX = endX - (int)(10 * power * Math.cos(rot + Math.toRadians(135)));
        int arrowY = endY - (int)(10 * power * Math.sin(rot + Math.toRadians(135)));

        int arrowX2 = endX - (int)(10 * power * Math.cos(rot - Math.toRadians(135)));
        int arrowY2 = endY - (int)(10 * power * Math.sin(rot - Math.toRadians(135)));


        // System.out.println((int)(5 * power * Math.sin(rot + Math.toRadians(135))));        

        // System.out.println((int)(5 * power * Math.cos(rot + Math.toRadians(135))));

        
        g.setColor(Color.BLUE);        
        g.drawLine(startX, startY, endX, endY);
        g.drawLine(endX, endY, arrowX, arrowY);
        g.drawLine(endX, endY, arrowX2, arrowY2);

        // System.out.println(arrowX + " " + arrowY);
        // System.out.println(
        //     "point 1: " + startX + " " + startY + 
        //     "point 2: " + endX + " " + endY
        // );
        //System.out.println(Math.toDegrees(rot));
    }

    @Override
    public void update() {
        
    }

    public String toString(){
        return "Power: " + power + " | Angle: " + Math.toDegrees(rotate);
    }


}
