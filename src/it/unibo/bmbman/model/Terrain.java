package it.unibo.bmbman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.EntityView;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.entities.WallView;

/**
     * This class defines the playing field.
     *
     */
public class Terrain {
    private final List<List<Entity>> terrain = new ArrayList<>();
/**
 * 
 */
    public Terrain() {
    for (int i = 0; i < 18; i++) {
        List<Entity> col = new ArrayList<>();
        for (int j = 0; j < 13; j++) {
            col.add(new Tile(new Position(i * 50, j * 50), new Dimension(50, 50)));
            col = addWall(i, j, col);
        }
        this.terrain.add(col);
       }
    }
    /**
     * create wall in terrain.
     */
    private List<Entity> addWall(final int row, final int col,final  List<Entity> el) {
        if (row == 0 || col == 0 || row == 17 || col == 12) {
            el.set(col, new Wall(new Position(row*50, col*50), new Dimension(50, 50)));
            }
        return el;
        }
    /**
     * return a terrain element in a coordinate.
     * @param x the row
     * @param y the column
     * @return the (x,y) element in the matrix
     */
    public Entity getEntity(final int x, final int y) {
        return this.terrain.get(x).get(y);
    }
    /**
     * 
     * @param entity 
     * @return 
     */
    public EntityView getEntityView(final Entity entity) {
        switch(entity.getType()) {
        case TILE:
         return new TileView(entity.getPosition());
        case WALL:
         return new WallView(entity.getPosition());
        default:
            return new TileView(entity.getPosition());
        }
    }
}
