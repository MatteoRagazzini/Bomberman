package it.unibo.bmbman.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import it.unibo.bmbman.model.LevelImpl;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.TerrainFactory;
import it.unibo.bmbman.model.TerrainFactoryImpl;
/**
 * Used to test terrain.
 *
 */
public class TestTerrain {
    private final TerrainFactory terrainFactory = new TerrainFactoryImpl();
    private LevelImpl level = new LevelImpl();
    private Terrain terrain;
    /**
     * Attests that there is a correct number of blocks.
     */
    @Test
    public void testNumberBlock() {
        IntStream.iterate(0, i -> i + 1).limit(LevelImpl.LEVEL_MAX).forEach(k -> {
            terrain = terrainFactory.create(level.getBlocksNumber());
            assertTrue(terrain.getBlocks().size() <= level.getBlocksNumber());
            level.levelUp();
        });
    }

}
