package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
    private Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    //per risolvere il bug dovrei aggiungere transiente nella dichiarazione
    //ma non capendo il perchè per ora non l'ho messo
    private MainMenuController mainMenuController = new MainMenuControllerImpl();
    private JPanel eastP;
    private JPanel westP;
    private JFrame f;
    private GUIFactory gui;
    private BufferedImage image = loadImage();
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
        f.setIconImage(image);
        f.setVisible(true);
    }
    /**
     * Create two panels and add them to the frame.
     */
    private void loadPanels() {
        westP = new JPanel(new GridLayout(MainMenuOption.values().length, 1));
        eastP = new JPanel(new GridBagLayout());
        eastP.setBackground(Color.WHITE);
        this.f.getContentPane().add(eastP, BorderLayout.CENTER);
        this.f.getContentPane().add(westP, BorderLayout.WEST);
        JLabel label = new JLabel(new ImageIcon(image));
        eastP.add(label);
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
            b.setBackground(Color.WHITE);
            b.setBorderPainted(false);
            westP.add(b);
            jbMap.put(b, MainMenuOption.values()[i]);
        }
    }
    private BufferedImage loadImage() {
        try {
            image = ImageIO.read(getClass().getResource("/Screenshot_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
