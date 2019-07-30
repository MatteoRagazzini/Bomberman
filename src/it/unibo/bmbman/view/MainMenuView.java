package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
    private static final long serialVersionUID = -1620326564341277553L;
    private final Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    //per risolvere il bug dovrei aggiungere transiente nella dichiarazione
    //ma non capendo il perchè per ora non l'ho messo
    private final MainMenuController mainMenuController = new MainMenuControllerImpl();
    private JPanel westP;
    private JFrame f;
    private final GUIFactory gui;
    private BufferedImage image;
    private BufferedImage titleImage = loadImage("/title.jpg");
    private BufferedImage mainImage = loadImage("/2.png");
    /**
     * Create the main menu view.
     */
    public MainMenuView() {
        this.gui = new MyGUIFactory();
    }
    /**
     * Load all the menù components.
     */
    public void loadMainMenuView() {
        this.f = this.gui.createFrame();
        loadPanels();
        loadButtons();
        f.setTitle("Bomberman");
        f.setIconImage(mainImage);
        f.setVisible(true);
    }
    /**
     * Create two panels and add them to the frame.
     */
    private void loadPanels() {
        this.westP = new JPanel(new GridLayout(MainMenuOption.values().length, 1));
        final JPanel eastP = new JPanel(new GridBagLayout());
        final JPanel northP = new JPanel();
        eastP.setBackground(Color.BLACK);
        final JLabel label = new JLabel(new ImageIcon(mainImage));
        eastP.add(label);
        final JLabel title = new JLabel(new ImageIcon(titleImage));
        northP.setBackground(Color.BLACK);
        northP.add(title);
        this.f.getContentPane().add(westP, BorderLayout.WEST);
        this.f.getContentPane().add(northP, BorderLayout.NORTH);
        this.f.getContentPane().add(eastP, BorderLayout.CENTER);
    }
    /**
     * Create a buttons for each menù option and add them to the panel.
     */
    private void loadButtons() {
        for (int i = 0; i < MainMenuOption.values().length; i++) {
            JButton b = gui.createButton(MainMenuOption.values()[i].toString());
            b.addActionListener(e -> {
                JButton jb = (JButton) e.getSource();
                mainMenuController.setOptionSelected(jbMap.get(jb));
                this.f.setVisible(false);
            });
            westP.add(b);
            jbMap.put(b, MainMenuOption.values()[i]);
        }
    }
    private BufferedImage loadImage(final String text) {
        try {
            this.image = ImageIO.read(getClass().getResource(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.image;
    }
}
