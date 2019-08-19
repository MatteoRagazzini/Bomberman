package it.unibo.bmbman.model;
/**
 * used to generate terrains.
 */
public interface TerrainFactory {
    /**
     * used to generate a terrain.
     * @param blocksnumber number of blocks in the level
     * @return a terrain 
     */
    Terrain create(int blocksnumber);
}
