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
//        entities.stream().filter(e -> !e.equals(followedEntity) &&
//                e.getDimension().intersects(this.followedEntity.getDimension()))
//        .peek(e -> notifyCollision(e));
        
        for(Entity t : entities) {
//            if(!t.equals(followedEntity) && followedEntity.getDimension().intersects(t.getDimension())) {
//                notifyCollision(t);
//            }
        }
        return null;
    }

    @Override
    public void notifyCollision(final Entity receiver) {
        System.out.println("notifico collisione con " + receiver.getType());
        this.followedEntity.onCollision(receiver);

    }

}
