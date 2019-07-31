package it.unibo.bmbman.view.utilities;

import java.awt.Toolkit;
/**
 * Screen resolution utility class.
 */
public class ScreenTool {
    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double WIDTH_REF_WQHD = 3500;
    private static final double HEIGHT_REF_WQHD = 2000;
    private static final double WIDTH_REF_HD = 1500;
    private static final double HEIGHT_REF_HD = 900;
    private static final double WIDTH_REF_QHD = 2200;
    private static final double HEIGHT_REF_QHD = 1200;
    private static final Float WQHD_SIZE = 44f;
    private static final Float QHD_SIZE = 36f;
    private static final Float FHD_SIZE = 32f;
    private static final Float HD_SIZE = 24f;
    private final String ris;
    /**
     * .
     */
    public ScreenTool() {
        ris = getScreenRes();
    }
    /**
     * .
     */
    public void checkFontSize() {
        switch (ris) {
            case "WQHD":
                GameFont.setFontSize(WQHD_SIZE);
                break;
            case "QHD":
                GameFont.setFontSize(QHD_SIZE);
                break;
            case "FHD":
                GameFont.setFontSize(FHD_SIZE);
                break;
            case "HD":
                GameFont.setFontSize(HD_SIZE);
                break;
            default:
                break;
        }
    }
    /**
     * Method to get the screen resolution.
     * @return the screen resolution
     */
    public static String getScreenRes() {
        if (SCREEN_WIDTH > WIDTH_REF_WQHD && SCREEN_HEIGHT > HEIGHT_REF_WQHD) {
            return "WQHD";
        } else if (SCREEN_WIDTH < WIDTH_REF_HD && SCREEN_HEIGHT < HEIGHT_REF_HD) {
            return "HD";
        } else if (SCREEN_WIDTH > WIDTH_REF_QHD && SCREEN_HEIGHT > HEIGHT_REF_QHD) {
            return "QHD";
        } else {
            return "FHD";
        }
    }
}