package it.unibo.bmbman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.recompile;

import it.unibo.bmbman.controller.PowerUpType;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.BlockView;
import it.unibo.bmbman.view.entities.EntityView;
import it.unibo.bmbman.view.entities.PowerUpView;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.entities.WallView;

/**
     * This class defines the playing field.
     *
     */
public class Terrain {
    /**
     * the cell dimension.
     */
    public static final int CELL_DIMENSION = 50;

    /**
     * the player start position.
     */
    public static final Position PLAYER_POSITION = new Position(1 * CELL_DIMENSION, 1 * CELL_DIMENSION);
    /**
     * the door position.
     */
    public static final Position DOOR_POSITION = new Position(17 * CELL_DIMENSION, 13 * CELL_DIMENSION);
    private static final int TERRAIN_ROWS = 15;
    private static final int TERRAIN_COLUMNS = 19;
    private static final Position PLAYER_POSITION_RIGHT = new Position(2 * CELL_DIMENSION, 1 * CELL_DIMENSION);
    private static final Position PLAYER_POSITION_DOWN = new Position(1 * CELL_DIMENSION, 2 * CELL_DIMENSION);
    private static final int BLOCK_NUMBER = 200;
    private final List<List<Entity>> terrain = new ArrayList<>();
    private final List<Entity> blockList = new ArrayList<>();
    private final List<Position> freePosition;

/**
 * 
 */
    public Terrain() {

    for (int i = 0; i < 19; i++) {
        List<Entity> col = new ArrayList<>();
        for (int j = 0; j < 15; j++) {
            col.add(new Tile(new Position(i * CELL_DIMENSION, j * CELL_DIMENSION), new Dimension(CELL_DIMENSION, CELL_DIMENSION)));
            col = addBorderWall(i, j, col);
        }
        if(i%2==0 ) {addWall(col);}
        this.terrain.add(col);
       }
    
    addBlock();
    freePosition = getFreeTiles().stream().map(t -> t.getPosition()).collect(Collectors.toList());
    }
    /**
     * create wall in terrain.
     */
    private List<Entity> addBorderWall(final int row, final int col,final  List<Entity> entityList) {
        if (row == 0 || col == 0 || row == 18 || col == 14) {
            entityList.set(col, new Wall(new Position(row*CELL_DIMENSION, col*CELL_DIMENSION), new Dimension(CELL_DIMENSION, CELL_DIMENSION)));
            }
        return entityList;
        }
    /**
     * 
     * @param entityList
     */
    private void addWall(final List<Entity> entityList) {
         IntStream.iterate(0, i -> i + 2)
                  .limit(entityList.size() / 2)
                  .forEach((i) -> entityList.set(i, new Wall(entityList.get(i).getPosition(), new Dimension(CELL_DIMENSION, CELL_DIMENSION))));
    }
    /**
     * 
     * @param li
     */
    private void addBlock() {
        IntStream.iterate(0, i -> i + 1)
        .limit(BLOCK_NUMBER)
        .forEach((i) -> blockList.add(new Block(new Position(new Random().nextInt(18) * CELL_DIMENSION, new Random().nextInt(14) * CELL_DIMENSION), new Dimension(CELL_DIMENSION, CELL_DIMENSION))));
        checkBlock();
    }
    private void checkBlock() {
        this.blockList.stream()
                 .filter(s -> s.getPosition().equals(PLAYER_POSITION)
                         || s.getPosition().equals(PLAYER_POSITION_RIGHT)
                         || s.getPosition().equals(PLAYER_POSITION_DOWN)
                         || s.getPosition().equals(DOOR_POSITION))
                  .collect(Collectors.toList())
                  .forEach((e) -> blockList.remove(blockList.indexOf(e)));
        List<Entity> li = blockList.stream().filter(i -> getWallsPosition().contains(i.getPosition())).collect(Collectors.toList());
        getBlocks().removeAll(li);
    }
    /**
     * get the block position list.
     * @return block position list
     */
    public List<Entity> getBlocks() {
        return this.blockList;
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
     *  .
     * @return  aa
     */
    public List<Entity> getTiles() {
        final List<Entity> tiles = new ArrayList<>();
        this.terrain.stream()
                    .forEach(e -> e.stream()
                                   .filter(s -> s.getType() == EntityType.TILE)
                                   .forEach(k -> tiles.add(k)));
        return tiles;
    }
    /**
     * 
     * @return
     */
    public List<Entity> getFreeTiles() { 
        return this.getTiles().stream().filter(i -> i.getPosition() != PLAYER_POSITION 
                                          && i.getPosition() != PLAYER_POSITION_RIGHT 
                                          && i.getPosition() != PLAYER_POSITION_DOWN 
                                          && i.getPosition() != DOOR_POSITION
                                          && !getBlockPosition().contains(i.getPosition()))
                                .collect(Collectors.toList());

    }
    /**
     * 
     * @return
     */
    private List<Entity> getWalls() {
        final List<Entity> walls = new ArrayList<>();
        this.terrain.stream()
                    .forEach(e -> e.stream()
                                   .filter(s -> s.getType() == EntityType.WALL)
                                   .forEach(k -> walls.add(k)));
        return walls;
    }
    private List<Position> getWallsPosition() {
        return getWalls().stream().map(i->i.getPosition()).collect(Collectors.toList());
    }
    
    private List<Position> getBlockPosition() {
        return getBlocks().stream().map(b -> b.getPosition()).collect(Collectors.toList());
    }
//    
    public Position getFreeRandomPosition() {
        final int randomIndex = new Random().nextInt(freePosition.size()); 
        Position pos = new Position(freePosition.get(randomIndex));
        freePosition.remove(randomIndex);
        return pos;
        
    }
    /**
     * used to associate model object to the relative view.
     * @param entity the entity that you what know the sprite 
     * @return the sprite of the entity in input
     */
    public EntityView getEntityView(final Entity entity) {
        switch (entity.getType()) {
        case TILE:
         return new TileView(entity.getPosition());
        case WALL:
         return new WallView(entity.getPosition());
        case BLOCK:
            return new BlockView(entity.getPosition());
        default:
            return new TileView(entity.getPosition());

        }
    }
}
