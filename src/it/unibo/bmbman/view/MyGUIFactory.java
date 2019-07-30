package it.unibo.bmbman.view;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import it.unibo.bmbman.view.utilities.GameFont;

/**
 * Class used to generate components.
 */
public class MyGUIFactory implements GUIFactory {
    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double WINDOW_SCALE_WIDTH = 0.5;
    private static final double WINDOW_SCALE_HEIGHT = 0.66;
    private static final int INITIAL_POSITION = 100;
    private final GameFont font = new GameFont();

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
        frame.setLocation(INITIAL_POSITION, INITIAL_POSITION);
        return frame;
    }
}
