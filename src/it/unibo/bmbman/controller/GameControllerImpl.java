package it.unibo.bmbman.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.bmbman.model.AbstractLivingEntity;
import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityFeature;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.utilities.PlayerScore;
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
    private final BombControllerImpl bc;
    private final PlayerScore ps;
    /**
     * Construct an implementation of {@link GameController}.
     * @param gstate {@link GameStateController}
     */
    public GameControllerImpl(final GameStateController gstate, final SoundsController soundsController) {
        this.worldEntity = new ArrayList<>();
        this.setController = new HashSet<>();
        this.gstate = gstate;
        this.bc = new BombControllerImpl(soundsController);
        this.ps = new PlayerScore();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.spv = new SinglePlayerView(new KeyInput(this, this.gstate, this.bc), this.ps, this.getHero());
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
    public void addBomb() {

       final Optional<Bomb> plantedBomb = this.bc.plantBomb(getHero());
       if (plantedBomb.isPresent()) {
           System.out.println("AGGIUNTA BOMBA");
           this.worldEntity.add(plantedBomb.get());
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
        return worldEntity.stream().filter(x -> x.getType().getIsBreakable() == EntityFeature.BREAKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getUnbreakableEntity() {
        return worldEntity.stream().filter(x -> x.getType().getIsBreakable() == EntityFeature.UNBREAKABLE)
                .collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void collisionDetect() {
        this.setController.stream().map(c -> c.getCollisionManager()).forEach(c -> c.ifPresent(cc -> cc.collision(getUnwalkableEntity())));
        this.bc.collision(getBreakableEntity());
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
        removeEntities();
        final Graphics g = this.spv.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, MyGUIFactory.FRAME_WIDTH, MyGUIFactory.FRAME_HEIGHT);
        collisionDetect();
        this.setController.stream().filter(ec -> ec.getEntity().getType() == EntityType.TILE).forEach(ec -> ec.update(g));
        this.setController.stream().filter(ec -> ec.getEntity().getType() == EntityType.POWER_UP).forEach(ec -> ec.update(g));
        this.setController.stream().filter(ec -> ec.getEntity().getType() == EntityType.BLOCK).forEach(ec -> ec.update(g));
        this.setController.stream().filter(ec -> ec.getEntity() instanceof AbstractLivingEntity || ec.getEntity().getType() == EntityType.WALL)
        .forEach(ec -> ec.update(g));
        this.bc.update(g);
        this.spv.render();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void gameOver() {
        this.spv.getFrame().setVisible(false);
    }
    /**
     * {@inheritDoc}}
     */
    @Override
    public void removeEntities() {
        final List<Entity> entityToRemoved = this.worldEntity.stream().filter(e -> e.remove()).collect(Collectors.toList());
        this.ps.setScore(entityToRemoved);
        this.worldEntity.removeAll(entityToRemoved);
        final Set<EntityController> controllerToRemoved = this.setController.stream().filter(c -> entityToRemoved.contains(c.getEntity()) && c.getEntity().getType() != EntityType.POWER_UP).collect(Collectors.toSet());
        this.setController.stream().filter(c -> entityToRemoved.contains(c.getEntity())).forEach(c -> c.getEntityView().setVisible(false));
        this.setController.removeAll(controllerToRemoved);
        this.bc.removeBomb();
    }
}
