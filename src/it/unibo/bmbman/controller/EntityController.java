package it.unibo.bmbman.controller;

import java.awt.Graphics;
import java.util.Optional;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.view.entities.EntityView;

/**
 * Used to create a controller foreach entity in our game.
 */
public interface EntityController {
    /**
     * Used to get the entity.
     * @return {@link Entity}
     */
    Entity getEntity();
    /**
     * Used to get the image associated to the entity.
     * @return {@link EntityView}
     */
    EntityView getEntityView();
    /**
     * Used to get {@link CollisionController} associated to the entity.
     * @return {@link CollisionController}
     */
    Optional<CollisionController> getCollisionController();
    /**
     * Used to update view and model.
     * @param g {@link Graphics} compontent to update view
     */
    void update(Graphics g);
}
