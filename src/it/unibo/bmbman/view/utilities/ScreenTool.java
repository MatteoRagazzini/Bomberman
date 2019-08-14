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
    private static final double WQHDSCALE = 2;
    private static final double QHDSCALE = 1.33;
    private static final double FHDSCALE = 1;
    private static final double HDSCALE = 0.71;
    private static ScreenTool istance = null;
    /**
     * Costruttore privato, in quanto la creazione dell'istanza deve essere controllata.
     */
    private ScreenTool() {}
    /**
     * La classe Contenitore viene caricata/inizializzata alla prima esecuzione di getInstance()
     * ovvero al primo accesso a Contenitore.ISTANZA, ed in modo thread-safe.
     * Anche l'inizializzazione dell'attributo statico, pertanto, viene serializzata.
     */
    private static class Contenitore { 
        private final static ScreenTool ISTANZA = new ScreenTool();
    }
    /**
     * Punto di accesso al Singleton. Ne assicura la creazione thread-safe
     * solo all'atto della prima chiamata.
     * @return il Singleton corrispondente
     */
    public static ScreenTool getInstance() {
        return Contenitore.ISTANZA;
    }
    public double getScreenScale() {
        if (SCREEN_WIDTH > WIDTH_REF_WQHD && SCREEN_HEIGHT > HEIGHT_REF_WQHD) {
            return WQHDSCALE;
        } else if (SCREEN_WIDTH < WIDTH_REF_HD && SCREEN_HEIGHT < HEIGHT_REF_HD) {
            return HDSCALE;
        } else if (SCREEN_WIDTH > WIDTH_REF_QHD && SCREEN_HEIGHT > HEIGHT_REF_QHD) {
            return QHDSCALE;
        } else {
            return FHDSCALE;
        }
    }
    public String getScreenRes() {
        if (SCREEN_WIDTH > WIDTH_REF_WQHD && SCREEN_HEIGHT > HEIGHT_REF_WQHD) {
            return "WQHD";
        } else if (SCREEN_WIDTH > WIDTH_REF_QHD && SCREEN_HEIGHT > HEIGHT_REF_QHD) {
            return "QHD";
        } else if (SCREEN_WIDTH < WIDTH_REF_HD && SCREEN_HEIGHT < HEIGHT_REF_HD) {
            return "HD";
        } else {
            return "FHD";
        }
    }
}