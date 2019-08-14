package it.unibo.bmbman.controller;

import java.util.Set;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.view.entities.EntityView;
import it.unibo.bmbman.model.Level;
/**
 * Interface to handler all the entity in game.
 */
import it.unibo.bmbman.model.utilities.PlayerScore;
public interface GameController {
    /**
     * Used to start the game.
     */
    void startGame();
    /**
     * Used to notify GameOver.
     */
    void endView();
    /**
     * Used to set in pause the game.
     */
    void pause();
    /**
     * Used to store all the entities in game.
     * @param entity the {@link Entity} to add
     * @param enitityView the {@link EntityView} of entity to add
     */
    void addEntity(Entity entity, EntityView enitityView);
    /**
     * Used to add a {@link Bomb}.
     */
    void addBomb();
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
     * Used to get the hero.
     * @return {@link Entity} representing player. 
     */
    Hero getHero();
    PlayerScore getPlayerScore();
    /**
     * Used to know if game is over.
     * @return true if hero is dead
     */
    boolean isGameOver();
    /**
     * Used to know if the player has won.
     * @return true if the hero has the key and has found the door
     */
    boolean hasWon();
    /**
     * Used to update any entity in the world.
     */
    void update();
    /**
     * this method notify a collision to {@link collisionController}.
     */
    void collisionDetect();
    /**
     * Remove entities from the world.
     */
    void removeEntities();
    /**
     * provides level information. 
     * @return an instance of level
     */
    Level getLevel();
    /**
     * Reset the gameController after the win.
     */
    void reset();
}

