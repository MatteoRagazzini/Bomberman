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
    private boolean inExplosion;
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
        this.explosion = new Pair<>(new Rectangle(position.getX()-50, position.getY(), 0, 0),
                                    new Rectangle(position.getX(), position.getY()-50, 0, 0));
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
    public boolean inExplosion() {
        return inExplosion;
    }

    public void setBombExploded() {
        System.out.println("esplosa");
        this.inExplosion = false;
        this.isExploded = true;
    }
    @Override
    protected void reachedBorder() {
    }

    @Override
    public void update() {
        if (this.timer > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - this.timer >= MAX_TIMER) {
                this.timer = 0;
                this.inExplosion = true;
                final Position pos = this.getPosition();
                Rectangle horizontal = new Rectangle(pos.getX()-50, pos.getY(), 50*RANGE, 50);
                Rectangle vertical = new Rectangle(pos.getX(), pos.getY()-50, 50, 50*RANGE);
                this.explosion = new Pair<Rectangle, Rectangle>(horizontal, vertical);
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
    @Override
    public void onCollision(Collision c) {
        // TODO Auto-generated method stub
        
    }
}
