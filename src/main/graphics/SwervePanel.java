package main.graphics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import java.awt.Color;

import main.model.SwerveBase;
import main.util.Animatable;
import main.util.Globals;

public class SwervePanel extends JPanel implements ActionListener, KeyListener{
    Animatable base;
    
    public SwervePanel(){
        super();
        base = new SwerveBase(this);
        
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        base.draw(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        base.update();
        repaint();

        Globals.WIDTH = this.getWidth();
        Globals.HEIGHT = this.getHeight();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            Globals.REQUESTED_FORWARD = 1;
        }
        if (e.getKeyChar() == 'a'){
            Globals.REQUESTED_STRAFE = -1;
        }
        if (e.getKeyChar() == 's'){
            Globals.REQUESTED_FORWARD = -1;
        }
        if (e.getKeyChar() == 'd'){
            Globals.REQUESTED_STRAFE = 1;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w'){
            Globals.REQUESTED_FORWARD = 0;
        }
        if (e.getKeyChar() == 'a'){
            Globals.REQUESTED_STRAFE = 0;
        }
        if (e.getKeyChar() == 's'){
            Globals.REQUESTED_FORWARD = 0;
        }
        if (e.getKeyChar() == 'd'){
            Globals.REQUESTED_STRAFE = 0;
        }
    }
}
