package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private JPanel sPanel = new JPanel();
    private JPanel nPanel = new JPanel();
    private JPanel bar = new TopBar(nPanel);
    /**
     * construct the frame.
     * @param ki {@link KeyInput}
     */
    public SinglePlayerView(final KeyInput ki) {
        frame.add(sPanel);
        frame.add(nPanel, BorderLayout.NORTH);
        canvas.setSize(950, 750);
        sPanel.add(canvas, BorderLayout.SOUTH);
        frame.pack();
        frame.addKeyListener(ki);
        frame.setVisible(true);
        bs = this.canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            bs = canvas.getBufferStrategy();
        }
        System.out.println(this.frame.getHeight() + " " + this.frame.getWidth());

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
