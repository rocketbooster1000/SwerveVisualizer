package main.model;

import java.awt.Color;
import java.awt.Graphics;

import main.model.SwerveBase.ModuleLocation;
import main.util.Animatable;
import main.util.Globals;
import main.util.Vector;

public class SwerveModule implements Animatable{
    private double power, rot;
    private ModuleLocation location;

    public SwerveModule(ModuleLocation location){
        this.location = location;
    }

    public void setState(Vector vector){
        this.power = vector.r;
        this.rot = vector.theta;
    }

    @Override
    public void draw(Graphics g){
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
        g.setColor(Color.BLUE);
        g.drawLine(startX, startY, (startX) + (int)(30 * power * Math.cos(rot)), (startY) - (int)(30 * power * Math.sin(rot)));
    }

    @Override
    public void update() {
        
    }


}
