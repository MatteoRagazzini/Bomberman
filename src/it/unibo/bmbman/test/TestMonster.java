//package it.unibo.bmbman.test;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//import org.junit.jupiter.api.Test;
//
//import it.unibo.bmbman.controller.SoundsController;
//import it.unibo.bmbman.model.Terrain;
//import it.unibo.bmbman.model.collision.CollisionImpl;
//import it.unibo.bmbman.model.entities.Hero;
//import it.unibo.bmbman.model.entities.HeroImpl;
//import it.unibo.bmbman.model.entities.Monster;
//import it.unibo.bmbman.model.entities.powerUp.Door;
//import it.unibo.bmbman.model.entities.powerUp.Key;
//import it.unibo.bmbman.model.utilities.Direction;
//import it.unibo.bmbman.model.utilities.Position;
//import it.unibo.bmbman.model.utilities.Velocity;
//
//public class TestMonster {
//
//    private final Monster monster = new Monster(new Position(150, 50));
//    /**
//     * Test hero's position.
//     */
//    @Test
//    public void testHeroMovement() {
//        /*
//         * Test initial hero state.
//         */
//        assertEquals(monster.getDirection(),);
//        /*
//         * Test of right movement of hero 
//         */
//        final Position newRightPosition = new Position(Terrain.PLAYER_POSITION.getX() + Velocity.SPEED, Terrain.PLAYER_POSITION.getY());
//        hero.setDirection(Direction.RIGHT);
//        hero.update();
//        assertEquals(newRightPosition, hero.getPosition());
//        //Move hero in his initial position
//        hero.setPosition(Terrain.PLAYER_POSITION);
//        /*
//         * Test of down movement
//         */
//        final Position newDownPosition = new Position(Terrain.PLAYER_POSITION.getX(), Terrain.PLAYER_POSITION.getY() + Velocity.SPEED);
//        hero.setDirection(Direction.DOWN);
//        hero.update();
//        assertEquals(newDownPosition, hero.getPosition());
//        /*
//         * Test of left movement
//         */
//        hero.setPosition(Terrain.PLAYER_POSITION);
//        final Position newLeftPosition = new Position(Terrain.PLAYER_POSITION.getX() - Velocity.SPEED, Terrain.PLAYER_POSITION.getY());
//        hero.setDirection(Direction.LEFT);
//        hero.update();
//        assertEquals(newLeftPosition, hero.getPosition());
//        /*
//         * Test of up movement
//         */
//        hero.setPosition(Terrain.PLAYER_POSITION);
//        final Position newUpPosition = new Position(Terrain.PLAYER_POSITION.getX(), Terrain.PLAYER_POSITION.getY() - Velocity.SPEED);
//        hero.setDirection(Direction.UP);
//        hero.update();
//        assertEquals(newUpPosition, hero.getPosition());
//        /*
//         * Test multiple movement
//         */
//        hero.setPosition(Terrain.PLAYER_POSITION);
//        final Position newPosition = POSITION;
//        hero.setDirection(Direction.RIGHT);
//        hero.update();
//        hero.update();
//        hero.setDirection(Direction.DOWN);
//        hero.update();
//        hero.update();
//        hero.setDirection(Direction.RIGHT);
//        hero.update();
//        assertEquals(newPosition, hero.getPosition());
//    }
//    /**
//     * Test hero pick up Key and Win.
//     */
//    @Test
//    public void testWin() {
//        final Key key = new Key(POSITION);
//        final SoundsController s = new SoundsController();
//        s.setEffectsOff();
//        assertFalse(hero.hasKey());
//        assertFalse(hero.hasWon());
//        key.onCollision(new CollisionImpl(hero, POSITION));
//        assertTrue(hero.hasKey());
//        assertFalse(hero.hasWon());
//        final Door door = new Door();
//        door.onCollision(new CollisionImpl(hero, Terrain.DOOR_POSITION));
//        assertTrue(hero.hasWon());
//    }
//
//}
