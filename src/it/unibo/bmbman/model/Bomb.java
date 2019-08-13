package it.unibo.bmbman.model;

import java.awt.Rectangle;

import it.unibo.bmbman.controller.SoundsController;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 */
import it.unibo.bmbman.view.entities.BombState;
public class Bomb extends AbstractEntity {
    private BombState state;
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
        this.state = BombState.PLANTED;
        this.explosion = new Pair<>(new Rectangle(position.getX()-50, position.getY(), 0, 0),
                                    new Rectangle(position.getX(), position.getY()-50, 0, 0));
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
                Rectangle horizontal = new Rectangle(pos.getX()-50, pos.getY(), 50*RANGE, 50);
                Rectangle vertical = new Rectangle(pos.getX(), pos.getY()-50, 50, 50*RANGE);
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
        // TODO Auto-generated method stub
        
    }
}
