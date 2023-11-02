package main.java.graphics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import main.java.Globals;
import main.java.util.Animatable;

public class SwervePanel extends JPanel implements ActionListener, KeyListener{
    Animatable base;
    
    public SwervePanel(){
        super();
        this.base = new SwerveBaseAnimatable();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.base.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.base.update();
        repaint();

        Globals.WIDTH = this.getWidth();
        Globals.HEIGHT = this.getHeight();
    }

    @Override public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w': Globals.REQUESTED_FORWARD = 1; break;
            case 'a': Globals.REQUESTED_STRAFE = -1; break;
            case 's': Globals.REQUESTED_FORWARD = -1; break;
            case 'd': Globals.REQUESTED_STRAFE = 1; break;
            case 'j': Globals.REQUESTED_ROTATION = -1; break;
            case 'l': Globals.REQUESTED_ROTATION = 1; break;
            case 'b': Globals.RESET_REQUESTED = true; break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'w': Globals.REQUESTED_FORWARD =0; break;
            case 'a': Globals.REQUESTED_STRAFE = 0; break;
            case 's': Globals.REQUESTED_FORWARD = 0; break;
            case 'd': Globals.REQUESTED_STRAFE = 0; break;
            case 'j': Globals.REQUESTED_ROTATION = 0; break;
            case 'l': Globals.REQUESTED_ROTATION = 0; break;
            case 'h': Globals.SHOW_HEADING = !Globals.SHOW_HEADING; break;
        }
    }
}
