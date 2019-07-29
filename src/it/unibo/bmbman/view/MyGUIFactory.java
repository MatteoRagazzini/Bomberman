package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.bmbman.view.utilities.GameFont;

/**
 * Class used to generate components.
 */
public class MyGUIFactory implements GUIFactory {
    private static double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static double WINDOW_SCALE_WIDTH = 0.5;
    private static double WINDOW_SCALE_HEIGHT = 0.66;
    private GameFont font = new GameFont();

    @Override
    /**
     * Create a general button.
     */
    public JButton createButton(final String text) {
        final JButton button = new JButton(text);
        button.setFont(font.getFont());
        return button;
    }

    @Override
    /**
     * Create a general frame.
     */
    public JFrame createFrame() {
        final JFrame frame = new JFrame();
        frame.setSize((int) (SCREEN_WIDTH * WINDOW_SCALE_WIDTH), (int) (SCREEN_HEIGHT * WINDOW_SCALE_HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
    
}
