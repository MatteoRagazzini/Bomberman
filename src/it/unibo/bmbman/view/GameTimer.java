package it.unibo.bmbman.view;

import javax.swing.Timer;
/**
 * 
 * It displays game time.
 *
 */
public class GameTimer extends Timer {
    private static final long serialVersionUID = 1L;
    private static final long INITIAL_TIME = System.currentTimeMillis();
    private static final long MILLIS_IN_MINUTE = 60000;
    private static final long MILLIS_IN_SECOND = 1000;
    private static final int DELAY = 1000;
    private static int seconds;
    private static int minutes;
    private static long elapsedTime;
    /**
     * Create GameTimer.
     */
    public GameTimer() {
        super(DELAY, a -> {
        elapsedTime = System.currentTimeMillis() - INITIAL_TIME;
        seconds = (int) (elapsedTime / MILLIS_IN_SECOND % 60);
        minutes = (int) (elapsedTime / MILLIS_IN_MINUTE % 60);
        System.out.println(String.format("%02d:%02d", minutes, seconds));
        }); 
    }
}
