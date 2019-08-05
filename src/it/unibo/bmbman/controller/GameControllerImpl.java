package it.unibo.bmbman.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityFeature;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.view.MyGUIFactory;
import it.unibo.bmbman.view.SinglePlayerView;
import it.unibo.bmbman.view.entities.EntityView;
/**
 * An implementation of {@link GameController}.
 */
public class GameControllerImpl implements GameController {
    private final List<Entity> worldEntity;
    private final Set<EntityController> setController;
    private SinglePlayerView spv;
    private final GameStateController gstate;
    /**
     * Construct an implementation of {@link GameController}.
     * @param gstate {@link GameStateController}
     */
    public GameControllerImpl(final GameStateController gstate) {
        this.worldEntity = new ArrayList<>();
        this.setController = new HashSet<>();
        this.gstate = gstate;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.spv = new SinglePlayerView(new KeyInput(this, gstate));
        this.spv.getFrame().setVisible(true);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addEntity(final Entity entity, final EntityView entityView) {
        this.worldEntity.add(entity);
        this.setController.add(new EntityControllerImpl(entity, entityView));
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
        this.setController.stream().map(c -> c.getCollisionController()).forEach(c -> c.ifPresent(cc -> cc.collision(getUnwalkableEntity())));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Hero getHero() {
        return (Hero) this.worldEntity.stream().filter(e -> e.getType() == EntityType.HERO).findFirst().get();
    }
    /**
     * 
     * @return true if the hero is dead
     */
    public boolean isGameOver() {
        return getHero().isAlive();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        final Graphics g = this.spv.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, MyGUIFactory.FRAME_WIDTH, MyGUIFactory.FRAME_HEIGHT);
        collisionDetect();
        this.setController.forEach(c -> c.update(g));
        this.spv.render();
    }
    @Override
    public void gameOver() {
        this.spv.getFrame().setVisible(false);
    }


}
