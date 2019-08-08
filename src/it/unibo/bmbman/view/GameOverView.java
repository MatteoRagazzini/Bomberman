package it.unibo.bmbman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import it.unibo.bmbman.model.utilities.PlayerScore;
import it.unibo.bmbman.model.utilities.ScoreHandler;
/**
 * Frame for game over.
 */
public class GameOverView {

    private final GUIFactory gf = new MyGUIFactory();
    private final JFrame frame = gf.createFrame();
    private final JTextField t;
    private final JButton jb;
    private static final String MESSAGE = "Your name is already present. "
                           + "If you are a new player click OK and change name, otherwise close";
    private JDialog jd;
    private final JButton jbOk = new JButton("OK");
    private boolean isPresent = false;
    private int val;
    private PlayerScore ps;
/**
 * 
 */
    public GameOverView() {
        this.t = new JTextField(20);
        this.frame.getContentPane().setBackground(Color.BLACK);
        this.frame.getContentPane().add(gf.createLabel("GAME OVER"), BorderLayout.NORTH);
        this.jb = gf.createReturnButton(this.frame);
        this.jb.addActionListener(i -> {
                jd = new JDialog(this.frame, "Your name");
                jd.add(t);
                jd.add(jbOk);
                jd.setSize(300, 150); 
                jd.setLocationRelativeTo(this.frame);
                jd.setLayout(new FlowLayout());
                jd.setVisible(true);
        });
        this.jbOk.addActionListener(e -> {
            PlayerScore ps = new PlayerScore(t.getText());
            final String s = GameTimer.getString();
            ps.setGameTime(s);
            ps.setScore(100);
            ScoreHandler.checkAndReadWrite(ps);
//            ps = ScoreHandler.check(t.getText());
//            this.isPresent = ScoreHandler.getData().stream().anyMatch(f -> f.getName().equals(t.getText()));
//            if (this.isPresent) {
//                val = JOptionPane.showConfirmDialog(this.frame, MESSAGE, null, 
//                                                  JOptionPane.DEFAULT_OPTION);
//            }
//            if (!this.isPresent || val == JOptionPane.CLOSED_OPTION) {
//                System.out.println(ps.getName() + ps.getScore());
               // ScoreHandler.checkAndWrite(ps);
                this.frame.setVisible(false);
                new MainMenuView().loadMainMenuView();
            //}
        });
        this.t.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent event) {
                String content = t.getText();
                if (!content.equals("")) {
                    jbOk.setEnabled(true);
                } else {
                    jbOk.setEnabled(false);
                }
            }
        });
    }
/**
 * 
 * @return frame 
 */
    public JFrame getFrame() {
        return this.frame;
    }


}
