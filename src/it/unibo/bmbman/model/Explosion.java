package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

public class Explosion extends AbstractEntity {
    private Hero hero;
    private boolean isStarted;

    public Explosion(Position position, EntityType entityType, Dimension dimension) {
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
    public void onCollision(Entity receiver, Position newPosition) {
        if (receiver.getType() == EntityType.HERO) {
            this.hero = (Hero) receiver;
            this.hero.removeLife();
        }
    }

    @Override
    public void update() {
        
    }

}
