package it.unibo.bmbman.model;

import java.util.Random;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.BombState;

/**
 * Model the creation and the beaviour of the monster.
 * 
 *
 */
public class Monster extends AbstractLivingEntity {

    private Random rand = new Random();
    private static final int DIMX = 48;
    private static final int DIMY = 48;
    private static final int NLIVES = 1;

    /**
     * Create a monster.
     * @param position start position of the monster
     */
    public Monster(final Position position) {
        super(position, EntityType.MONSTER, new Dimension(DIMX, DIMY), NLIVES);
        this.setDirection(randomDirection());
    }
    /**
     * Method used to generate a random direction.
     * @return a new direction
     */
    // metto final perchè pmd si lamentava del fatto che non posso mettere un metodo ovverridabale dentro il 
    // posso mettere un metodo ovverridabale dentro il costruttore
    // risolto mettendo il metodo private
    private Direction randomDirection() {
        final int dir = rand.nextInt(4);
        Direction d = this.getDirection();
        switch (dir) {
        case 0 : d = Direction.DOWN;
        break;
        case 1 : d = Direction.UP;
        break;
        case 2 : d = Direction.LEFT;
        break;
        case 3 : d = Direction.RIGHT;
        break;
        default :
            break;
        }
        return d;
    } 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Collision c) {
        switch (c.getReceiver().getType()) {
        case BOMB:
            if (((Bomb) c.getReceiver()).getState()==BombState.IN_EXPLOSION) {
                removeLife();
            } else {
                setDirection(randomDirection());
                this.setPosition(c.getPosition());
            }
            break;
        case HERO:
            setDirection(Direction.getOpposite(getDirection()));
            this.setPosition(c.getPosition());
            break;
        case POWER_UP:
            break;
        default:
            setDirection(randomDirection());
            this.setPosition(c.getPosition());
            break;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected void reachedBorder() {
        setDirection(randomDirection());
    }

}
