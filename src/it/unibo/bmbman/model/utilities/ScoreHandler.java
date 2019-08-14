package it.unibo.bmbman.model.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * It keeps track of best {@link PlayerScore}.
 */
public final class ScoreHandler {
    private static final String FILE_NAME = "score.txt";
    private static List<PlayerScore> data = new ArrayList<>();
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
    private static void save(final List<PlayerScore> t) {
        System.out.println("SAVE");
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            o.writeObject(t);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write on " + FILE_NAME);
        }

    }
    /**
     * Read data from score.txt.
     * @throws Exception
     */
    private static void read() {
        System.out.println("READ");
        try (ObjectInputStream br = new ObjectInputStream((new FileInputStream(FILE_NAME)))) {
            data = (List<PlayerScore>) br.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new IllegalArgumentException("File doesn't exist");
        }
        data.sort((p1, p2) -> p1.compareTo(p2)); 
    }
    /**
     * Get data that are into score.txt.
     * @return data
     */
    public static List<PlayerScore> getData() {
        if (new File(FILE_NAME).exists()) {
            read();
        }
        return data;
    }
    /**
     * @param level 
     * @param ps 
     * @param playerName 
     * @param time 
     */
    public static void checkAndReadWrite(final int level, final PlayerScore ps, final String playerName, final String time) {
        System.out.println("CHECKRW");
        if (new File(FILE_NAME).exists()) {
            read();
            final Optional<PlayerScore> p = checkIfPresent(playerName);
            if (p.isPresent()) {
                check(p.get(), ps.getScore(), time);
            } else {
                 ps.setGameTime(time); 
                 ps.setName(playerName);
                 ps.setLevel(level);
                 data.add(ps);
            }
        } else {
            ps.setGameTime(time);
            ps.setName(playerName);
            ps.setLevel(level);
            data.add(ps);
        }
        save(data);
    }
    private static Optional<PlayerScore> checkIfPresent(final String playerName) {
        return data.stream()
                .filter(p -> p.getName().equals(playerName))
                .findAny();
    }

    private static void check(final PlayerScore p, final int score, final String time) {
        if (score > p.getScore()) {
            p.setScore(score);
            p.setGameTime(time);
        }
    }
}
