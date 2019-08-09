package it.unibo.bmbman.model;

import java.awt.Rectangle;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 */
public class Bomb extends AbstractEntity {
    private boolean isPlanted;
    private boolean isExploded;
    private long timer = 0;
    private static final int MAX_TIMER = 3;
    private static final long MILLIS = 1000;
    private static final int RANGE = 3;
    private Pair<Rectangle, Rectangle> explosion; 
    /**
     * 
     * @param position 
     */
    public Bomb(final Position position) {
        super(position, EntityType.BOMB, new Dimension(50, 50));
        this.isPlanted = false; 
        this.isExploded = false;
        this.explosion = new Pair<>(new Rectangle(position.getX(), position.getX() + 50, 0, 0),
                                    new Rectangle(position.getY(), position.getY()-50, 0, 0));
    }
    /**
     * 
     * @return if is planted
     */
    public boolean isPlanted() {
        return this.isPlanted;
    }
    /**
     * 
     * @return if is exploded 
     */
    public boolean isExploded() {
        return this.isExploded;
    }
    /**
     * 
     * @return explosion 
     */
    public Pair<Rectangle, Rectangle> getExplosion() {
        return explosion;
    }

    /**
     * 
     * @param isPlanted 
     */
    public void setPlanted(final boolean isPlanted) {
        this.isPlanted = isPlanted;
    }
    /**
     * 
     */
    @Override
    public boolean remove() {
        return this.isExploded;
    }

    @Override
    protected void reachedBorder() {
    }

    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
    }

    @Override
    public void update() {
        if (this.timer > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - this.timer >= MAX_TIMER) {
                this.timer = 0;
                this.isExploded = true;
                final Position pos = this.getPosition();
                Rectangle horizontal = new Rectangle(pos.getX(), pos.getX()+50, 50*RANGE, 50);
                Rectangle vertical = new Rectangle(pos.getY(), pos.getY()-50, 50, 50*RANGE);
                explosion = new Pair<Rectangle, Rectangle>(horizontal, vertical);
                System.out.println("INIZIO ESPLOSIONE");
            }
        }
    }
    /**
     * 
     */
    public void startTimer() {
        this.timer = System.currentTimeMillis() / MILLIS;
    }
}
