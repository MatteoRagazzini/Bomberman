package it.unibo.bmbman.controller;

import java.util.Set;
import it.unibo.bmbman.model.Entity;
/**
 * Interface to handler all the entity in game.
 */
public interface GameController {
    /**
     * Used to store all the entities in game.
     * @param entity
     */
    void addEntity(Entity entity);
    /**
     * used to know all the unwalkable entities.
     * @return a set of entity
     */
    Set<Entity> getUnwalkableEntity();
    /**
     *used to know all the walkable entities.
     * @return a set of entity
     */
    Set<Entity> getWalkableEntity();
    /**
     *used to know all the breakable entities.
     * @return a set of entity
     */
    Set<Entity> getBreakableEntity();
    /**
     *used to know all the unbreakable entities.
     * @return a set of entity
     */
    Set<Entity> getUnbreakableEntity();
    /**
     * this method notify a collision to {@link collisionController}.
     */
    void collisionDetect();
}

