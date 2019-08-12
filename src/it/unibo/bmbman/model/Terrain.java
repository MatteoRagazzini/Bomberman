package it.unibo.bmbman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sun.org.apache.regexp.internal.recompile;

import it.unibo.bmbman.model.utilities.Dimension;
import it.unibo.bmbman.model.utilities.Position;
import it.unibo.bmbman.view.entities.BlockView;
import it.unibo.bmbman.view.entities.EntityView;
import it.unibo.bmbman.view.entities.TileView;
import it.unibo.bmbman.view.entities.WallView;

/**
     * This class defines the playing field.
     *
     */
public class Terrain {
    private static final int BLOCK_NUMBER = 150;
    private final List<List<Entity>> terrain = new ArrayList<>();
    private final List<Entity> blockList = new ArrayList<>();
    private final Random random = new Random();
/**
 * 
 */
    public Terrain() {

    for (int i = 0; i < 19; i++) {
        List<Entity> col = new ArrayList<>();
        for (int j = 0; j < 15; j++) {
            col.add(new Tile(new Position(i * 50, j * 50), new Dimension(50, 50)));
            col = addBorderWall(i, j, col);
        }
        if(i%2==0 ) {addWall(col);}
        this.terrain.add(col);
       }
    addBlock(blockList);
    checkBlock(blockList);
    addDoor();
    }
    /**
     * create wall in terrain.
     */
    private List<Entity> addBorderWall(final int row, final int col,final  List<Entity> entityList) {
        if (row == 0 || col == 0 || row == 18 || col == 14) {
            entityList.set(col, new Wall(new Position(row*50, col*50), new Dimension(50, 50)));
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
                  .forEach((i) -> entityList.set(i, new Wall(entityList.get(i).getPosition(), new Dimension(50,50))));
    }
    /**
     * 
     * @param li
     */
    private void addBlock(final List<Entity> blockList) {
        IntStream.iterate(0, i -> i + 1)
        .limit(BLOCK_NUMBER)
        .forEach((i) -> blockList.add(new Block(new Position(random.nextInt(18)*50, random.nextInt(14)*50), new Dimension(50,50))));
        System.out.println(this.blockList.size());
    }
    private void checkBlock(final List<Entity> blocklist) {
        blocklist.stream()
                 .filter(s -> s.getPosition().equals(new Position(50, 50))
                         || s.getPosition().equals(new Position(100, 50))
                         || s.getPosition().equals(new Position(50, 100))
                         || s.getPosition().equals(new Position(17*50,13*50)))
                  .collect(Collectors.toList())
                  .forEach((e) -> blocklist.remove(blockList.indexOf(e)));
//        List<Entity> li = new ArrayList<>();
//        this.terrain.stream().forEach((e) -> e.stream().filter(i -> i.getType().equals(EntityType.WALL)).forEach(s -> li.add(s)));
//        blocklist.stream()
//                 .filter(s -> s.getPosition().equals(li.stream().forEach(i -> i.getPosition())))
//                 .collect(Collectors.toList())
//                 .forEach(e -> blocklist.remove(blocklist.indexOf(e)));
//        
//        blocklist.stream()
//                 .filter(s -> s.getPosition().equals(this.terrain.stream()
//                                                                 .forEach(e -> e.stream()
//                                                                                .filter(i -> i.getType() == EntityType.WALL)
//                                                                                .collect(Collectors.toList())
//                                                                                .forEach(k -> k.getPosition()))))
//                .collect(Collectors.toList())
//                .forEach((e) -> blocklist.remove(blocklist.indexOf(e)));
        System.out.println(this.blockList.size());
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
     * get the block position list.
     * @return block position list
     */
    public List<Entity> getBlocks() {
        return this.blockList;
    }
    private void addDoor() {
        this.terrain.get(17).set(13, new Door(new Position(18*50, 14*50)));
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
                                   .forEach(k -> tiles.add(k))
                            );
        return tiles;
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
