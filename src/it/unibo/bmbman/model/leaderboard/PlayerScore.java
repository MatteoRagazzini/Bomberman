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
     * It updates score according to {@link Scoring}. 
     * If score is zero and hero has collected malus, it does nothing.
     * @param entityToRemoved 
     */
    void updateScore(List<Entity> entityToRemoved);
}
