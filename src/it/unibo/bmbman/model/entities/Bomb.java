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
 * 
 */
public class Bomb extends AbstractEntity {
    private BombState state;
    private long timer;
    private static final int MAX_TIMER = 3;
    private static final long MILLIS = 1000;
    private static final int RANGE_DIM = 5;
    private static int range = 3;
    private static int bombsNumber = 1;
    private Pair<Rectangle, Rectangle> explosion; 
    /**
     * 
     * @param position 
     */
    public Bomb(final Position position) {
        super(position, EntityType.BOMB, new Dimension(Terrain.CELL_DIMENSION, Terrain.CELL_DIMENSION));
        this.state = BombState.PLANTED;
        this.timer = 0;
        this.explosion = new Pair<>(new Rectangle(position.getX() - Terrain.CELL_DIMENSION, position.getY(), 0, 0),
                                    new Rectangle(position.getX(), position.getY() - Terrain.CELL_DIMENSION, 0, 0));
    }
    /**
     * 
     * @return explosion 
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
     * 
     * @return bomb's state
     */
    public BombState getState() {
        return this.state;
    }
    /**
     * 
     */
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
     * 
     */
    public void startTimer() {
        this.timer = System.currentTimeMillis() / MILLIS;
    }
    @Override
    public void onCollision(final Collision c) {

    }
    /**
     * 
     */
    public static void resetBonusRange() {
        range = 3;
    }
    /**
     * 
     */
    public static void resetBombNumber() {
        bombsNumber = 1;
    }
    /**
     * 
     */
    public static void incrementRange() {
        range = RANGE_DIM;
    }
    /**
     * 
     */
    public static void incrementBombsNumber() {
        bombsNumber++;
    }
    /**
     * 
     * @return bombsNumber
     */
    public static int getBombsNumber() {
        return bombsNumber;
    }
    /**
     * 
     * @return
     */
    private int getShift() {
        return bombsNumber == 3 ? 1 : 2;
    }
}
