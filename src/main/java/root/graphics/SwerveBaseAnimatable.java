package root.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import root.Globals;
import root.model.SwerveBase;
import root.util.Animatable;


public class SwerveBaseAnimatable extends SwerveBase implements Animatable{
    private static volatile Animatable instance = null;
    private SwerveModuelWrapperAnimatable wrapperFl, wrapperFR, wrapperBL, wrapperBR;
    private Font font;

    public SwerveBaseAnimatable(){
        super();
        this.wrapperFl = new SwerveModuelWrapperAnimatable(this.fL);
        this.wrapperFR = new SwerveModuelWrapperAnimatable(this.fR);
        this.wrapperBL = new SwerveModuelWrapperAnimatable(this.bL);
        this.wrapperBR = new SwerveModuelWrapperAnimatable(this.bR);

        font = new Font("Times", Font.BOLD, Globals.WIDTH / 32);
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
        this.setMaxRotation(Globals.MAX_ROTATION_SPEED);
        if (Globals.CHANGE_REQUESTED){
            Globals.CURRENT_HEADING = Globals.BUFFER_HEADING;
            this.setHeading(Globals.CURRENT_HEADING);
            Globals.CHANGE_REQUESTED = false;
            Globals.HEADING_CHANGING = false;
        }
        this.drive(Globals.REQUESTED_FORWARD, Globals.REQUESTED_STRAFE, -Globals.REQUESTED_ROTATION);
    
        if (Globals.RESET_REQUESTED){
            resetHeading();
            Globals.RESET_REQUESTED = false;
        }

        Globals.CURRENT_HEADING = this.getHeading();
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
