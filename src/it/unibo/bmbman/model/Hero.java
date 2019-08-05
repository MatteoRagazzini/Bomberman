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
    public Hero() {
        super(new Position(200, 200), EntityType.HERO, new Dimension(45, 48), 3);
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        this.setPosition(newPosition);
        this.setDirection(Direction.IDLE);
        System.out.println("Eroe colliso con" + receiver.getType());
        if (receiver.getType() == EntityType.MONSTER) {
            this.removeLife();
        }

    }

    @Override
    protected void reachedBorder() {

    }

}
