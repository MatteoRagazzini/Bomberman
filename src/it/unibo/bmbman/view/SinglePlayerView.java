package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.bmbman.controller.KeyInput;
import it.unibo.bmbman.controller.Scoring;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.utilities.PlayerScore;

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
    private TopBar nPanel;
    /**
     * construct the frame.
     * @param ki {@link KeyInput}
     * @param hero 
     * @param ps 
     */
    public SinglePlayerView(final KeyInput ki, final PlayerScore ps, final Hero hero) {
        nPanel = new TopBar(ps, hero);
        frame.add(sPanel);
        frame.add(nPanel, BorderLayout.NORTH);
        canvas.setSize(19*50, 15*50);
        sPanel.add(canvas, BorderLayout.SOUTH);
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
        this.nPanel.render();
        this.frame.pack();
    }

}
