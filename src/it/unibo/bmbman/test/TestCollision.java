package it.unibo.bmbman.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.collision.CollisionImpl;
import it.unibo.bmbman.model.collision.EntityCollisionManager;
import it.unibo.bmbman.model.collision.EntityCollisionManagerImpl;
import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.entities.HeroImpl;
import it.unibo.bmbman.model.entities.Monster;
import it.unibo.bmbman.model.entities.Wall;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;

/**
 * JUnit Test for  Collision Manager and entityController.
 *
 */
public class TestCollision {
    private static final int HERO_LIVES = 3;
    private static final Position MONSTER_POSITION = new Position(60, 70);
    private static final Position WALL_POSITION = new Position(100, 50);
    private static final Position NEAR_WALL_POSITION = new Position(WALL_POSITION.getX() - Terrain.CELL_DIMENSION / 2,
                                                                    WALL_POSITION.getY() - Terrain.CELL_DIMENSION / 2);
    private final Hero hero = new HeroImpl();
    private final Monster monster = new Monster(MONSTER_POSITION);
    private final Wall wall = new Wall(WALL_POSITION, new Dimension(Terrain.CELL_DIMENSION, Terrain.CELL_DIMENSION));
    private final EntityCollisionManager heroMng = new EntityCollisionManagerImpl(hero.getCollisionComponent());
    /**
     * Used to test wall Collision.
     * Hero doesn't lose lives when he collide with wall
     */
    @Test
    public void testWallCollision() {
        assertFalse(heroMng.checkCollision(wall, hero.getCollisionComponent().getHitbox()));
        assertEquals(HERO_LIVES, hero.getLives());
        hero.setPosition(WALL_POSITION);
        assertTrue(heroMng.checkCollision(wall, hero.getCollisionComponent().getHitbox()));
        hero.onCollision(new CollisionImpl(wall, WALL_POSITION));
        assertEquals(HERO_LIVES, hero.getLives());
        hero.setPosition(NEAR_WALL_POSITION);
        assertTrue(heroMng.checkCollision(wall, hero.getCollisionComponent().getHitbox()));
        assertEquals(HERO_LIVES, hero.getLives());
    }
    /**
     * Used to test Monster collision.
     * Hero lose a life when he collide with monster
     */
    @Test
    public void testMonsterCollision() {
        hero.setPosition(Terrain.PLAYER_POSITION);
        //assertFalse(heroMng.checkCollision(monster, hero.getCollisionComponent().getHitbox()));
        assertEquals(HERO_LIVES, hero.getLives());
    }
}
