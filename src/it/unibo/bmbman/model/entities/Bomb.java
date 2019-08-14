package it.unibo.bmbman.model.entities;

import java.awt.Rectangle;

import it.unibo.bmbman.controller.SoundsController;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.collision.Collision;
import it.unibo.bmbman.model.utilities.BombState;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.EntityType;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
public class Bomb extends AbstractEntity {
    private BombState state;
    private long timer = 0;
    private static final int MAX_TIMER = 3;
    private static final long MILLIS = 1000;
    private static int RANGE = 3;
    private static int BOMBS_NUMBER = 1;
    private Pair<Rectangle, Rectangle> explosion; 
    /**
     * 
     * @param position 
     */
    public Bomb(final Position position) {
        super(position, EntityType.BOMB, new Dimension(Terrain.CELL_DIMENSION, Terrain.CELL_DIMENSION));
        this.state = BombState.PLANTED;
        this.explosion = new Pair<>(new Rectangle(position.getX() - 50, position.getY(), 0, 0),
                                    new Rectangle(position.getX(), position.getY() - 50, 0, 0));
    }
    /**
     * 
     * @return explosion 
     */
    public Pair<Rectangle, Rectangle> getExplosion() {
        return explosion;
    }

    public boolean remove() {
        return getState() == BombState.EXPLODED;
    }

    public BombState getState() {
        return this.state;
        
    }
    public void setBombExploded() {
//        this.inExplosion = false;
//        this.isExploded = true;
        this.state = BombState.EXPLODED;
    }
    @Override
    public void update() {
        if (this.timer > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - this.timer >= MAX_TIMER) {
                this.timer = 0;
                this.state = BombState.IN_EXPLOSION;
                final Position pos = this.getPosition();
                Rectangle horizontal = new Rectangle(pos.getX()-getShift()*50, pos.getY(), 50*RANGE, 50);
                Rectangle vertical = new Rectangle(pos.getX(), pos.getY()-getShift()*50, 50, 50*RANGE);
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
    public void onCollision(Collision c) {

    }
    public static void resetBonusRange() {
        RANGE = 3;
    }
    
    public static void resetBombNumber() {
        BOMBS_NUMBER = 1;
    }
    
    public static void incrementRange() {
        RANGE = 5;
    }
    
    public static void incrementBombsNumber() {
        BOMBS_NUMBER++;
    }
    
    public static int getBombsNumber() {
        return BOMBS_NUMBER;
    }
    
    private int getShift() {
        return RANGE == 3 ? 1: 2;
    }
}
