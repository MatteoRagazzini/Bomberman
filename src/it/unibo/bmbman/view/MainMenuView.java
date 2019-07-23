package it.unibo.bmbman.view;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.bmbman.controller.MainMenuController;
import it.unibo.bmbman.controller.MainMenuControllerImpl;
import it.unibo.bmbman.controller.MainMenuOption;
    /**
     * define the start menu of the game.
     *
     */
public class MainMenuView extends JFrame {
    /**
    * 
    */
    private static final long serialVersionUID = 1L;
    private static double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static double WINDOW_SCALE_WIDTH = 0.5;
    private static double WINDOW_SCALE_HEIGHT = 0.66;
    private Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    private final MainMenuController mainMenuController;
    /*DA SISTEMARE DA QUI IN POI MA NON CAMBIARE LA STRUTTURA!!*/
    private JPanel p = new JPanel();
    /**
     * paolo devi scrivere la javadoc.
     */
    public MainMenuView() {
        mainMenuController = new MainMenuControllerImpl();
        this.setTitle("Bomberman");
        this.setSize((int) (SCREEN_WIDTH * WINDOW_SCALE_WIDTH), (int) (SCREEN_HEIGHT * WINDOW_SCALE_HEIGHT));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * .
     */
    public void loadMainMenuView() {
        p.setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++) {
        JButton b = new JButton(MainMenuOption.values()[i].toString());
        b.addActionListener(e -> {
        JButton jb = (JButton) e.getSource();
        mainMenuController.setOptionSelected(jbMap.get(jb));
        });
        p.add(b);
        jbMap.put(b, MainMenuOption.values()[i]);
        }

        this.getContentPane().add(p);
        this.setVisible(true);
    }
}
