package it.unibo.bmbman.controller.game;

import java.awt.Graphics;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import it.unibo.bmbman.model.entities.Bomb;
import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.utilities.Pair;
import it.unibo.bmbman.view.entities.BombView;
/**
 *
 */
public interface BombController {
    
    Set<BombView> getBombView();
    /**
     * Get bombs that must be removed.
     * @return list of {@link Bomb, BombView}
     */
    List<Pair<Bomb, BombView>> getBombsToRemove();
    /**
     * Get bombs that must explode.
     * @return list of {@link Bomb}
     */
    List<Bomb> getBombsInExplosion();
    /**
     * 
     * @param hero 
     * @return bomb that hero can plant, otherwise an empty optional.
     */
    Optional<Bomb> plantBomb(Hero hero);
    /**
     * Update {@link Bomb} view and model.
     * @param g {@link Graphics} to update view
     */
    void update(/*Graphics g*/);
    /**
     * Remove bombs that are exploded. 
     */
    void removeBomb();
    /**
     * 
     * @param entities 
     */
    void collision(Set<Entity> entities);
}
