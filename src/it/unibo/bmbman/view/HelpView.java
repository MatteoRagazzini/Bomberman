package it.unibo.bmbman.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Frame for help section of the main menu.
 */
public class HelpView {
    private final GUIFactory gui;
    private final JFrame frame;
    private JPanel panel;
    /**
     * Generate a base frame.
     */
    public HelpView() {
        this.gui = new MyGUIFactory();
        this.frame = this.gui.createFrame();
        this.loadHelpView();
    }
    /**
     * Method used to custom the frame.
     */
    private void loadHelpView() {
        this.panel = new JPanel();
        this.frame.getContentPane().add(panel);
        this.panel.setBackground(Color.BLACK);
        this.frame.setVisible(true);
        final JButton b = gui.createReturnButton(this.frame);
        b.addActionListener(e -> {
            this.frame.setVisible(false);
            new MainMenuView().loadMainMenuView();
        });
    }
    /**
     * Getter Method.
     * @return the help view frame
     */
    public JFrame getFrame() {
        return this.frame;
    }
}
