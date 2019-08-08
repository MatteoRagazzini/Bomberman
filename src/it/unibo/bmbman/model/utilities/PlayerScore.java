package it.unibo.bmbman.model.utilities;

import java.io.Serializable;

import it.unibo.bmbman.view.GameTimer;

/** 
 * It manages name, score and game time of a player.
 */
public class PlayerScore implements Comparable<PlayerScore>, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String gameTime;
    private int score = 0;
/**
 * 
 * @param name 
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
        return this.name;
    }
/**
 * 
 * @return gameTime
 */
    public String getGameTime() {
        return this.gameTime;
    }
/**
 * 
 * @param gameTime 
 */
    public void setGameTime(final String gameTime) {
        this.gameTime = gameTime;
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
 * @param score 
 */
    public void setScore(final int score) {
        this.score = score;
    }
    @Override
    public int compareTo(final PlayerScore ps) {
        return (ps.getScore() != this.getScore())
              ? ps.getScore() - this.getScore()
              : GameTimer.getTotSeconds() - GameTimer.getTotSeconds();
    }

    @Override
    public String toString() {
        return "PlayerScore [name=" + name + ", gameTime=" + gameTime + ", score=" + score + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gameTime == null) ? 0 : gameTime.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + score;
        return result;
    }
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PlayerScore other = (PlayerScore) obj;
        if (gameTime == null) {
            if (other.gameTime != null) {
                return false;
            }
        } else if (!gameTime.equals(other.gameTime)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (score != other.score) {
            return false;
        }
        return true;
    }
}
