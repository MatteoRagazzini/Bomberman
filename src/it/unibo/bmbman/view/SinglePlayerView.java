package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import it.unibo.bmbman.controller.KeyInput;

/**
 * Frame for single player game mode.
 *
 */
public class SinglePlayerView {

    private final GUIFactory gui = new MyGUIFactory();
    private final Canvas canvas = new Canvas(); 
    private final JFrame frame = gui.createFrame();
    private BufferStrategy bs;
    /**
     * construct the frame.
     * @param ki {@link KeyInput}
     */
    public SinglePlayerView(final KeyInput ki) {
        canvas.setSize(MyGUIFactory.FRAME_WIDTH, MyGUIFactory.FRAME_HEIGHT);
        frame.getContentPane().add(canvas);
        frame.pack();
        frame.addKeyListener(ki);
        frame.setVisible(true);
        bs = this.canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            bs = canvas.getBufferStrategy();
        }

    }
    /**
     * get the frame.
     * @return the current frame
     */
    public JFrame getFrame() {
        return this.frame;
    }
    /**
     * Used to get {@link Graphics} component to update.
     * @return {@link Graphics}
     */
    public Graphics getGraphics() {
        return this.bs.getDrawGraphics();
    }

    /**
     * used to update the frame.
     */
    public void render() {
        this.bs.show();
    }

}
