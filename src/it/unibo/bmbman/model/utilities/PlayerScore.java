package it.unibo.bmbman.model.utilities;

/** 
 * It manages name, score and game time of a player.
 */
public class PlayerScore {
    private String name;
    private String gameTime = "2:20";
    private int score = 100;
/**
 *
 * @param name Player's name
 */
    public PlayerScore(final String name) {
        super();
        this.name = name;
    }
/**
 * 
 * @return name
 */
    public String getName() {
        return name;
    }
/**
 * 
 * @param name Player's name
 */
    public void setName(final String name) {
        this.name = name;
    }
/**
 * 
 * @return gameTime
 */
    public String getGameTime() {
        return gameTime;
    }
/**
 * 
 * @param gameTime Player's gameTime
 */
    public void setGameTime(final String gameTime) {
        this.gameTime = gameTime;
    }
/**
 * 
 * @return score
 */
    public int getScore() {
        return score;
    }
/**
 * 
 * @param score Player's score
 */
    public void setScore(final int score) {
        this.score = score;
    }
}
