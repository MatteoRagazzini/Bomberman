package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
/**
 * Frame for single player game mode.
 *
 */
public class SinglePlayerView {
    /**
     * 
     */
    private static final long serialVersionUID = 6903663897799242487L;
    private Canvas canvas = new Canvas();
    private GUIFactory gui = new MyGUIFactory();
    JFrame frame = gui.createFrame();
/**
 * construct the frame.
 */
    public SinglePlayerView() {
        frame.getContentPane().add(canvas);
        canvas.setBackground(Color.BLACK);
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return this.frame;
    }

}
