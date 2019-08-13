package it.unibo.bmbman.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import it.unibo.bmbman.model.BonusBombNum;
import it.unibo.bmbman.model.BonusBombRange;
import it.unibo.bmbman.model.BonusLife;
import it.unibo.bmbman.model.BonusVelocity;
import it.unibo.bmbman.model.Door;
import it.unibo.bmbman.model.Entity;
import it.unibo.bmbman.model.Hero;
import it.unibo.bmbman.model.Key;
import it.unibo.bmbman.model.Level;
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
    private static final int MONSTER_SPRITE_DIMENSION = 48;
    private final GameController gc;
    private final Terrain terrain;
    private final Level level;
    /**
     * Construct the level.
     * @param gc {@link GameController}
     */
    public LoadWorld(final GameController gc) {
        this.gc = gc;
        this.level = gc.getLevel();
        this.terrain = new Terrain(level.getBlocksNumber());

    }
    /**
     * Loads all the entity.
     */
    public void loadEntity() {
        final Hero hero = new Hero();
        final HeroView heroView = new HeroView(hero.getPosition());
        final List<Entity> mosterList = new ArrayList<>();
        for (int i = 0; i < Terrain.TERRAIN_COLUMNS; i++) {
            for (int j = 0; j < Terrain.TERRAIN_ROWS; j++) {
                this.gc.addEntity(terrain.getEntity(i, j), terrain.getEntityView(terrain.getEntity(i, j)));
            }
        }
        terrain.getBlocks().stream().forEach((i) -> gc.addEntity(i, terrain.getEntityView(i)));
        loadPowerUp();
        System.out.println(level.getLevel());
        IntStream.iterate(0, i -> i + 1).limit(level.getMonsterNumber()).forEach(i -> mosterList.add(new Monster(terrain.getFreeRandomPosition())));
        mosterList.forEach(i -> gc.addEntity(i, new MonsterView(i.getPosition(), new Dimension(MONSTER_SPRITE_DIMENSION, MONSTER_SPRITE_DIMENSION))));
        this.gc.addEntity(hero, heroView);
    }
    private void loadPowerUp() {
        this.gc.addEntity(new Door(), new PowerUpView(Terrain.DOOR_POSITION, PowerUpType.DOOR.toString()));
        Position position = terrain.getRandomBlockPosition();
        this.gc.addEntity(new Key(position), new PowerUpView(position, PowerUpType.KEY.toString()));
        System.out.println("Key: " + position);
        for (int i = 0; i < level.getBonusLifeNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new BonusLife(position), new PowerUpView(position, PowerUpType.BONUS_LIFE.toString()));
            //System.out.println(position+"bonus life");
        }
        for (int i = 0; i < level.getBonusBombNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new BonusBombNum(position), new PowerUpView(position, PowerUpType.BONUS_BOMB.toString()));
            //System.out.println(position+"bonus bomb");
        }
        for (int i = 0; i < level.getBonusRangeNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new BonusBombRange(position), new PowerUpView(position, PowerUpType.BONUS_RANGE.toString()));
            //System.out.println(position+"bonus range");
        }
        for (int i = 0; i < level.getBonusVelocityNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new BonusVelocity(position), new PowerUpView(position, PowerUpType.BONUS_SPEED.toString()));
            //System.out.println(position+"bonus speed");
        }
        for (int i = 0; i < level.getMalusFreezeNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new MalusFreeze(position), new PowerUpView(position, PowerUpType.MALUS_FREEZE.toString()));
            //System.out.println(position+"malus freeze");
        }
        for (int i = 0; i < level.getMalusLifeNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new MalusLife(position), new PowerUpView(position, PowerUpType.MALUS_LIFE.toString()));
            //System.out.println(position+"malus life");
        }
        for (int i = 0; i < level.getMalusSlowNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new MalusSlow(position), new PowerUpView(position, PowerUpType.MALUS_SLOW.toString()));
            //System.out.println(position+"malus slow");
        }
        for (int i = 0; i < level.getMalusInvertNumber(); i++) {
            position = terrain.getRandomBlockPosition();
            this.gc.addEntity(new MalusInvert(position), new PowerUpView(position, PowerUpType.MALUS_INVERT.toString()));
            //System.out.println(position+"malus invert");
        }
    }
}
