package it.unibo.bmbman.model;

import it.unibo.bmbman.controller.Scoring;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Models the general aspects of a power-up entity.
 */
public abstract class AbstractPowerupEntity extends AbstractEntity {

    private static final int DURATION = 5;
    private static final long MILLIS = 1000;
    private final boolean isBonus;
    private Hero hero;
    private long startTime;
    /**
     * Constructor for a general power-up.
     * @param position the position where i want to locate the power-up
     * @param dimension the dimension of the power-up
     * @param isBonus if it's a bonus or a malus.
     */
    public AbstractPowerupEntity(final Position position, final Dimension dimension, final boolean isBonus) {
        super(position, EntityType.POWER_UP, dimension);
        this.isBonus = isBonus;
    }
    /**
     * After a collision with the hero, activate the power-up effect.
     */
    @Override
    public void onCollision(final Collision c) {
        if (c.getReceiver().getType() == EntityType.HERO) {
            this.hero = (Hero) c.getReceiver();
            this.startTime = System.currentTimeMillis() / MILLIS;
            powerupEffect(hero);
            //Scoring.updateScore(this.isBonus);
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
                System.out.println("effetto finito");
                hero.setVelocityModifier(1.0);
            }
        }
    }
    @Override
    public boolean remove() {
        return this.startTime > 0;
    }

}
