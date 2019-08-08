package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 */
public class Bomb extends AbstractEntity {
    private boolean isPlanted;
    private long timer = 0;
    private static final int MAX_TIMER = 3;
    private static final long MILLIS = 1000;
    /**
     * 
     * @param dimension 
     */
    public Bomb(final Dimension dimension) {
        super(null, EntityType.BOMB, dimension);
        this.isPlanted = false; 
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
     * @param isPlanted 
     */
    public void setPlanted(final boolean isPlanted) {
        this.isPlanted = isPlanted;
    }

    @Override
    public boolean remove() {
        return !this.isPlanted;
    }

    @Override
    protected void reachedBorder() {
        
    }

    @Override
    public void onCollision(Entity receiver, Position newPosition) {
        
    }

    @Override
    public void update() {
        if (this.timer > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - this.timer >= MAX_TIMER) {
                this.timer = 0;
                //new Explosion(position, entityType, dimension)
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
