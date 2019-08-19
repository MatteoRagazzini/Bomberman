package it.unibo.bmbman.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Level;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import it.unibo.bmbman.model.LevelImpl;
import it.unibo.bmbman.model.Terrain;
import it.unibo.bmbman.model.TerrainFactory;
import it.unibo.bmbman.model.TerrainFactoryImpl;

public class TestTerrain {
    private final TerrainFactory terrainFactory = new TerrainFactoryImpl();
    private LevelImpl level = new LevelImpl();
    private Terrain terrain;
    @Test
    public void testNumberBlock() {
        
            for(int i=0; i<3;i++) {
                System.out.println(level.getBlocksNumber());
                System.out.println(level.getLevel());

            terrain = terrainFactory.create(level.getBlocksNumber());
            System.out.println(terrain.getBlocks().size());
            assertTrue(terrain.getBlocks().size() <= level.getBlocksNumber());
            level.levelUp();
            }

    }
}
