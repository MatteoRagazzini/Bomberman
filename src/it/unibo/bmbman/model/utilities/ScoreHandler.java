package it.unibo.bmbman.model.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * It keeps track of best {@link PlayerScore}.
 *
 */
public final class ScoreHandler {
    private static final String FILE_NAME = "score.txt";
    private static List<PlayerScore> data = new ArrayList<>();

    private ScoreHandler() {
        super();
    }
    /**
     * Write object into file score.txt.
     * @param list of {@link PlayerScore}
     */
    private static void save(final List<PlayerScore> list) {
        try (
          final ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE_NAME))
        ) {
            System.out.println("Write object");
            o.writeObject(list);
            o.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write on " + FILE_NAME);
        }

    }
    /**
     * Read object from score.txt.
     */
    private static List<PlayerScore> read() {
        try (
          final ObjectInputStream br = new ObjectInputStream((new FileInputStream(FILE_NAME)))
        ) {
            System.out.println("Read object");
            data = (List<PlayerScore>) br.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new IllegalArgumentException("File doesn't exist");
        }
        return data;
    }
    /**
     * Get a list of {@link PlayerScore}.
     * @return data
     */
    public static List<PlayerScore> getData() {
        return data;
    }
    /**
     * If score.txt already exists, the method reads the content and invokes check method; 
     * then it adds the given PlayerScore into data list and write the list into file.
     * @param ps PlayerScore
     */
    public static void checkAndReadWrite(final PlayerScore ps) {
        if (new File(FILE_NAME).exists()) {
             read();
             check(ps);
        }
        data.add(ps);
        save(data);
    }
    /**
     * Check if the given PlayerScore already has won a game; in this case, 
     * update the score if it's better.
     * @param PlayerScore to add or update if it's necessary. 
     */
    private static void check(final PlayerScore psToAdd) {
        data.stream()
            .filter(ps -> ps.getName().equals(psToAdd.getName()) && psToAdd.getScore() > ps.getScore())
            .findAny().ifPresent(ps -> ps.setScore(psToAdd.getScore()));
    }
}
