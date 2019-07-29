package it.unibo.bmbman.view;

import java.awt.FlowLayout;
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
public class MainMenuView {
    private final GUIFactory gui = new MyGUIFactory();
    private final JFrame frame = gui.createFrame();
    private final Map<JButton, MainMenuOption> jbMap = new HashMap<>();
    //per risolvere il bug dovrei aggiungere transiente nella dichiarazione
    //ma non capendo il perchè per ora non l'ho messo
    private final MainMenuController mainMenuController = new MainMenuControllerImpl();
    /*DA SISTEMARE DA QUI IN POI MA NON CAMBIARE LA STRUTTURA!!*/
    private final JPanel p = new JPanel();
    /**
     * paolo devi scrivere la javadoc.
     */
    public MainMenuView() {
        frame.getContentPane().add(p);
    }
    /**
     * .
     */
    public void loadMainMenuView() {
        p.setLayout(new FlowLayout());
        for (int i = 0; i < MainMenuOption.values().length; i++) {
            JButton b = gui.createButton(MainMenuOption.values()[i].toString());
            b.addActionListener(e -> {
                JButton jb = (JButton) e.getSource();
                mainMenuController.setOptionSelected(jbMap.get(jb));
                frame.setVisible(false);
            });
            p.add(b);
            jbMap.put(b, MainMenuOption.values()[i]);
        }

        frame.getContentPane().add(p);
        frame.setVisible(true);
    }
}
