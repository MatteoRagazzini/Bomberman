package it.unibo.bmbman.model;

import java.awt.Rectangle;
/**
 * Implementation of {@link CollisionComponent}.
 */
public class CollisionComponentImpl implements CollisionComponent {
    private static final int POSITION_ADJUSTMENT = 10;
    private static final int HEIGHT_ADJUSTMENT = 5;
    private static final int WIDTH_ADJUSTMENT = 20;
    private final Entity entity;
    /**
     * Construct a {@code CollisionComponentImpl}.
     * @param entity the followed entity
     */
    public CollisionComponentImpl(final Entity  entity) {
        this.entity = entity;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getHitbox() {
        return new Rectangle(entity.getPosition().getX(), entity.getPosition().getY(),
                entity.getDimension().width, entity.getDimension().height);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getTopHitbox() {
        return new Rectangle(entity.getPosition().getX() + POSITION_ADJUSTMENT, entity.getPosition().getY(),
                entity.getDimension().width - WIDTH_ADJUSTMENT, HEIGHT_ADJUSTMENT);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getBottomHitbox() {
        return new Rectangle(entity.getPosition().getX() + POSITION_ADJUSTMENT, entity.getPosition().getY() + entity.getDimension().height - HEIGHT_ADJUSTMENT,
                entity.getDimension().width - WIDTH_ADJUSTMENT, HEIGHT_ADJUSTMENT);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getLeftHitbox() {
        return new Rectangle(entity.getPosition().getX(), entity.getPosition().getY() + POSITION_ADJUSTMENT,
                HEIGHT_ADJUSTMENT, entity.getDimension().height - WIDTH_ADJUSTMENT);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getRightHitbox() {
        return new Rectangle(entity.getPosition().getX() + entity.getDimension().width - HEIGHT_ADJUSTMENT, entity.getPosition().getY() + POSITION_ADJUSTMENT,
                HEIGHT_ADJUSTMENT, entity.getDimension().height - WIDTH_ADJUSTMENT);
    }

}
