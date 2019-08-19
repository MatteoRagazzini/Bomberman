package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import it.unibo.bmbman.controller.game.KeyInput;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.TerrainFactoryImpl;
import it.unibo.bmbman.model.entities.HeroImpl;
import it.unibo.bmbman.model.leaderboard.PlayerScoreImpl;
import it.unibo.bmbman.model.utilities.EntityType;
import it.unibo.bmbman.view.entities.BombView;
import it.unibo.bmbman.view.entities.EntityView;

/**
 * Frame for single player game mode.
 *
 */
public class SinglePlayerView {
    private static final int SECONDS_IN_MINUTE = 60;
    private final GUIFactory gui = new GUIFactoryImpl();
    private final Canvas canvas = new Canvas(); 
    private final JFrame frame = gui.createFrame();
    private BufferStrategy bs;
    private final JPanel sPanel = new JPanel();
    private final TopBar nPanel;
    private final Timer timer;
    private int seconds;
    private int minutes;
    /**
     * construct the frame.
     * @param ki {@link KeyInput}
     * @param hero 
     * @param ps 
     */
    public SinglePlayerView(final KeyInput ki, final PlayerScoreImpl ps, final HeroImpl hero) {
        nPanel = new TopBar(gui, ps, hero);
        seconds = 0;
        minutes = 0;
        nPanel.getLabel().setText(String.format("%02d:%02d", minutes, seconds));
        this.timer = new Timer(1000, a -> {
            seconds++;
            if (seconds == SECONDS_IN_MINUTE) {
                minutes++;
                seconds = 0;
            }
            nPanel.getLabel().setText(String.format("%02d:%02d", minutes, seconds));
        });
        this.timer.start();
        frame.add(sPanel);
        frame.add(nPanel, BorderLayout.NORTH);
        canvas.setSize(TerrainFactoryImpl.TERRAIN_WIDTH, TerrainFactoryImpl.TERRAIN_HEGHT);
        sPanel.add(canvas, BorderLayout.SOUTH);
        frame.pack();
        canvas.addKeyListener(ki);
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
     * Used to update the frame.
     * @param entitiesView all the entities' view to update 
     * @param bombs all the planted bombs' view to update
     */
    public void render(final Set<EntityView> entitiesView, final Set<BombView> bombs) {
        entitiesView.stream().filter(ev -> ev.getType() == EntityType.TILE).forEach(v -> v.render(getGraphics()));
        entitiesView.stream().filter(ev -> ev.getType() == EntityType.POWER_UP).forEach(v -> v.render(getGraphics()));
        entitiesView.stream().filter(ev -> ev.getType() == EntityType.BLOCK).forEach(v -> v.render(getGraphics()));
        entitiesView.stream().filter(ev -> ev.getType() == EntityType.WALL).forEach(v -> v.render(getGraphics()));
        entitiesView.stream().filter(ev -> ev.getType() == EntityType.HERO || ev.getType() == EntityType.MONSTER).forEach(v -> v.render(getGraphics()));
        bombs.forEach(b -> b.render(getGraphics()));
        this.bs.show();
        this.nPanel.render();
        this.frame.pack();
        this.canvas.requestFocus();
    }
    /**
     * stop time.
     */
    public void stopTimer() {
        this.timer.stop();
    }
    /**
     * start time.
     */
    public void startTime() {
        this.timer.start();
    }
    /**
     * 
     * @return time 
     */
    public String getTime() {
        return String.format("%02d:%02d", minutes, seconds);
    }
}
