package it.unibo.bmbman.model;


import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Representing a hero in our application.
 */
public class Hero extends AbstractLivingEntity {
    /**
     * Construct a Hero in game.
     */
    public Hero(final Position position) {
        super(position, EntityType.HERO, new Dimension(45, 48), 3);
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        this.setPosition(newPosition);
        this.setDirection(Direction.IDLE);
        if (receiver.getType() == EntityType.MONSTER) {
            this.removeLife();
        }

    }

    @Override
    protected void reachedBorder() {

    }

}
