package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import it.unibo.bmbman.view.utilities.GameFont;
import it.unibo.bmbman.view.utilities.ScreenTool;

/**
 * Class used to generate components.
 */
public class MyGUIFactory implements GUIFactory {
    private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final double WINDOW_SCALE_WIDTH = 0.5;
    private static final double WINDOW_SCALE_HEIGHT = 0.66;
    /**
     * width value of frame.
     */
    public static final int FRAME_WIDTH = (int) (SCREEN_WIDTH * WINDOW_SCALE_WIDTH);
    /**
     * height value of frame.
     */
    public static final int FRAME_HEIGHT = (int) (SCREEN_HEIGHT * WINDOW_SCALE_HEIGHT);
    private static final int INITIAL_POSITION = 100;
    private static final Float WQHD_SIZE = 64f;
    private static final Float QHD_SIZE = 36f;
    private static final Float FHD_SIZE = 32f;
    private static final Float HD_SIZE = 20f;
    private GameFont font;
    private final ScreenTool st = new ScreenTool();

    @Override
    /**
     * Create a general button.
     */
    public JButton createButton(final String text) {
        final JButton button = new JButton(text);
        checkFontSize();
        font = new GameFont();
        button.setFont(font.getFont());
        button.setBackground(Color.BLACK);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        return button;
    }
    /**
     * {@inheritDoc}
     */
    public JRadioButton createRadioButton(final String text) {
        final JRadioButton radioButton = new JRadioButton(text);
        checkFontSize();
        font = new GameFont();
        radioButton.setFont(font.getFont());
        radioButton.setBackground(Color.BLACK);
        radioButton.setBorderPainted(false);
        radioButton.setFocusPainted(false);
        radioButton.setForeground(Color.WHITE);
        radioButton.setSize(500, 500);
        return radioButton;
    }

    @Override
    /**
     * Create a general frame.
     */
    public JFrame createFrame() {
        final JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(INITIAL_POSITION, INITIAL_POSITION);
        return frame;
    }
    /**
     * Create the "return to main menu button" that can be used in different view.
     * @return the button created
     */
    @Override
    public JButton createReturnButton(final JFrame frame) {
        final JPanel southPanel = new JPanel();
        frame.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBackground(Color.BLACK);
        final JButton back = createButton("RETURN TO MAIN MENU");
        back.setHorizontalTextPosition(SwingConstants.RIGHT);
        southPanel.add(back);
        return back;
    }
    /**
     * Used to change font size according to resolution the of the screen.
     */
    public void checkFontSize() {
        switch (st.getRis()) {
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
    @Override
    /**
     * {@inheritDoc}
     */
    public JLabel createLabel(final String text) {
        final JLabel label = new JLabel(text);
        checkFontSize();
        font = new GameFont();
        label.setFont(font.getFont());
        label.setBackground(Color.BLACK);
        //    label.setBorderPainted(false);
        //    label.setFocusPainted(false);
        label.setForeground(Color.WHITE);
        return label;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public JFrame createFrameWithCanvas() {
        final JFrame frameWCanvas = createFrame();
        final Canvas canvas = new Canvas();
        canvas.setBackground(Color.BLACK);
        frameWCanvas.getContentPane().add(canvas);
        return frameWCanvas;
    }
}
