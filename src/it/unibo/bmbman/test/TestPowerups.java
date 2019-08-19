package it.unibo.bmbman.test;

import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.entities.Hero;
import it.unibo.bmbman.model.entities.HeroImpl;
import it.unibo.bmbman.model.utilities.Position;

/**
 * Class to test power-ups behavior.
 */
public class TestPowerups {
    /**
     * 
     */
    private final Hero hero = new HeroImpl();
    private final static Position HERO_POSITION = new Position(Terrain.PLAYER_POSITION.getX(), Terrain.PLAYER_POSITION.getY());
    
    @Test
    public void testPowerUpEffetct() {
        
    }
}
