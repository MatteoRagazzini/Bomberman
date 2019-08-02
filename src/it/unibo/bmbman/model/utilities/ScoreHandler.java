package it.unibo.bmbman.model.utilities;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * 
 * It keep track of score, game time and name of a player.
 *
 */
public class ScoreHandler {
    private String fileName = "src" + System.getProperty("file.separator") + "score.txt";
    /**
     * Create ScoreHandler.
     * @param list of score, game time and name of the player
     */
    public ScoreHandler(final List<String> list) {
        super();
        this.save(list);
    }
    private void save(final List<String> list) {
        try (final BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            list.stream().forEach(i -> {
                try {
                    System.out.println("Write " + i + " on file");
                    bw.write(i);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
