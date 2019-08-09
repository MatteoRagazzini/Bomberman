package it.unibo.bmbman.model.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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
    private static List<PlayerScore> data = new LinkedList<>();
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
    private static void save(List<PlayerScore> t) {
        System.out.println("SAVE");
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            t.sort((p1, p2) -> p2.getScore() - p1.getScore());
            System.out.println("t : " + t);
            t.forEach(p -> {
                try {
                    o.writeObject(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write on " + FILE_NAME);
        }

    }
    /**
     * Read data from score.txt.
     * @throws Exception
     */
    private static List<PlayerScore> read() {
        System.out.println("READ");
        try (ObjectInputStream br = new ObjectInputStream((new FileInputStream(FILE_NAME)))) {
            while (br.available() > 0) {
                data.add((PlayerScore) br.readObject());
            }
//           data = (TreeSet<PlayerScore>) br.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new IllegalArgumentException("File doesn't exist");
        }
        data.sort((p1,p2) -> p2.getScore() - p1.getScore());
        return data;
    }
    /**
     * Get data that are into score.txt.
     * @return data
     */
    public static List<PlayerScore> getData() {
        return read();
    }
    /**
     * .
     * @param ps .
     */
    public static void checkAndReadWrite(final PlayerScore ps) {
        System.out.println("CHECKRW");
        System.out.println(ps);
        if (new File(FILE_NAME).exists()) {
            read();
        }
        check(ps);
        data.add(ps);
        save(data);
    }

    private static void check(final PlayerScore psToAdd) {
        data.stream()
        .filter(ps -> ps.getName().equals(psToAdd.getName()) && psToAdd.getScore() > ps.getScore())
        .findAny().ifPresent(ps -> ps.setScore(psToAdd.getScore()));
    }
}
