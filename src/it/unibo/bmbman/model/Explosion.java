package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * 
 * @author lucia
 *
 */
public class Explosion extends AbstractEntity {
    private Hero hero;
    private boolean isStarted;
    /**
     * 
     * @param position 
     * @param entityType 
     * @param dimension 
     */
    public Explosion(final Position position, final EntityType entityType, final Dimension dimension) {
        super(position, entityType, dimension);
        this.isStarted = false;
    }

    @Override
    public boolean remove() {
        return !this.isStarted;
    }

    @Override
    protected void reachedBorder() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        if (receiver.getType() == EntityType.HERO) {
            this.hero = (Hero) receiver;
            this.hero.removeLife();
        }
        //altre collisioni
    }

    @Override
    public void update() {
        
    }

}
