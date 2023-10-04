package main.graphics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import java.awt.Color;

import main.model.SwerveBase;
import main.util.Animatable;
import main.util.Globals;

public class SwervePanel extends JPanel implements ActionListener{
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
}
