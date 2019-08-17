package it.unibo.bmbman.model.entities;

import java.awt.Rectangle;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.collision.Collision;
import it.unibo.bmbman.model.utilities.BombState;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.EntityType;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
/**
 * It models a bomb.
 */
public class BombImpl extends AbstractEntity implements Bomb {
    private BombState state;
    private long timer;
    private static final int MAX_TIMER = 3;
    private static final long MILLIS = 1000;
    private final int range;
    private Pair<Rectangle, Rectangle> explosion; 
    /**
     * Create a bomb. 
     * @param position 
     * @param range 
     */
    public BombImpl(final Position position, final int range) {
        super(position, EntityType.BOMB, new Dimension(Terrain.CELL_DIMENSION, Terrain.CELL_DIMENSION));
        this.state = BombState.PLANTED;
        this.timer = 0;
        this.range = range;
        this.explosion = new Pair<>(new Rectangle(position.getX() - Terrain.CELL_DIMENSION, position.getY(), 0, 0),
                                    new Rectangle(position.getX(), position.getY() - Terrain.CELL_DIMENSION, 0, 0));
    }
    /**
     * {@inheritDoc}
     */
    public Pair<Rectangle, Rectangle> getExplosion() {
        return explosion;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove() {
        return getState() == BombState.EXPLODED;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public BombState getState() {
        return this.state;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBombExploded() {
        this.state = BombState.EXPLODED;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        if (this.timer > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - this.timer >= MAX_TIMER) {
                this.timer = 0;
                this.state = BombState.IN_EXPLOSION;
                final Position pos = this.getPosition();
                final Rectangle horizontal = new Rectangle(pos.getX() - getShift() * Terrain.CELL_DIMENSION, pos.getY(), 
                                                                Terrain.CELL_DIMENSION * range, Terrain.CELL_DIMENSION);
                final Rectangle vertical = new Rectangle(pos.getX(), pos.getY() - getShift() * Terrain.CELL_DIMENSION, 
                                                                Terrain.CELL_DIMENSION, Terrain.CELL_DIMENSION * range);
                this.explosion = new Pair<Rectangle, Rectangle>(horizontal, vertical);
            }
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void startTimer() {
        this.timer = System.currentTimeMillis() / MILLIS;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Collision c) {
    }
    /**
     * Get how many cells have to be considerated around the center of explosion. 
     * @return number of cells
     */
    private int getShift() {
        return range == 3 ? 1 : 2;
    }
}
