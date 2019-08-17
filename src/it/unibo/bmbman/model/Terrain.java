package it.unibo.bmbman.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.bmbman.model.entities.AbstractEntity;
import it.unibo.bmbman.model.entities.Block;
import it.unibo.bmbman.model.entities.Entity;
import it.unibo.bmbman.model.entities.Tile;
import it.unibo.bmbman.model.entities.Wall;
import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.EntityType;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.AbstractEntityView;
import it.unibo.bmbman.view.entities.BlockView;
import it.unibo.bmbman.view.entities.EntityView;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.entities.WallView;
import it.unibo.bmbman.view.utilities.ScreenToolUtils;

/**
     * This class defines the playing field.
     *
     */
public class Terrain {
    /**
     * the cell dimension.
     */
    public static final int  CELL_DIMENSION = 50 ;
    /**
     * number of rows in terrain.
     */
    public static final int TERRAIN_ROWS = 15;
    /**
     * number of columns in terrain.
     */
    public static final int TERRAIN_COLUMNS = 19;
    /**
     * the player start position.
     */
    public static final Position PLAYER_POSITION = new Position(1 * CELL_DIMENSION*AbstractEntity.SCALE, 1 * CELL_DIMENSION*AbstractEntity.SCALE);
    /**
     * the door position.
     */
    public static final Position DOOR_POSITION = new Position((TERRAIN_COLUMNS - 2) * CELL_DIMENSION*AbstractEntity.SCALE, (TERRAIN_ROWS - 2) * CELL_DIMENSION*AbstractEntity.SCALE);

    /**
     * Terrain's width.
     */
    public static final int TERRAIN_WIDTH = TERRAIN_COLUMNS * CELL_DIMENSION*AbstractEntity.SCALE;
    /**
     * Terrain's height.
     */
    public static final int TERRAIN_HEGHT = TERRAIN_ROWS * CELL_DIMENSION*AbstractEntity.SCALE;

