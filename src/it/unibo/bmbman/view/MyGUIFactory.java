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
import javax.swing.JRadioButtonMenuItem;
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
    private static final Float WQHD_SIZE = 64f;
    private static final Insets WQHD_INSETS = new Insets(50, 120, 70, 40);
    private static final Insets WQHD_OPTION_INSETS = new Insets(0, 50, 0, 50);
    private static final Insets WQHD_GAMEOVER_INSETS = new Insets(100, 50, 100, 50);
    private static final Insets QHD_INSETS = new Insets(33, 80, 47, 27);
    private static final Insets QHD_OPTION_INSETS = new Insets(0, 33, 0, 33);
    private static final Insets QHD_GAMEOVER_INSETS = new Insets(67, 33, 67, 33);
    private static final Insets FHD_INSETS = new Insets(25, 60, 35, 20);
    private static final Insets FHD_OPTION_INSETS = new Insets(0, 25, 0, 25);
    private static final Insets FHD_GAMEOVER_INSETS = new Insets(50, 25, 50, 25);
    private static final Insets HD_INSETS = new Insets(18, 43, 25, 14);
    private static final Insets HD_OPTION_INSETS = new Insets(0, 18, 0, 18);
    private static final Insets HD_GAMEOVER_INSETS = new Insets(36, 18, 36, 18);
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
        checkFontSize();
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
            MainMenuView.setInsets(WQHD_INSETS);
            OptionsView.setInsets(WQHD_OPTION_INSETS);
            GameOverView.setInsets(WQHD_GAMEOVER_INSETS);
            break;
        case "QHD":
            GameFont.setFontSize(QHD_SIZE);
            MainMenuView.setInsets(QHD_INSETS);
            OptionsView.setInsets(QHD_OPTION_INSETS);
            GameOverView.setInsets(QHD_GAMEOVER_INSETS);
            break;
        case "FHD":
            GameFont.setFontSize(FHD_SIZE);
            MainMenuView.setInsets(FHD_INSETS);
            OptionsView.setInsets(FHD_OPTION_INSETS);
            GameOverView.setInsets(FHD_GAMEOVER_INSETS);
            break;
        case "HD":
            GameFont.setFontSize(HD_SIZE);
            MainMenuView.setInsets(HD_INSETS);
            OptionsView.setInsets(HD_OPTION_INSETS);
            GameOverView.setInsets(HD_GAMEOVER_INSETS);
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
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        return label;
    }
    /**
     * {@inheritDoc}
     */
    public JTextField createTextField() {
        final JTextField jTextField = new JTextField();
        checkFontSize();
        font = new GameFont();
        jTextField.setFont(font.getFont());
        jTextField.setBackground(Color.BLACK);
       // jTextField.setBorderPainted(true);
        //    label.setFocusPainted(false);
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
