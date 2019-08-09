package it.unibo.bmbman.model;

import it.unibo.bmbman.controller.BombController;
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
    private BombController bc;
    /**
     * 
     * @param dimension 
     * @param bc 
     */
    public Bomb(final Dimension dimension, final BombController bc) {
        super(null, EntityType.BOMB, dimension);
        this.isPlanted = false; 
        this.bc = bc;
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
    /**
     * 
     */
    public void setPosition(final Position position) {
        super.setPosition(position);
    }

    @Override
    public boolean remove() {
        bc.getBomb().remove(this);
        return !this.isPlanted;
    }

    @Override
    protected void reachedBorder() {
        
    }

    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        //credo non debba fare nulla
    }

    @Override
    public void update() {
        if (this.timer > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - this.timer >= MAX_TIMER) {
                this.timer = 0;
                bc.startExplosion();
                this.remove();
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