    private static final Position PLAYER_POSITION_RIGHT = new Position(2 * CELL_DIMENSION*AbstractEntity.SCALE, 1 * CELL_DIMENSION*AbstractEntity.SCALE);
    private static final Position PLAYER_POSITION_DOWN = new Position(1 * CELL_DIMENSION*AbstractEntity.SCALE, 2 * CELL_DIMENSION*AbstractEntity.SCALE);
    private int blockNumber;
    private final List<List<Entity>> terrain = new ArrayList<>();
    private List<Entity> blockList = new ArrayList<>();
    private final List<Position> freePosition;
    private final List<Position> blockPowerUpPosition;

/**
 * 
 * @param blocknumber
 */
    public Terrain(final int blocknumber) {
    for (int i = 0; i < TERRAIN_COLUMNS; i++) {
        List<Entity> col = new ArrayList<>();
        for (int j = 0; j < TERRAIN_ROWS; j++) {
            col.add(new Tile(new Position(i * CELL_DIMENSION, j * CELL_DIMENSION), new Dimension(CELL_DIMENSION, CELL_DIMENSION)));
            col = addBorderWall(i, j, col);
        }
        this.terrain.add(col);
       }
    for(int i=0;i<TERRAIN_COLUMNS;i=i+2) {
        addWall(terrain.get(i),i);
    }
    this.blockNumber = blocknumber;
    addBlock();
    freePosition = getFreeTiles().stream().map(t -> t.getPosition()).collect(Collectors.toList());
    blockPowerUpPosition = getBlockPosition().stream().distinct().collect(Collectors.toList());
    }
    /**
     * create wall in terrain.
     */
    private List<Entity> addBorderWall(final int column, final int row, final  List<Entity> entityList) {
        if (row == 0 || column == 0 || column == TERRAIN_COLUMNS -1 || row == TERRAIN_ROWS -1 ) {
            entityList.set(row, new Wall(new Position(column * CELL_DIMENSION, row * CELL_DIMENSION), new Dimension(CELL_DIMENSION,CELL_DIMENSION)));
            }
        return entityList;
        }
    /**
     * 
     * @param entityList
     */
    private void addWall(final List<Entity> entityList,int col) {
        for(int i=0;i<TERRAIN_ROWS;i=i+2) {
            entityList.set(i, new Wall(new Position(col*CELL_DIMENSION,i*CELL_DIMENSION), new Dimension(CELL_DIMENSION,CELL_DIMENSION)));
        }
//         IntStream.iterate(0, i -> i + 2)
//                  .limit(TERRAIN_COLUMNS/2)
//                  .forEach((i) -> entityList.get().set(i, new Wall(entityList.get(i).getPosition(), new Dimension(CELL_DIMENSION,CELL_DIMENSION))));
//         entityList.stream().filter(i->i.getType()== EntityType.WALL).forEach(k->System.out.println(k.getPosition()+"wall pos"));
    }
    /**
     * 
     * @param li
     */
    private void addBlock() {
//        blockList.add(new Block(new Position(PLAYER_POSITION_RIGHT.getX() + CELL_DIMENSION, PLAYER_POSITION_RIGHT.getY()), new Dimension(CELL_DIMENSION, CELL_DIMENSION)));
//        blockList.add(new Block(new Position(PLAYER_POSITION_DOWN.getX(), PLAYER_POSITION_DOWN.getY() + CELL_DIMENSION), new Dimension(CELL_DIMENSION, CELL_DIMENSION)));
        IntStream.iterate(0, i -> i + 1)
                 .limit(blockNumber)
                 .forEach((i) -> blockList.add(new Block(new Position(new Random().nextInt(TERRAIN_COLUMNS - 1) * CELL_DIMENSION,
                         new Random().nextInt(TERRAIN_ROWS - 1) * CELL_DIMENSION), new Dimension(CELL_DIMENSION, CELL_DIMENSION))));
//        System.out.println(blockList.size()+"STAMPO LA SIZEEEE");
//blockList.forEach(i-> System.out.println(i.getPosition());
        checkBlock();
//        System.out.println(blockList.size()+"STAMPO LA SIZEEEE");
    }
    private void checkBlock() {
        this.blockList=this.blockList.stream()
                .filter(s -> !s.getPosition().equals(PLAYER_POSITION)
                        && !s.getPosition().equals(PLAYER_POSITION_RIGHT)
                        && !s.getPosition().equals(PLAYER_POSITION_DOWN)
                        && !s.getPosition().equals(DOOR_POSITION))
                 .collect(Collectors.toList());
//        System.out.println(blockList.size()+"STAMPO LA SIZEEEE in checkblock");
        this.blockList=this.blockList.stream().filter(s-> !getWallsPosition().contains(s.getPosition())).collect(Collectors.toList());
//        System.out.println();
//                  .forEach((e) -> blockList.remove(blockList.indexOf(e)));
        
//        List<Entity> li = blockList.stream().filter(i -> getWallsPosition().contains(i.getPosition())).collect(Collectors.toList());
//        System.out.println(blockList.get(6).getPosition()+"posblockli");
//        blockList.forEach(i->System.out.println(i.getPosition()));
//        System.out.println(li.size());
//        this.blockList.removeAll(li);

//        System.out.println(blockList.size()+"STAMPO LA SIZEEEEaaa");
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
        return this.getTiles().stream().filter(i -> !i.getPosition().equals(PLAYER_POSITION) 
                                          && !i.getPosition().equals(PLAYER_POSITION_RIGHT)
                                          && !i.getPosition().equals(PLAYER_POSITION_DOWN)
                                          && !i.getPosition().equals(DOOR_POSITION)
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
//        System.out.println(walls.size()+"wall size");
        return walls;
        
    }
    private List<Position> getWallsPosition() {
//        getWalls().forEach(i->System.out.println(i.getPosition()+"posizioni muri"));
        return getWalls().stream().map(i -> i.getPosition()).collect(Collectors.toList());
        
    }
    /**
     * 
     * @return
     */
    private List<Position> getBlockPosition() {
        return getBlocks().stream().map(b -> b.getPosition()).collect(Collectors.toList());
    }
    /**
     * 
     * @return
     */
    public Position getFreeRandomPosition() {
        final int randomIndex = new Random().nextInt(freePosition.size()); 
        Position pos = new Position(freePosition.get(randomIndex).getX()/AbstractEntity.SCALE,freePosition.get(randomIndex).getY()/AbstractEntity.SCALE);
        freePosition.remove(randomIndex);
        return pos;
    }
    public Position getRandomBlockPosition() {
        final int randomIndex = new Random().nextInt(blockPowerUpPosition.size()); 
        Position pos = new Position(blockPowerUpPosition.get(randomIndex));

        blockPowerUpPosition.remove(randomIndex);
        return pos;
    }

}
