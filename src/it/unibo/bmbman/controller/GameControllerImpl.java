package it.unibo.bmbman.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityFeature;
import it.unibo.bmbman.model.EntityType;
/**
 * 
 * @author marta
 *
 */
public class GameControllerImpl implements GameController {
    private final List<Entity> worldEntity;
    /**
     * 
     */
    public GameControllerImpl() {
        // TODO Auto-generated constructor stub
        this.worldEntity=new ArrayList<>();
    }
/**
 * 
 */
    @Override
    public void addEntity(final Entity entity) {
        // TODO Auto-generated method stub
        this.worldEntity.add(entity);

    }
/**
 * 
 */
    @Override
    public Set<Entity> getUnwalkableEntity() {
        // TODO Auto-generated method stub
        return worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.UNWALKABLE).collect(Collectors.toSet());
    }
/**
 * 
 */
    @Override
    public Set<Entity> getWalkableEntity() {
        // TODO Auto-generated method stub
        return null;
    }
/**
 * 
 */
    @Override
    public Set<Entity> getBreakableEntity() {
        // TODO Auto-generated method stub
        return null;
    }
/**
 * 
 */
    @Override
    public Set<Entity> getUnbreakableEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void collisionDetect() {
        // TODO Auto-generated method stub

    }

}