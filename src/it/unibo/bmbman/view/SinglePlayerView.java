package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;

public class SinglePlayerView extends AbstractFrame {
    Canvas canvas = new Canvas();
    
    public SinglePlayerView() {
        super();
        super.getContentPane().add(canvas);
        canvas.setBackground(Color.BLACK);
        super.setVisible(true);
    }
    
}
