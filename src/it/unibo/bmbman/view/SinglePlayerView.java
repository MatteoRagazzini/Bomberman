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
    private final Canvas canvas = new Canvas();
    private final GUIFactory gui = new MyGUIFactory();
    private final JFrame frame = gui.createFrame();
/**
 * construct the frame.
 */
    public SinglePlayerView() {
        frame.getContentPane().add(canvas);
        canvas.setBackground(Color.BLACK);
        frame.setVisible(true);
    }
    /**
     * get the frame.
     * @return the current frame
     */
    public JFrame getFrame() {
        return this.frame;
    }

}
