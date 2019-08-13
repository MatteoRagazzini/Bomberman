package it.unibo.bmbman.controller;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.bmbman.model.BonusBombNum;
import it.unibo.bmbman.model.BonusBombRange;
import it.unibo.bmbman.model.BonusLife;
import it.unibo.bmbman.model.BonusVelocity;
import it.unibo.bmbman.model.Door;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.EntityType;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.Key;
import it.unibo.bmbman.model.MalusFreeze;
import it.unibo.bmbman.model.MalusInvert;
import it.unibo.bmbman.model.MalusLife;
import it.unibo.bmbman.model.MalusSlow;
import it.unibo.bmbman.model.Monster;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.HeroView;
import it.unibo.bmbman.view.entities.MonsterView;
import it.unibo.bmbman.view.entities.PowerUpView;

/**
 * Used to load a level.
 */
public class LoadWorld {
    private static final int MOSTER_NUMBER = 5;
//    private static final int POWER_UP_NUMBER = 10;
    private final GameController gc;
    private final Terrain terrain ; 
    /**
     * Construct the level.
     * @param gc {@link GameController}
     */
    public LoadWorld(final GameController gc) {
        this.gc = gc;
        terrain = new Terrain();
    }
    /**
     * Loads all the entity.
     */
    public void loadEntity() {
        final Hero hero = new Hero();
        final HeroView heroView = new HeroView(hero.getPosition());
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 15; j++) {
            this.gc.addEntity(terrain.getEntity(i, j), terrain.getEntityView(terrain.getEntity(i, j)));
            }
        }
        
        List<Entity> mosterList = new ArrayList<>();
//        terrain.getTiles().stream().forEach(t -> System.out.println(t.getPosition()));
        terrain.getBlocks().stream().forEach((i) -> gc.addEntity(i, terrain.getEntityView(i)));
        

//        powerUpList.stream().forEach(i -> {
//            gc.addEntity(i, new PowerUpView(i.getPosition(), PowerUpType.BONUS_LIFE.toString()));
//            });
        loadPowerUp();
        IntStream.iterate(0, i -> i + 1).limit(MOSTER_NUMBER).forEach(i -> mosterList.add(new Monster(terrain.getFreeRandomPosition())));
        mosterList.forEach(i -> gc.addEntity(i, new MonsterView(i.getPosition(), new Dimension(48, 48))));
//        terrain.getTiles().forEach(t -> System.out.println(t.getPosition()));

        this.gc.addEntity(hero, heroView);
    }
    private void loadPowerUp() {

        Position position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new Door(), new PowerUpView(Terrain.DOOR_POSITION, PowerUpType.DOOR.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new Key(position), new PowerUpView(position, PowerUpType.KEY.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new BonusLife(position), new PowerUpView(position, PowerUpType.BONUS_LIFE.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new BonusBombNum(position), new PowerUpView(position, PowerUpType.BONUS_BOMB.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new BonusBombRange(position), new PowerUpView(position, PowerUpType.BONUS_RANGE.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new BonusVelocity(position), new PowerUpView(position, PowerUpType.BONUS_SPEED.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new MalusFreeze(position), new PowerUpView(position, PowerUpType.MALUS_FREEZE.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new MalusLife(position), new PowerUpView(position, PowerUpType.MALUS_LIFE.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new MalusSlow(position), new PowerUpView(position, PowerUpType.MALUS_SLOW.toString()));
        position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new MalusInvert(position), new PowerUpView(position, PowerUpType.MALUS_INVERT.toString()));
    }
}
