package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Models the general aspects of a power-up entity.
 */
public abstract class AbstractPowerupEntity extends AbstractEntity {

    private static final int DURATION = 5;
    private static final long MILLIS = 1000;
    private Hero hero;
    private long startTime;
    /**
     * Constructor for a general power-up.
     * @param position the position where i want to locate the power-up
     * @param dimension the dimension of the power-up
     */
    public AbstractPowerupEntity(final Position position, final Dimension dimension) {
        super(position, EntityType.POWER_UP, dimension);
    }
    /**
     * After a collision with the hero, activate the power-up effect.
     */
    @Override
    public void onCollision(final Entity receiver, final Position newPosition) {
        if (receiver.getType() == EntityType.HERO) {
            this.hero = (Hero) receiver;
            this.startTime = System.currentTimeMillis() / MILLIS;
            powerupEffect(hero);
        }
    }
    /**
     * Active the effect.
     * @param hero the target of the effect.
     */
    public abstract void powerupEffect(Hero hero);
    @Override
    protected void reachedBorder() {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        if (startTime > 0) {
            final long now = System.currentTimeMillis() / MILLIS;
            if (now - startTime >= DURATION) {
                startTime = 0;
                hero.setVelocityModifier(1.0);
                System.out.println("Finito effetto");
            }
        }
    }
    @Override
    public boolean remove() {
        return this.startTime > 0;
    }
}
