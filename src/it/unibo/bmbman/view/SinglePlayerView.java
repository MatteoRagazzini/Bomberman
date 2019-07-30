package it.unibo.bmbman.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import it.unibo.bmbman.controller.GameController;
import it.unibo.bmbman.controller.GameControllerImpl;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Wall;
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
    private final GameController game = new GameControllerImpl();
    private final Wall w = new Wall(new java.awt.geom.Point2D.Double(150, 150),true, EntityType.WALL ,new Rectangle(50, 50));
    private final Monster m = new Monster(new java.awt.geom.Point2D.Double(150, 300), 1, true, EntityType.MONSTER, new Rectangle(50, 50));
/**
 * construct the frame.
 */
    public SinglePlayerView() {
        frame.getContentPane().add(canvas);
        canvas.setBackground(Color.BLACK);
        frame.setVisible(true);
        game.addEntity(w);
        game.addEntity(m);
    }
    /**
     * get the frame.
     * @return the current frame
     */
    public JFrame getFrame() {
        return this.frame;
    }
    
    public void render() {
        game.collisionDetect();
        m.update();
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }
        Graphics bg = bs.getDrawGraphics();
        bg.setColor(Color.black);
        bg.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.RED);
        g.fillRect((int)w.getPosition().getX(),(int)w.getPosition().getY(), (int)w.getDimension().getWidth(), (int)w.getDimension().getHeight());
        g.dispose();
        Graphics gm = bs.getDrawGraphics();
        gm.setColor(Color.GREEN);
        gm.fillRect((int)m.getPosition().getX(),(int)m.getPosition().getY(), (int)m.getDimension().getWidth(), (int)m.getDimension().getHeight());
        bs.show();
    }

}
