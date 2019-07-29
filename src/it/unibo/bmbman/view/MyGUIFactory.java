package it.unibo.bmbman.view;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyGUIFactory implements GUIFactory {
    
    private static double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static double WINDOW_SCALE_WIDTH = 0.5;
    private static double WINDOW_SCALE_HEIGHT = 0.66;
    private static final Font MY_FONT = new Font("Prova", Font.BOLD, 12);

    @Override
    public JButton createButton(String text) {
        final JButton button = new JButton(text);
        button.setFont(MY_FONT);
        return button;
    }

    @Override
    public JFrame createFrame() {
        final JFrame frame = new JFrame();
        frame.setSize((int) (SCREEN_WIDTH * WINDOW_SCALE_WIDTH), (int) (SCREEN_HEIGHT * WINDOW_SCALE_HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

}
