package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import it.unibo.bmbman.controller.OptionsMenuController;
import it.unibo.bmbman.controller.OptionsMenuList;
import it.unibo.bmbman.model.utilities.PlayerScore;
import it.unibo.bmbman.model.utilities.ScoreHandler;
import it.unibo.bmbman.view.utilities.ImageLoader;
import it.unibo.bmbman.view.utilities.ScreenTool;
/**
 * Frame for game over.
 */
public class GameOverView {

    private MyGUIFactory gui;
    private JFrame f;
    private JPanel centerP; 
    private JPanel eastP;
    private JPanel northP;
    private JButton enterName;
    private JTextField nameTextField;
    private final String score;
    private String gameOverImagePath;
    private GridBagConstraints c;
    private static Insets insets;
    private final ImageLoader il = new ImageLoader();
    private final ScreenTool st = new ScreenTool();
    //    private final JTextField t;
    //    private static final String MESSAGE = "Your name is already present. "
    //                           + "If you are a new player click OK and change name, otherwise close";
    //    private final JButton jbOk = new JButton("OK");
    //    private boolean isPresent = false;
    //    private int val;
    //    private PlayerScore ps;
    /**
     * Create a GameOverView.
     */
    public GameOverView() {
        this.gui = new MyGUIFactory();
        this.f = gui.createFrame();
        this.score = GameTimer.getString();
        loadGameOverView();
    }

    /**
     * Customize the GameOverView view frame.
     */
    private void loadGameOverView() {
        f.setTitle("BOMBERMAN - GameOver");
        f.setBackground(Color.black);
        saveGameOverImagePath();
        loadPanels();
        loadLabels();
        loadTextField();
        loadButtons();
    }

    /**
     * Used to loadLabels.
     */
    private void loadLabels() {
        final JLabel titleLabel = gui.createLabel("Game Over");
        final JLabel timeLabel = gui.createLabel("Game Time");
        final JLabel playerTimeLabel = gui.createLabel(score);
        final JLabel scoreLabel = gui.createLabel("Score");
        final JLabel playerScoreLabel = gui.createLabel("100");
        final JLabel iconLabel = new JLabel(new ImageIcon(il.loadImage(gameOverImagePath)));
        northP.add(titleLabel, BorderLayout.CENTER);
        eastP.add(iconLabel, BorderLayout.NORTH);
        c.gridx = 0;
        c.gridy = 0;
        centerP.add(timeLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        centerP.add(playerTimeLabel, c);
        c.gridx = 0;
        c.gridy = 1;
        centerP.add(scoreLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        centerP.add(playerScoreLabel, c);
    }
    /**
     * Used to load Panels.
     */
    private void loadPanels() {
        centerP = new JPanel(new GridBagLayout());
        eastP = new JPanel(new BorderLayout());
        northP = new JPanel();
        centerP.setBackground(Color.black);
        eastP.setBackground(Color.BLACK);
        northP.setBackground(Color.BLACK);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 3.0;
        c.insets = this.insets;
        f.add(centerP, BorderLayout.CENTER);
        f.add(eastP, BorderLayout.EAST);
        f.add(northP, BorderLayout.NORTH);
    }
    /**
     * Used to load buttons.
     */
    private void loadButtons() {
        final JButton returnB = gui.createReturnButton(this.f);
        returnB.addActionListener(e -> {
            this.f.setVisible(false);
            new MainMenuView().loadMainMenuView();
        });
        enterName = gui.createButton("Save");
        enterName.addActionListener(e -> {
            PlayerScore ps = new PlayerScore(nameTextField.getText());
            ps.setGameTime(score);
            ps.setScore(100);
            ScoreHandler.checkAndReadWrite(ps);
        });
        c.gridx = 1;
        c.gridy = 2;
        centerP.add(enterName, c);
    }
    /**
     * Used to load JTextField. 
     */
    private void loadTextField() {
        this.nameTextField = gui.createTextField();
        c.gridx = 0;
        c.gridy = 2;
        centerP.add(nameTextField, c);
    }
    /**
     * Used to get the actual frame.
     * @return frame 
     */
    public JFrame getFrame() {
        return this.f;
    }
    /**
     * Used to save the appropriete image according to screen resolution.
     */
    private void saveGameOverImagePath() {
        gameOverImagePath = "/image/" + st.getRis() + "_GameOverImage.png";
    }
    /**
     * Change the insects according to screen resolution.
     * @param insets the correct insects
     */
    public static void setInsets(final Insets insets) {
        GameOverView.insets = insets;
    }

    //  this.t = new JTextField(20);
    //  this.jb.addActionListener(i -> {
    //          jd = new JDialog(this.frame, "Your name");
    //          jd.add(t);
    //          jd.add(jbOk);
    //          jd.setSize(300, 150); 
    //          jd.setLocationRelativeTo(this.frame);
    //          jd.setLayout(new FlowLayout());
    //          jd.setVisible(true);
    //  });
    //  this.jbOk.addActionListener(e -> {
    //      PlayerScore ps = new PlayerScore(t.getText());
    //      final String s = GameTimer.getString();
    //      ps.setGameTime(s);
    //      ps.setScore(100);
    //      ScoreHandler.checkAndReadWrite(ps);
    ////      ps = ScoreHandler.check(t.getText());
    ////      this.isPresent = ScoreHandler.getData().stream().anyMatch(f -> f.getName().equals(t.getText()));
    ////      if (this.isPresent) {
    ////          val = JOptionPane.showConfirmDialog(this.frame, MESSAGE, null, 
    ////                                            JOptionPane.DEFAULT_OPTION);
    ////      }
    ////      if (!this.isPresent || val == JOptionPane.CLOSED_OPTION) {
    ////          System.out.println(ps.getName() + ps.getScore());
    //         // ScoreHandler.checkAndWrite(ps);
    //          this.frame.setVisible(false);
    //          new MainMenuView().loadMainMenuView();
    //      //}
    //  });
    //  this.t.addKeyListener(new KeyAdapter() {
    //      public void keyReleased(final KeyEvent event) {
    //          String content = t.getText();
    //          if (!content.equals("")) {
    //              jbOk.setEnabled(true);
    //          } else {
    //              jbOk.setEnabled(false);
    //          }
    //      }
    //  });

}
