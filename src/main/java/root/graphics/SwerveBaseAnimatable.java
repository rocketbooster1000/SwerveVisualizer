package root.graphics;

import java.awt.Color;
import java.awt.Graphics;

import root.Globals;
import root.model.SwerveBase;
import root.util.*;
import root.util.Vector.*;


public class SwerveBaseAnimatable extends SwerveBase implements Animatable{
    private static volatile Animatable instance = null;
    private SwerveModuelWrapperAnimatable wrapperFl, wrapperFR, wrapperBL, wrapperBR;

    public SwerveBaseAnimatable(){
        super();
        this.wrapperFl = new SwerveModuelWrapperAnimatable(this.fL);
        this.wrapperFR = new SwerveModuelWrapperAnimatable(this.fR);
        this.wrapperBL = new SwerveModuelWrapperAnimatable(this.bL);
        this.wrapperBR = new SwerveModuelWrapperAnimatable(this.bR);

    }

    @Override
    public void drive(double forward, double strafe, double rot){
        super.drive(forward, strafe, rot, false);
        
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.RED);
        if (Globals.FIELD_ORIENTED){
            Vector lFLoc = new Vector(new VectorRectangular(-Globals.SWERVE_WIDTH / 2, -Globals.SWERVE_HEIGHT / 2));
            Vector rFLoc = new Vector(new VectorRectangular(Globals.SWERVE_WIDTH / 2, -Globals.SWERVE_HEIGHT / 2));
            Vector lBLoc = new Vector(new VectorRectangular(-Globals.SWERVE_WIDTH / 2, Globals.SWERVE_HEIGHT / 2));
            Vector rBLoc = new Vector(new VectorRectangular(Globals.SWERVE_WIDTH / 2, Globals.SWERVE_HEIGHT / 2));
            
            lFLoc = lFLoc.rotate(2 * Math.PI - this.getHeading());
            rFLoc = rFLoc.rotate(2 * Math.PI - this.getHeading());
            lBLoc = lBLoc.rotate(2 * Math.PI - this.getHeading());
            rBLoc = rBLoc.rotate(2 * Math.PI - this.getHeading());
            
            g.setColor(Color.GREEN);
            g.drawLine((int)Math.round(lFLoc.x) + Globals.WIDTH / 2, (int)Math.round(lFLoc.y) + Globals.HEIGHT / 2, (int)Math.round(rFLoc.x + Globals.WIDTH / 2), (int)Math.round(rFLoc.y) + Globals.HEIGHT / 2);

            g.setColor(Color.RED);
            g.drawLine((int)Math.round(rFLoc.x) + Globals.WIDTH / 2, (int)Math.round(rFLoc.y) + Globals.HEIGHT / 2, (int)Math.round(rBLoc.x) + Globals.WIDTH / 2, (int)Math.round(rBLoc.y) + Globals.HEIGHT / 2);
            g.drawLine((int)Math.round(rBLoc.x) + Globals.WIDTH / 2, (int)Math.round(rBLoc.y) + Globals.HEIGHT / 2, (int)Math.round(lBLoc.x) + Globals.WIDTH / 2, (int)Math.round(lBLoc.y) + Globals.HEIGHT / 2);
            g.drawLine((int)Math.round(lBLoc.x) + Globals.WIDTH / 2, (int)Math.round(lBLoc.y) + Globals.HEIGHT / 2, (int)Math.round(lFLoc.x) + Globals.WIDTH / 2, (int)Math.round(lFLoc.y) + Globals.HEIGHT / 2);

            this.wrapperFl.drawDynamic(g, (int)Math.round(lFLoc.x) + Globals.WIDTH / 2, (int)Math.round(lFLoc.y) + Globals.HEIGHT / 2, Globals.CURRENT_HEADING);
            this.wrapperFR.drawDynamic(g, (int)Math.round(rFLoc.x) + Globals.WIDTH / 2, (int)Math.round(rFLoc.y) + Globals.HEIGHT / 2, Globals.CURRENT_HEADING);
            this.wrapperBL.drawDynamic(g, (int)Math.round(lBLoc.x) + Globals.WIDTH / 2, (int)Math.round(lBLoc.y) + Globals.HEIGHT / 2, Globals.CURRENT_HEADING);
            this.wrapperBR.drawDynamic(g, (int)Math.round(rBLoc.x) + Globals.WIDTH / 2, (int)Math.round(rBLoc.y) + Globals.HEIGHT / 2, Globals.CURRENT_HEADING);

        } else {
            g.drawRect(Globals.WIDTH / 2 - Globals.SWERVE_WIDTH / 2, Globals.HEIGHT / 2 - Globals.SWERVE_HEIGHT / 2, Globals.SWERVE_WIDTH, Globals.SWERVE_HEIGHT);
            this.wrapperFl.draw(g);
            this.wrapperFR.draw(g);
            this.wrapperBL.draw(g);
            this.wrapperBR.draw(g);

        }
        
        
    }

    @Override
    public void update(){
        this.setMaxRotation(Globals.MAX_ROTATION_SPEED);
        if (Globals.CHANGE_REQUESTED){
            Globals.CURRENT_HEADING = Globals.BUFFER_HEADING;
            this.setHeading(Globals.CURRENT_HEADING);
            Globals.CHANGE_REQUESTED = false;
            Globals.HEADING_CHANGING = false;
        }
        this.drive(Globals.REQUESTED_FORWARD, Globals.REQUESTED_STRAFE, Globals.REQUESTED_ROTATION, true);
    
        if (Globals.RESET_REQUESTED){
            resetHeading();
            Globals.RESET_REQUESTED = false;
        }

        if (Globals.FIELD_CENTRIC) Globals.CURRENT_HEADING = this.getHeading();
        else Globals.CURRENT_HEADING = 0;
    }

    public static String getFormatHeading(double heading){
        if (Double.compare(heading, 0) == 0){
            return "" + 0.0;
        }
        return String.format("%,.1f", Math.toDegrees(2 * Math.PI - heading));
    }

    public static Animatable getInstance(){
        if (instance == null){
            synchronized (SwerveBaseAnimatable.class){
                if (instance == null){
                    instance = new SwerveBaseAnimatable();
                }
            }
        }
        return instance;
    }
}
