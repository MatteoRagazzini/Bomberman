package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.bmbman.controller.EndGameState;
import it.unibo.bmbman.model.utilities.PlayerScore;
import it.unibo.bmbman.model.utilities.ScoreHandler;
import it.unibo.bmbman.view.utilities.BackgroundPanel;
import it.unibo.bmbman.view.utilities.ScreenTool;
/**
 * Frame for game over.
 */
public class EndView {

    private MyGUIFactory gui;
    private final MainMenuView mainView;
    private JFrame f;
    private JPanel centerP; 
    private JPanel backgroundP;
    private JPanel northP;
    private JButton enterName;
    private JTextField nameTextField;
    private final int totSecond;
    private String gameOverImagePath;
    private Image image;
    private GridBagConstraints c;
    private static Insets insets;
    private final ScreenTool st = new ScreenTool();
    private int score;
    private PlayerScore ps;
    private final EndGameState state;
    //    private static final String MESSAGE = "Your name is already present. "
    //                           + "If you are a new player click OK and change name, otherwise close";
    //    private final JButton jbOk = new JButton("OK");
    //    private boolean isPresent = false;
    //    private int val;
    //    private PlayerScore ps;
    /**
     * Create a GameOverView.
     * @param ps 
     */
    public EndView(final MainMenuView mainMenuView, PlayerScore ps, EndGameState state) {
        mainView = mainMenuView;
        this.ps = ps;
        this.gui = new MyGUIFactory();
        this.f = gui.createFrame();
        this.score = ps.getScore();
        this.totSecond = GameTimer.getTotSeconds();
        this.state = state;
        loadEndView();
    }

    /**
     * Customize the GameOverView view frame.
     */
    private void loadEndView() {
        switch (state) {
        case LOSE:
            f.setTitle("BOMBERMAN - GameOver");
            break;
        case WIN:
            f.setTitle("BOMBERMAN - You WIN!");
            break;
        default:
            break;
        
        }

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
        JLabel titleLabel = gui.createLabel("");
        switch (state) {
        case LOSE:
            titleLabel = gui.createLabel("Game Over");
            break;
        case WIN:
            titleLabel = gui.createLabel("YOU WIN!");
            break;
        default:
            break;
        
        }
        final JLabel timeLabel = gui.createLabel("Game Time");
        final JLabel playerTimeLabel = gui.createLabel(GameTimer.getString());
        final JLabel scoreLabel = gui.createLabel("Score");
        final JLabel playerScoreLabel = gui.createLabel(String.valueOf(this.score));
        final JLabel enterYourName = gui.createLabel("Enter your name");
        northP.add(titleLabel, BorderLayout.CENTER);
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
        c.gridx = 0;
        c.gridy = 2;
        centerP.add(enterYourName, c);
    }
    /**
     * Used to load Panels.
     */
    private void loadPanels() {
        backgroundP = new BackgroundPanel(loadImage(gameOverImagePath));
        backgroundP.setBackground(Color.BLACK);
        centerP = new JPanel(new GridBagLayout());
        centerP.setOpaque(false);
        northP = new JPanel();
        northP.setBackground(Color.BLACK);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0;
        c.insets = this.insets;
        backgroundP.setLayout(new BorderLayout());
        backgroundP.add(centerP, BorderLayout.WEST);
        f.add(backgroundP, BorderLayout.CENTER);
        f.add(northP, BorderLayout.NORTH);
    }
    /**
     * Used to load buttons.
     */
    private void loadButtons() {
        final JButton returnB = gui.createReturnButton(this.f);
        returnB.addActionListener(e -> {
            this.f.setVisible(false);
            mainView.getFrame().setVisible(true);
        });
        enterName = gui.createButton("Save");
        enterName.setBorderPainted(true);
        enterName.addActionListener(e -> {
            //ps.setGameTime(score);
            //ps.setScore(totSecond);
            ScoreHandler.checkAndReadWrite(ps, nameTextField.getText(), GameTimer.getTotSeconds());
            enterName.setEnabled(false);
        });
        nameTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent event) {
                String content = nameTextField.getText();
                if (!content.equals("")) {
                    enterName.setEnabled(true);
                } else {
                    enterName.setEnabled(false);
                }
            }
        });
        c.gridx = 1;
        c.gridy = 3;
        //enterName.setOpaque(false);
        //enterName.setForeground(Color.BLACK);
        centerP.add(enterName, c);

    }
    /**
     * Used to load JTextField. 
     */
    private void loadTextField() {
        this.nameTextField = gui.createTextField();
        c.gridx = 0;
        c.gridy = 3;
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
        EndView.insets = insets;
    }

    private Image loadImage(final String text) {
        try {
            image = ImageIO.read(getClass().getResource(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
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

}
