package it.unibo.bmbman.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.utilities.Position;
/**
 * An implementation of {@link CollisionController}.
 */
public class CollisionControllerImpl implements CollisionController {
    private final Entity followedEntity;
    /**
     * Constructor for {@link CollisionControllerImpl}.
     * @param followedEntity {@link Entity} associated to this {@link CollisionController}
     */
    public CollisionControllerImpl(final Entity followedEntity) {
        this.followedEntity = followedEntity;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void collision(final Set<Entity> entities) {
        entities.stream().filter(e -> !e.equals(followedEntity))
        .forEach(e -> {
            if (checkCollision(e, followedEntity.getCollisionComponent().getTopHitbox())) {
                notifyCollision(e, new Position(this.followedEntity.getPosition().getX(), e.getPosition().getY() + e.getDimension().getHeight()));
            } else if (checkCollision(e, followedEntity.getCollisionComponent().getBottomHitbox())) {
                notifyCollision(e, new Position(this.followedEntity.getPosition().getX(), e.getPosition().getY() - e.getDimension().getHeight()));
            } else if (checkCollision(e, followedEntity.getCollisionComponent().getLeftHitbox())) {
                notifyCollision(e, new Position(e.getPosition().getX() + e.getDimension().getWidth(), this.followedEntity.getPosition().getY()));
            } else if (checkCollision(e, followedEntity.getCollisionComponent().getRightHitbox())) {
                notifyCollision(e, new Position(e.getPosition().getX() - e.getDimension().getWidth(), this.followedEntity.getPosition().getY()));
            }
        });
    }
    private boolean checkCollision(final Entity receiver, final Rectangle collider) {
        return receiver.getCollisionComponent().getHitbox().intersects(collider);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyCollision(final Entity receiver, final Position position) {
        this.followedEntity.onCollision(receiver, position);
        receiver.onCollision(followedEntity, receiver.getPosition());

    }

}
