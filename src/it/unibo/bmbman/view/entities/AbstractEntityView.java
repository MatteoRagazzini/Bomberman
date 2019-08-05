package it.unibo.bmbman.view.entities;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import it.unibo.bmbman.model.Direction;
import it.unibo.bmbman.model.utilities.Position;
/**
 * Abstarct implementation of entityView.
 */
public abstract class AbstractEntityView implements EntityView {

    private Position position;
    private  Dimension dimension;
    private Direction direction;
    private boolean visible;
    /**
     * Constructor for an EntityView.
     * @param position where is the entity in our terrien
     * @param dimension the dimension of entity
     * @param visible if the enity is visible or not
     */
    public AbstractEntityView(final Position position, final Dimension dimension, final boolean visible) {
        this.position = position;
        this.dimension = dimension;
        this.visible = visible;
        this.direction = Direction.IDLE;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Position position) {
        this.position = position;

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Position getPosition() {
        return this.position;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setDimension(final Dimension dimension) {
        this.dimension = dimension;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getDimension() {
        return this.dimension;
    }
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public void setSprite(final Image image) {
//        this.image = image;
//    }
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract Image getSprite();
    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getVisible() {
        return this.visible;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void changeDirection(final Direction direction) {
        this.direction = direction;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final Graphics g) {
        g.drawImage(getSprite(), getPosition().getX(), getPosition().getY(), getDimension().width, getDimension().height, null);
    }


}
