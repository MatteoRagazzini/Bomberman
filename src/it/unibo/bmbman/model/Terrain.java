package it.unibo.bmbman.model;



import java.util.List;

import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.utilities.Position;

public interface Terrain {
    public List<Entity> getTiles();
    public List<Entity> getFreeTiles();
    public List<Entity> getBlocks();
    public Entity getEntity(final int x, final int y);
    public Position getFreeRandomPosition();
    public Position getRandomBlockPosition();

}
