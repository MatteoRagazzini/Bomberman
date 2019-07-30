package it.unibo.bmbman.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityFeature;
import it.unibo.bmbman.model.EntityType;
/**
 *
 */
public class GameControllerImpl implements GameController {
    private final List<Entity> worldEntity;
    private final Set<CollisionController> setCollider;
    /**
     * 
     */
    public GameControllerImpl() {
        // TODO Auto-generated constructor stub
        this.worldEntity = new ArrayList<>();
        this.setCollider = new HashSet<>();
    }
    /**
     * 
     */
    @Override
    public void addEntity(final Entity entity) {
        this.worldEntity.add(entity);
        if (entity.getType() == EntityType.HERO || entity.getType() == EntityType.MONSTER) {
            this.setCollider.add(new CollisionControllerImpl(entity));
        }
    }
    /**
     * 
     */
    @Override
    public Set<Entity> getUnwalkableEntity() {
        // TODO Auto-generated method stub
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.UNWALKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * 
     */
    @Override
    public Set<Entity> getWalkableEntity() {
        // TODO Auto-generated method stub
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.WALKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * 
     */
    @Override
    public Set<Entity> getBreakableEntity() {
        // TODO Auto-generated method stub
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.BREAKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * 
     */
    @Override
    public Set<Entity> getUnbreakableEntity() {
        // TODO Auto-generated method stub
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.UNBREAKABLE)
                .collect(Collectors.toSet());
    }

    @Override
    public void collisionDetect() {
        this.setCollider.stream().forEach(c -> c.collision(getUnwalkableEntity()));
    }

}
