package it.unibo.bmbman.controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Set;

import it.unibo.bmbman.model.Entity;
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
               setFollowedEntityNewPosition(this.followedEntity.getPosition().x, e.getPosition().y + this.followedEntity.getDimension().height);
               notifyCollision(e);
            } else if (checkCollision(e, followedEntity.getCollisionComponent().getBottomHitbox())) {
                setFollowedEntityNewPosition(this.followedEntity.getPosition().x, e.getPosition().y - this.followedEntity.getDimension().height);
                notifyCollision(e);
            } else if (checkCollision(e, followedEntity.getCollisionComponent().getLeftHitbox())) {
                setFollowedEntityNewPosition(e.getPosition().x + this.followedEntity.getDimension().width, this.followedEntity.getPosition().y);
                notifyCollision(e);
            } else if (checkCollision(e, followedEntity.getCollisionComponent().getRightHitbox())) {
                setFollowedEntityNewPosition(e.getPosition().x - this.followedEntity.getDimension().width, this.followedEntity.getPosition().y);
                notifyCollision(e);
            }
        });
    }
    private boolean checkCollision(final Entity receiver, final Rectangle collider) {
        return receiver.getCollisionComponent().getHitbox().intersects(collider);
    }
    private void setFollowedEntityNewPosition(final int x, final int y) {
        this.followedEntity.setPosition(new Point(x, y));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyCollision(final Entity receiver) {
        System.out.println("notifico collisione con " + receiver.getType());
        this.followedEntity.onCollision(receiver);

    }

}
