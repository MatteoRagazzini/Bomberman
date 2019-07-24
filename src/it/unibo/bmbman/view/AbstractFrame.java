package it.unibo.bmbman.view;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private static double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static double WINDOW_SCALE_WIDTH = 0.5;
    private static double WINDOW_SCALE_HEIGHT = 0.66;
    
    /**
     * 
     */
    public AbstractFrame() {
        this.setTitle("Bomberman");
        this.setSize((int) (SCREEN_WIDTH * WINDOW_SCALE_WIDTH), (int) (SCREEN_HEIGHT * WINDOW_SCALE_HEIGHT));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
