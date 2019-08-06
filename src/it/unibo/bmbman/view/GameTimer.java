package it.unibo.bmbman.view;

import javax.swing.Timer;
/**
 * 
 * It displays game time.
 *
 */
public class GameTimer extends Timer {
    private static final long serialVersionUID = 1L;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final int DELAY = 1000;
    private static int seconds = 0;
    private static int minutes = 0;
    /**
     * Create GameTimer.
     */
    public GameTimer(/*JLabel label*/) {
        super(DELAY, a -> {
            seconds++;
            if (seconds == SECONDS_IN_MINUTE) {
                minutes++;
                seconds = 0;
            }
            //label.setText(String.format("%02d:%02d", minutes, seconds));
            System.out.println(String.format("%02d:%02d", minutes, seconds));
        }); 
    }
    /**
     * 
     * @return seconds
     */
    public static int getSeconds() {
        return seconds;
    }
    /**
     * 
     * @return minutes
     */
    public static int getMinutes() {
        return minutes;
    }
    /**
     * 
     * @return gameTime in seconds
     */
    public int getTotSeconds() {
        return seconds + (minutes * SECONDS_IN_MINUTE);
    }
}
