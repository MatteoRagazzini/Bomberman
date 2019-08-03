package it.unibo.bmbman.controller;

import java.awt.Graphics;
import java.util.Optional;

import it.unibo.bmbman.model.AbstractLivingEntity;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.view.entities.EntityView;
/**
 * An implementation of {@link EntityController}.
 */
public class EntityControllerImpl implements EntityController {

    private final Entity en;
    private final EntityView ev;
    private final Optional<CollisionController> cc;

    /**
     * Construct an {@link EntityControllerImpl}.
     * @param en the entity followed
     * @param ev the {@link EntityView} of entity
     */
    public EntityControllerImpl(final Entity en, final EntityView ev) {
        super();
        this.en = en;
        this.ev = ev;
        updateView();
        if (en.getType() == EntityType.HERO || en.getType() == EntityType.MONSTER) {
        this.cc = Optional.of(new CollisionControllerImpl(en));
        } else {
            this.cc = Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity getEntity() {
        return this.en;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public EntityView getEntityView() {
        return this.ev;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<CollisionController> getCollisionController() {
        return this.cc;
    }
    /**
     * {@inheritDoc}.
     */
    private void updateView() {
        this.ev.setDimension(en.getDimension());
        this.ev.setPosition(en.getPosition());
        if (en instanceof AbstractLivingEntity) {
            this.ev.changeDirection(((AbstractLivingEntity) en).getDirection()); 
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Graphics g) {
        updateView();
        this.en.update();
        this.ev.render(g);

    }

}
