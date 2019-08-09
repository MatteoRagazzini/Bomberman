package it.unibo.bmbman.model.utilities;


/**
 *
 */
public final class Scoring {
    private static int score = 0;
    /**
     * 
     */
    private Scoring() {
    }
    /**
     * update scoring.
     */
    public static void updateScore(final boolean isBonus) {
//        score = score + value(isBonus);
//        System.out.println("Score: " + score);
    }
    /**
     * 
     * @return score 
     */
    public static int getScore() {
        return score;
    }
}
