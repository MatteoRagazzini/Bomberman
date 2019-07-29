package it.unibo.bmbman.controller;

import java.util.Set;

import it.unibo.bmbman.model.Entity;

/**
 * Collision Manager
 */
public interface CollisionController {
    
    Entity collision(Set<Entity> entities);
    
    void notifyCollision(Entity receiver);

}
