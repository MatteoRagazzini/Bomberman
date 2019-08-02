package it.unibo.bmbman.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityFeature;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
/**
 * An implementation of {@link GameController}.
 */
public class GameControllerImpl implements GameController {
    private final List<Entity> worldEntity;
    private final Set<CollisionController> setCollider;
    /**
     * Construct an implementation of {@link GameController}.
     */
    public GameControllerImpl() {
        this.worldEntity = new ArrayList<>();
        this.setCollider = new HashSet<>();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addEntity(final Entity entity) {
        this.worldEntity.add(entity);
        if (entity.getType() == EntityType.HERO || entity.getType() == EntityType.MONSTER) {
            this.setCollider.add(new CollisionControllerImpl(entity));
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getUnwalkableEntity() {
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.UNWALKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getWalkableEntity() {
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.WALKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getBreakableEntity() {
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.BREAKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getUnbreakableEntity() {
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.UNBREAKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void collisionDetect() {
        this.setCollider.stream().forEach(c -> c.collision(getUnwalkableEntity()));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Hero getHero() {
        return (Hero) this.worldEntity.stream().filter(e -> e.getType() == EntityType.HERO).findFirst().get();
    }

}
