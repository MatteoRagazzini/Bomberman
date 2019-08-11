package it.unibo.bmbman.model;

import it.unibo.bmbman.model.utilities.Position;
/**
 * The interface for a Collision between two entities in our game.
 */
public interface Collision {

    /**
     * Used to get the other entity of the collision.
     * @return {@link Entity}
     */
    Entity getReceiver();

    /**
     * Used set new enitity's position to avoid continuos collision.
     * @return {@link Position}
     */
    Position getPosition();
}
