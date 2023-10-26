package main.graphics;

import java.awt.Color;
import java.awt.Graphics;

import main.model.SwerveBase;
import main.util.Animatable;
import main.util.Globals;


public class SwerveBaseAnimatable extends SwerveBase implements Animatable{
    SwerveModuelWrapperAnimatable wrapperFl, wrapperFR, wrapperBL, wrapperBR;

    public SwerveBaseAnimatable(){
        super();
        this.wrapperFl = new SwerveModuelWrapperAnimatable(this.fL);
        this.wrapperFR = new SwerveModuelWrapperAnimatable(this.fR);
        this.wrapperBL = new SwerveModuelWrapperAnimatable(this.bL);
        this.wrapperBR = new SwerveModuelWrapperAnimatable(this.bR);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(Globals.WIDTH / 2 - Globals.SWERVE_WIDTH / 2, Globals.HEIGHT / 2 - Globals.SWERVE_HEIGHT / 2, Globals.SWERVE_WIDTH, Globals.SWERVE_HEIGHT);
        this.wrapperFl.draw(g);
        this.wrapperFR.draw(g);
        this.wrapperBL.draw(g);
        this.wrapperBR.draw(g);
    }

    @Override
    public void update(){
        this.drive(Globals.REQUESTED_FORWARD, Globals.REQUESTED_STRAFE, Globals.REQUESTED_ROTATION);
        // System.out.println("forward: " + Globals.REQUESTED_FORWARD);
        // System.out.println("strafe" + Globals.REQUESTED_STRAFE);
        // System.out.println("rot: " + Globals.REQUESTED_ROTATION);
        this.heading += Globals.MAX_ROTATION_SPEED * Globals.REQUESTED_ROTATION;
        if (Globals.RESET_REQUESTED){
            this.heading = 0;
            Globals.RESET_REQUESTED = false;
        }
    }
}
