package it.unibo.bmbman.model.entities.powerUp;

import it.unibo.bmbman.model.entities.Bomb;
import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Model a bonus bomb range power-up.
 */
public class BonusBombRange extends AbstractPowerupEntity {
    /**
     * Construct a bonus bomb range power-up in the world.
     * @param position where to create it.
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEffect(final Hero hero) {
       Bomb.resetBonusRange();
    }
}
