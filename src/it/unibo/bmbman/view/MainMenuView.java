package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import it.unibo.bmbman.controller.MainMenuController;
import it.unibo.bmbman.controller.MainMenuControllerImpl;
import it.unibo.bmbman.controller.MainMenuOption;
/**
 * define the start menu of the game.
 */
public class MainMenuView {
    private final Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    private final MainMenuController mainMenuController = new MainMenuControllerImpl();
    private JPanel northP;
    private JPanel eastP;
    private JPanel centerP;
    private JFrame f;
    private final GUIFactory gui;
    private BufferedImage image;
    private final BufferedImage titleImage = loadImage("/title.jpg");
    private final BufferedImage mainImage = loadImage("/2.png");
    private static final double PANEL_SCALE_HEIGHT = 0.8;
    private static final double CENTER_SCALE_WIDTH = 0.4;
    private static final double EAST_SCALE_WIDTH = 0.6;
    private static final double NORTH_SCALE_HEIGHT = 0.2;
    /**
     * Create the main menu view.
     */
    public MainMenuView() {
        this.gui = new MyGUIFactory();
    }
    /**
     * Load all the menu components.
     */
    public void loadMainMenuView() {
        this.f = this.gui.createFrame();
        loadPanels();
        loadButtons();
        f.setTitle("Bomberman");
        f.setIconImage(mainImage);
        f.setVisible(true);
        f.pack();
        System.out.println("FRAME" + f.getSize());
        System.out.println("CENTER " + this.centerP.getSize());
        System.out.println("EAST " + this.eastP.getSize());
        System.out.println("NORTH " + this.northP.getSize());
    }
    /**
     * Create two panels and add them to the frame.
     */
    private void loadPanels() {
        centerP = new JPanel(new GridLayout(MainMenuOption.values().length, 1));
        centerP.setPreferredSize(new Dimension((int) (f.getWidth() * CENTER_SCALE_WIDTH), (int) (f.getHeight() * PANEL_SCALE_HEIGHT)));
        eastP = new JPanel(new GridBagLayout());
        eastP.setPreferredSize(new Dimension((int) (f.getWidth() * EAST_SCALE_WIDTH), (int) (f.getHeight() * PANEL_SCALE_HEIGHT)));
        northP = new JPanel();
        northP.setPreferredSize(new Dimension(f.getWidth(), (int) (f.getHeight() * NORTH_SCALE_HEIGHT)));
        eastP.setBackground(Color.BLACK);
        final JLabel label = new JLabel(new ImageIcon(mainImage));
        eastP.add(label);
        final JLabel title = new JLabel(new ImageIcon(titleImage));
        northP.setBackground(Color.BLACK);
        northP.add(title);
        f.add(centerP, BorderLayout.CENTER);
        f.add(northP, BorderLayout.NORTH);
        f.add(eastP, BorderLayout.EAST);
    }
    /**
     * Create a buttons for each menu option and add them to the panel.
     */
    private void loadButtons() {
        for (int i = 0; i < MainMenuOption.values().length; i++) {
            final JButton b = gui.createButton(MainMenuOption.values()[i].toString());
            b.addActionListener(e -> {
                final JButton jb = (JButton) e.getSource();
                mainMenuController.setOptionSelected(jbMap.get(jb));
                this.f.setVisible(false);
            });
            centerP.add(b);
            jbMap.put(b, MainMenuOption.values()[i]);
        }
    }
    /**
     * Method to load an image.
     * @param text the image path
     * @return a buffered image
     */
    private BufferedImage loadImage(final String text) {
        try {
            this.image = ImageIO.read(getClass().getResource(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.image;
    }
}
