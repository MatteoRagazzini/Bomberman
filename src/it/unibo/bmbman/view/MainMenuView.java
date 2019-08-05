package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import it.unibo.bmbman.controller.MainMenuController;
import it.unibo.bmbman.controller.MainMenuControllerImpl;
import it.unibo.bmbman.controller.MainMenuOption;
import it.unibo.bmbman.view.utilities.ImageLoader;
import it.unibo.bmbman.view.utilities.ScreenTool;
/**
 * define the start menu of the game.
 */
public class MainMenuView {
    private final Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    private final MainMenuController mainMenuController = new MainMenuControllerImpl();
    private JPanel northP;
    private JPanel eastP;
    private JPanel centerP;
    //aggiunto per gestire il gridbaglayout
    private GridBagConstraints c;
    private JFrame f;
    private final GUIFactory gui;
    private final ImageLoader il;
    private final ScreenTool st = new ScreenTool();
    private String titleImagePath;
    private String mainImagePath;
//    private static final String BUTTON_IMAGE_PATH = "/redBricks.jpg";
    private static final double CENTER_SCALE_WIDTH = 0.4;
    private static final double EAST_SCALE_WIDTH = 0.6;
    private static final double PANEL_SCALE_HEIGHT = 0.8;
    private static final double NORTH_SCALE_HEIGHT = 0.2;
    /**
     * Create the main menu view.
     */
    public MainMenuView() {
        this.gui = new MyGUIFactory();
        il = new ImageLoader();
        saveMainImagePath();
        saveTitleImagePath();
    }
    /**
     * Load all the menu components.
     */
    public void loadMainMenuView() {
        f = this.gui.createFrame();
        f.setTitle("BOMBERMAN - Main Menu");
        loadPanels();
        loadButtons();
        f.setVisible(true);
        f.pack();
//        System.out.println("FRAME" + f.getSize());
//        System.out.println("CENTER " + this.centerP.getSize());
//        System.out.println("EAST " + this.eastP.getSize());
//        System.out.println("NORTH " + this.northP.getSize());
    }
    /**
     * Create two panels and add them to the frame.
     */
    private void loadPanels() {
        // Create CENTER Panel
        centerP = new JPanel(new GridBagLayout());
        centerP.setBackground(Color.BLACK);
        //parte del constraints
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1.0;
        //magic number da cambiare in caso di 4k
        c.insets = new Insets(25, 60, 35, 20); 
        centerP.setPreferredSize(new Dimension((int) (f.getWidth() * CENTER_SCALE_WIDTH), (int) (f.getHeight() * PANEL_SCALE_HEIGHT)));
        // Create EAST Panel
        eastP = new JPanel(new BorderLayout());
        eastP.setPreferredSize(new Dimension((int) (f.getWidth() * EAST_SCALE_WIDTH), (int) (f.getHeight() * PANEL_SCALE_HEIGHT)));
        eastP.setBackground(Color.BLACK);
        final JLabel label = new JLabel(new ImageIcon(il.loadImage(mainImagePath)));
        eastP.add(label, BorderLayout.CENTER);
        // Create NORTH Panel
        northP = new JPanel(new BorderLayout());
        northP.setPreferredSize(new Dimension(f.getWidth(), (int) (f.getHeight() * NORTH_SCALE_HEIGHT)));
        final JLabel title = new JLabel(new ImageIcon(il.loadImage(titleImagePath)));
        northP.setBackground(Color.BLACK);
        northP.add(title, BorderLayout.SOUTH);
        // Add Panels to the Frame
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
            b.setBorderPainted(true);
           //finchè non capisco come mettere in foreground il testo
//            b.setIcon(new ImageIcon(il.loadImage(BUTTON_IMAGE_PATH)));
            c.gridx = 0;
            c.gridy = i; //voglio che vengano messi uno sotto all'altro 
            centerP.add(b, c);
            jbMap.put(b, MainMenuOption.values()[i]);
        }
    }
    /**
     * Save the main image path based on the screen resolution.
     */
    private void saveMainImagePath() {
        mainImagePath = "/image/" + st.getRis() + "_MainImage.png";
    }
    /**
     * Save the title image path based on the screen resolution.
     */
    private void saveTitleImagePath() {
        titleImagePath = "/image/" + st.getRis() + "_TitleImage.jpg";
    }
}
