package it.unibo.bmbman.model.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

/**
 * 
 * It keeps track of best {@link PlayerScore}.
 *
 */
public final class ScoreHandler {
    /**
     * 
     */
    private static final String FILE_NAME = "score.txt";
    private static TreeSet<PlayerScore> data = new TreeSet<>();
/**
 * 
 * @param list 
 * @param p
 * @throws Exception
 */
    private ScoreHandler() {
        super();
    }
    /**
     * Write TreeSet on file score.txt.
     * @param list of score, game time and name of the player
     * @throws Exception 
     */
    private static void save(TreeSet<PlayerScore> t) {
        try (
          final ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE_NAME))
        ) {
            System.out.println("Write object");
            o.writeObject(t);
            o.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write on " + FILE_NAME);
        }

    }
    /**
     * Read data from score.txt.
     * @throws Exception
     */
    private static TreeSet<PlayerScore> read() {
        try (
          final ObjectInputStream br = new ObjectInputStream((new FileInputStream(FILE_NAME)))
        ) {
            System.out.println("Read object");
            data = (TreeSet<PlayerScore>) br.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new IllegalArgumentException("File doesn't exist");
        }
        return data;
    }
    /**
     * Get data that are into score.txt.
     * @return data
     */
    public static TreeSet<PlayerScore> getData() {
        return data;
    }
    
    public static void checkAndReadWrite(PlayerScore ps) {
        if(new File(FILE_NAME).exists()) {
             read();
        }
        check(ps);
        data.add(ps);
        save(data);
    }
    
    private static void check(PlayerScore psToAdd) {
        data.stream()
            .filter(ps->ps.getName().equals(psToAdd.getName()) && psToAdd.getScore() > ps.getScore())
            .findAny().ifPresent(ps->ps.setScore(psToAdd.getScore()));
    }
}
