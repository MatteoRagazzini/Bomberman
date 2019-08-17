package it.unibo.bmbman.model.leaderboard;

import java.util.List;

import it.unibo.bmbman.model.entities.Entity;

/**
 * Interface of PlayerScore.
 */
public interface PlayerScore {
    /**
     * @return name
     */
    String getName();
    /** 
     * @return gameTime
     */
    String getGameTime();
    /**
     * @return score
     */
    int getScore();
    /**
     * @return level's number
     */
    int getLevel();
    /**
     * @param name 
     */
    void setName(String name);
    /**
     * @param level 
     */
    void setLevel(int level);
    /**
     * @param time 
     */
    void setGameTime(String time);
    /**
     * @param score 
     */
    void setScore(int score);
    /**
     * It updates score according to {@link Scoring}. 
     * If score is zero and hero has collected malus, it does nothing.
     * @param entityToRemoved 
     */
    void updateScore(List<Entity> entityToRemoved);
}
