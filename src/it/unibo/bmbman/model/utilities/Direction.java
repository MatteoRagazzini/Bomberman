package it.unibo.bmbman.model.utilities;
/**
 * Define the direction in which an entity can move.
 *
 */
public enum Direction {
    /**
     * right direction.
     */
    RIGHT,
    /**
     * left direction.
     */
    LEFT,
    /**
     * up direction.
     */
    UP,
    /**
     * down direction.
     */
    DOWN,
    /**
     * no direction, the player is idle.
     */
    IDLE;
    
    public static Direction getOpposite(Direction d) {
         Direction opposite = d;
        switch(d) {
        case DOWN: opposite = UP;
            break;
        case LEFT: opposite = Direction.RIGHT;
            break;
        case RIGHT: opposite = Direction.LEFT;
            break;
        case UP: opposite = DOWN;
            break;
        default:
            break;
        
        }
        return opposite;
    }
}
