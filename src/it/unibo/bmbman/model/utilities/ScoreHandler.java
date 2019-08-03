package it.unibo.bmbman.model.utilities;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * It keeps track of score, game time and name of players.
 *
 */
public class ScoreHandler {
    private String fileName; /*= "src" + System.getProperty("file.separator") + "score.txt";*/
    private List<List<String>> data = new ArrayList<>();
/**
 * 
 * @param ps playerScore
 * @throws Exception 
 */
    public ScoreHandler(final PlayerScore ps) throws Exception {
        super();
        this.save(this.createList(ps));
        this.read();
    }
    private List<String> createList(final PlayerScore ps) {
         List<String> list = new ArrayList<>();
         list.add(ps.getName());
         list.add(String.valueOf(ps.getScore()));
         list.add(ps.getGameTime());
         return list;
    }
    /**
     * Append data on file score.txt.
     * @param list of score, game time and name of the player
     * @throws Exception 
     */
    private void save(final List<String> list) {
        try (final BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            list.stream().forEach(i -> {
                    System.out.println("Write " + i + " on file");
                    try {
                        bw.write(i + " ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            });
            bw.newLine();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    /**
     * Read data from score.txt.
     * @throws Exception
     */
    private void read() throws Exception {
        try (final BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                List<String> list = new ArrayList<>();
                this.data.add(list);
                final Scanner sc = new Scanner(line);
                while (sc.hasNext()) {
                    list.add(sc.next());
                }
                sc.close();
            }
        }
    }
    /**
     * Get data that are into score.txt.
     * @return data
     */
    public List<List<String>> getData() {
        return this.data;
    }
}
