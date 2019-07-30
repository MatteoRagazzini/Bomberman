package it.unibo.bmbman.model;

import java.util.Random;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
/**
 * Model the creation and the beaviour of the monster.
 * 
 *
 */
public class Monster extends AbstractLivingEntity {
    private Random rand = new Random();

    /**
     * Create a monster.
     * @param position start position of the monster
     * @param lives number of lives
     * @param solidity da togliere
     * @param entityType type of the entity
     * @param dimension dimension2D of the monster
     */
    public Monster(final Point2D position, final int lives, final boolean solidity, final EntityType entityType, final Rectangle2D dimension) {
        super(position, lives, solidity, entityType, dimension);
        this.setDirection(Direction.UP);
        move();
    }
    /**
     * Method used to generate a random direction.
     * @return a new direction
     */
    // metto final perchè pmd si lamentava del fatto che non posso mettere un metodo ovverridabale dentro il 
    // posso mettere un metodo ovverridabale dentro il costruttore
    private Direction randomDirection() {
        final int dir = rand.nextInt(4);
        switch (dir) {
            case 0 : setDirection(Direction.DOWN);
            break;
            case 1 : setDirection(Direction.UP);
            break;
            case 2 : setDirection(Direction.LEFT);
            break;
            case 3 : setDirection(Direction.RIGHT);
            break;
            default :
                break;
        }
        return this.getDirection();
    } 
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCollision(final Entity receiver) {
        setDirection(randomDirection()); 
    }
}
