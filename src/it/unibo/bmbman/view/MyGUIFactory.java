package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
    //    private static final Float WQHD_SIZE = 64f;
    //    private static final Float QHD_SIZE = 36f;
    //    private static final Float FHD_SIZE = 32f;
    //    private static final Float HD_SIZE = 20f;
    private GameFont font  = new GameFont();
    private static final double SCALE = ScreenTool.getScreenScale();

    @Override
    /**
     * Create a general button.
     */
    public JButton createButton(final String text) {
        final JButton button = new JButton(text);
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
        radioButton.setFont(font.getFont());
        radioButton.setBackground(Color.BLACK);
        radioButton.setBorderPainted(false);
        radioButton.setFocusPainted(false);
        radioButton.setForeground(Color.WHITE);
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
 * Method to scale the insets accorind to screen resolution.
 * @param insets the right insets in FHD
 * @return a new insets scaled according to screen resolution
 */
    public Insets createScaledInsets(final Insets insets) {
        return new Insets((int) (insets.top * SCALE), (int) (insets.left * SCALE),
                (int) (insets.bottom * SCALE), (int) (insets.bottom * SCALE));
    }
    //    public Insets createScaledInsets(int top, int left, int bottom, int right) {
    //        return new Insets((int)(top*scale),(int)(left*scale), (int)(bottom*scale), (int)(right*scale));
    //    }
    @Override
    /**
     * {@inheritDoc}
     */
    public JLabel createLabel(final String text) {
        final JLabel label = new JLabel(text);
        label.setFont(font.getFont());
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        return label;
    }
    /**
     * {@inheritDoc}
     */
    public JTextField createTextField() {
        final JTextField jTextField = new JTextField();
        jTextField.setFont(font.getFont());
        jTextField.setBackground(Color.BLACK);
        // jTextField.setBorderPainted(true);
        // label.setFocusPainted(false);
        jTextField.setForeground(Color.WHITE);
        return jTextField;
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

