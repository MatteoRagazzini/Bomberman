package it.unibo.bmbman.model.utilities;

import java.io.Serializable;

import it.unibo.bmbman.view.GameTimer;

/** 
 * It manages name, score and game time of a player.
 */
public class PlayerScore implements Comparable<PlayerScore>, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int gameTime;
    private int score = 0;
    /**
     * 
     * @param name 
     * @param time 
     * @param score 
     */
    public PlayerScore(final String name, int score, int time) {
        super();
        this.name = name;
        this.score = score;
        this.gameTime = time;
    }
    /**
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }
    /**
     * 
     * @return gameTime
     */
    public int getGameTime() {
        return this.gameTime;
    }
    /**
     * 
     * @return score
     */
     public int getScore() {
         return this.score;
     }
     /**
      * 
      * @param gameTime 
      */
     public void setGameTime(final int totSeconds) {
        this.gameTime = totSeconds;
     }
     /**
      * 
      * @param score 
      */
    public void setScore(final int score) {
        this.score = score;
    }
    @Override
    public int compareTo(final PlayerScore ps) {
        return (ps.getScore() != this.getScore())
                ? ps.getScore() - this.getScore()
                : this.getGameTime() - ps.getGameTime();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + gameTime;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + score;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlayerScore other = (PlayerScore) obj;
        if (gameTime != other.gameTime)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (score != other.score)
            return false;
        return true;
    }
}
