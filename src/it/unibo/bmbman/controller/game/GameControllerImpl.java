package it.unibo.bmbman.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import it.unibo.bmbman.model.Bomb;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityFeature;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.Level;
import it.unibo.bmbman.model.LevelImpl;
import it.unibo.bmbman.model.engine.GameEngine;
import it.unibo.bmbman.model.engine.GameEngineImp;
import it.unibo.bmbman.model.utilities.PlayerScore;
import it.unibo.bmbman.view.EndView;
import it.unibo.bmbman.view.MainMenuView;
import it.unibo.bmbman.view.SinglePlayerView;
import it.unibo.bmbman.view.entities.EntityView;
/**
 * An implementation of {@link GameController}.
 */
public class GameControllerImpl implements GameController {
    private  List<Entity> worldEntity;
    private  Set<EntityController> setController;
    private  SinglePlayerView spv;
    private  BombControllerImpl bc;
    private PlayerScore ps;
    private final MainMenuView mainView; 
    private final SoundsController soundsController;
    private  GameEngine engine;
    private boolean inPause;
    private Level lv = new LevelImpl(); 

    /**
     * Construct an implementation of {@link GameController}.
     * @param soundsController {@link SoundsController}
     * @param menuView {@link MainMenuView}
     */
    public GameControllerImpl(final SoundsController soundsController, final MainMenuView menuView) {
        this.worldEntity = new CopyOnWriteArrayList<>();
        this.setController = new HashSet<>();
        this.mainView = menuView;
        this.soundsController = soundsController;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel() {

        return lv; 
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.bc = new BombControllerImpl(soundsController);
        this.ps = new PlayerScore();
        this.engine = new GameEngineImp(this, soundsController);
        final LoadWorld lw = new LoadWorld(this);
        lw.loadEntity();
        this.spv = new SinglePlayerView(new KeyInput(this, this.bc), this.ps, this.getHero());
        this.spv.getFrame().setVisible(true);
        this.engine.startEngine();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void pause() {
        inPause = !inPause;
        this.engine.setPause(inPause);
    }
    /**
     * 
     * @return true if the hero is dead
     */
    public boolean isGameOver() {
        return !getHero().isAlive();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void endView() {
        this.spv.getFrame().setVisible(false);
        EndView end = new EndView(mainView, ps, EndGameState.LOSE, this);
        if (hasWon()) {
            end = new EndView(mainView, ps, EndGameState.WIN, this);
            reset();
        }
        end.getFrame().setVisible(true);
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
            this.worldEntity.add(plantedBomb.get());
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getUnwalkableEntity() {
        return new CopyOnWriteArraySet<>(worldEntity.stream().filter(x -> x.getType().getIsWalkable() == EntityFeature.UNWALKABLE)
                .collect(Collectors.toSet()));
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
        return new CopyOnWriteArraySet<>(worldEntity.stream().filter(x -> x.getType().getIsBreakable() == EntityFeature.BREAKABLE)
                .collect(Collectors.toSet()));
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
     * {@inheritDoc}
     */
    @Override
    public void update() {
        removeEntities();
        collisionDetect();
        this.setController.forEach(ec -> ec.update());
        //        this.setController.stream().filter(ec -> ec.getEntity().getType() == EntityType.TILE).forEach(ec -> ec.update());
        //        this.setController.stream().filter(ec -> ec.getEntity().getType() == EntityType.POWER_UP).forEach(ec -> ec.update());
        //        this.setController.stream().filter(ec -> ec.getEntity().getType() == EntityType.BLOCK).forEach(ec -> ec.update());
        //        this.setController.stream().filter(ec -> ec.getEntity() instanceof AbstractLivingEntity || ec.getEntity().getType() == EntityType.WALL)
        //        .forEach(ec -> ec.update());
        this.spv.render(this.setController.stream().map(ec -> ec.getEntityView()).collect(Collectors.toSet()), this.bc.getBombView());
        this.bc.update();
    }
    /**
     * {@inheritDoc}}
     */
    @Override
    public void removeEntities() {
        final List<Entity> entityToRemoved = this.worldEntity.stream().filter(e -> e.remove()).collect(Collectors.toList());
        this.ps.updateScore(entityToRemoved);
        this.worldEntity.removeAll(entityToRemoved);
        final Set<EntityController> controllerToRemoved = this.setController.stream().filter(c -> entityToRemoved.contains(c.getEntity()) && c.getEntity().getType() != EntityType.POWER_UP).collect(Collectors.toSet());
        this.setController.stream().filter(c -> entityToRemoved.contains(c.getEntity())).forEach(c -> c.getEntityView().setVisible(false));
        this.setController.removeAll(controllerToRemoved);
        this.bc.removeBomb();
    }
    @Override
    public boolean hasWon() {
        return getHero().hasWon();
    }
    
    @Override
    public void reset() {
        this.worldEntity = new CopyOnWriteArrayList<>();
        this.setController = new CopyOnWriteArraySet<>();
    }
}
