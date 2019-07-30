package it.unibo.bmbman.model;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
/**
 * Class used to model the beaviour of a wall.
 */
public class Wall extends AbstractStaticEntity {
    /**
     * Create a wall.
     * @param position start position of the monster
     * @param solidity da togliere
     * @param entityType type of the entity
     * @param dimension dimension2D of the monster
     */
    public Wall(final Point2D position, final boolean solidity, final EntityType entityType, final Rectangle2D dimension) {
        super(position, solidity, entityType, dimension);
    }

    @Override
    public void onCollision(Entity receiver) {
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }
}
