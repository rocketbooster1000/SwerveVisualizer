package main.java.graphics;

import java.awt.Color;
import java.awt.Graphics;

import main.java.model.SwerveModule;
import main.java.util.Animatable;
import main.java.util.Globals;

public class SwerveModuelWrapperAnimatable implements Animatable{
    private SwerveModule module;

    public SwerveModuelWrapperAnimatable(SwerveModule module){
        this.module = module;
    }

    @Override
    public void draw(Graphics g){
        double rot = module.rotate + Math.PI / 2;
        int startX;
        int startY;
        switch (module.location){
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
        int endX = startX - (int)(Globals.DRAW_VECTOR_LENGTH * module.power * Math.cos(rot));
        int endY = startY - (int)(Globals.DRAW_VECTOR_LENGTH * module.power * Math.sin(rot));
        int arrowX = endX - (int)(Globals.DRAW_ARROW_LENGTH * module.power * Math.cos(rot + Math.toRadians(135)));
        int arrowY = endY - (int)(Globals.DRAW_ARROW_LENGTH * module.power * Math.sin(rot + Math.toRadians(135)));

        int arrowX2 = endX - (int)(Globals.DRAW_ARROW_LENGTH * module.power * Math.cos(rot - Math.toRadians(135)));
        int arrowY2 = endY - (int)(Globals.DRAW_ARROW_LENGTH * module.power * Math.sin(rot - Math.toRadians(135)));


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
}