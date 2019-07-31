package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.bmbman.view.utilities.ImageLoader;
import it.unibo.bmbman.view.utilities.ScreenTool;
/**
 * Frame for help section of the main menu.
 */
public class HelpView {
    private final GUIFactory gui;
    private final JFrame frame;
    private final ImageLoader il;
    private JPanel panel;
    private String helpImagePath;
    private final ScreenTool st = new ScreenTool();
    /**
     * Generate a base frame.
     */
    public HelpView() {
        this.il = new ImageLoader();
        this.gui = new MyGUIFactory();
        this.frame = this.gui.createFrame();
        helpImagePath();
        this.loadHelpView();
    }
    /**
     * Method used to custom the frame.
     */
    private void loadHelpView() {
        this.panel = new JPanel();
        this.frame.add(panel);
        this.frame.setTitle("BOMBERMAN - Help Menu");
        this.panel.setBackground(Color.BLACK);
        final JLabel label = new JLabel(new ImageIcon(il.loadImage(helpImagePath)));
        panel.add(label, BorderLayout.CENTER);
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
    /**
     * 
     */
    private void helpImagePath() {
        helpImagePath = "/image/" + st.getRis() + "_HelpImage.png";
        System.out.println(" " + helpImagePath);
    }
}
