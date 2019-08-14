package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Position;
/**
 * Model a bonus bomb range power-up.
 */
public class BonusBombRange extends AbstractPowerupEntity {
    /**
     * Construct a bonus bomb range power-up in the world.
     * @param position where to create it.
     * @param dimension the dimension of the power-up.
     */
    public BonusBombRange(final Position position) {
        super(position, true);
    }
    /**
     * {@inheritDoc}}
     */
    @Override
    public void powerupEffect(final Hero hero) {
        Bomb.incrementRange();
    }
    @Override
    public void removeEffect(Hero hero) {
       Bomb.resetBonusRange();
        
    }
}
