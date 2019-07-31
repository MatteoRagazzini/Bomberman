package it.unibo.bmbman.view.utilities;

import java.awt.Toolkit;
/**
 * .
 */
public class ScreenTool {
    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double WIDTH_REF = 2000;
    private static final double HEIGHT_REF = 1100;
    private static final Float NEW_SIZE = 50f;
    private final GameFont font = new GameFont();
    /**
     * 
     */
    public void checkFontSize() {
        if (SCREEN_WIDTH > WIDTH_REF && SCREEN_HEIGHT > HEIGHT_REF) {
            font.setFontSize(NEW_SIZE);
        }
    }
}
