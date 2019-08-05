package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import it.unibo.bmbman.controller.KeyInput;
import it.unibo.bmbman.model.Tile;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.utilities.Sprite;
import it.unibo.bmbman.view.utilities.SpriteSheet;
/**
 * Frame for single player game mode.
 *
 */
public class SinglePlayerView {

    private final GUIFactory gui = new MyGUIFactory();
    private final Canvas canvas = new Canvas(); 
    private final JFrame frame = gui.createFrame();
    private BufferStrategy bs;
    private final Tile tile = new Tile(new Position(0, 0), new Dimension(17, 17));
    private final TileView tv = new TileView(tile.getPosition(), tile.getDimension(), (new Sprite(new SpriteSheet("/Tilegrass.png"), 1, 1, 17)).getImage(), true);
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
