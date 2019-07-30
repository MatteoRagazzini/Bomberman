package it.unibo.bmbman.controller;

import java.util.Set;

import it.unibo.bmbman.model.Entity;

public class CollisionControllerImpl implements CollisionController {
    private final Entity followedEntity;
    
    public CollisionControllerImpl(Entity followedEntity) {
        this.followedEntity = followedEntity;
    }

    @Override
    public Entity collision(final Set<Entity> entities) {
        entities.stream().filter(e -> e.getDimension().intersects(this.followedEntity.getDimension()))
        .forEach(e -> notifyCollision(e));
        return null;
    }

    @Override
    public void notifyCollision(final Entity receiver) {
        this.followedEntity.onCollision(receiver);

    }

}
