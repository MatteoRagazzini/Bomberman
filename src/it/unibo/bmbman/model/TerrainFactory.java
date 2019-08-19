package it.unibo.bmbman.model;

public interface TerrainFactory {
    /**
     * 
     * @param level
     * @return
     */
    Terrain create(int blocksnumber);

}
