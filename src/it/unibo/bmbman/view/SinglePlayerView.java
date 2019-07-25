package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
/**
 * Frame for single player game mode.
 *
 */
public class SinglePlayerView extends AbstractFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 6903663897799242487L;
    private Canvas canvas = new Canvas();
/**
 * construct the frame.
 */
    public SinglePlayerView() {
        super();
        super.getContentPane().add(canvas);
        canvas.setBackground(Color.BLACK);
        super.setVisible(true);
    }

}
