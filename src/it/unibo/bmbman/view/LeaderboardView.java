package it.unibo.bmbman.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import it.unibo.bmbman.model.utilities.ScoreTable;
import it.unibo.bmbman.view.utilities.GameFont;
/**
 * 
 * Class used to display Leaderboard.
 *
 */
public class LeaderboardView extends JTable{
	private static final long serialVersionUID = 1L;
	private final JFrame frame;
	private JPanel NorthP;
	private JPanel SouthP;
	private final GUIFactory gf;
	private static final Float SIZE = 20f;
	private static final int ROW_HEIGHT = 40;
	private static final int BORDER_THICKNESS = 5;
	/**
	 * Create LeaderboardView.
	 */
	public LeaderboardView() {
		super();
		this.gf = new MyGUIFactory(); //cos'è questo errore 
		this.frame = this.gf.createFrame();
		this.loadLeaderboardView();
	}

	private void loadLeaderboardView() {
		final GameFont font = new GameFont();
		this.NorthP = new JPanel();
		this.SouthP = new JPanel();
	    this.frame.add(NorthP, BorderLayout.NORTH);
	    this.frame.add(SouthP, BorderLayout.CENTER);
	    this.SouthP.setBackground(Color.WHITE);
	    this.NorthP.setBackground(Color.WHITE);
	    final JLabel label = new JLabel("LEADERBOARD");
	    label.setFont(font.getFont());
	    this.NorthP.add(label);
        final TableModel tm = new ScoreTable();
        final JTable t = new JTable(tm);
//        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(t.getModel());
//        sorter.setComparator(2, new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o1.compareTo(o2);
//				}
//	    });
        //sorter.sort();
//        sorter.setModel(t.getModel());
//        t.setRowSorter(sorter);
        SouthP.add(t);
        t.getTableHeader().setFont(font.getFont());
        t.getTableHeader().setBackground(Color.ORANGE);
        t.getTableHeader().setReorderingAllowed(false);
        t.getTableHeader().setResizingAllowed(false);
        GameFont.setFontSize(SIZE);
        t.setFont(font.getFont());
        t.setRowHeight(ROW_HEIGHT);
        t.setBackground(Color.YELLOW);
        final JScrollPane scrollPane = new JScrollPane(t);
        SouthP.add(scrollPane);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLUE, BORDER_THICKNESS, true));
        t.setPreferredScrollableViewportSize(new Dimension(600, 450));
        t.setFillsViewportHeight(true);
        this.frame.setVisible(true);
	    final JButton b = gf.createReturnButton(this.frame);
	    b.addActionListener(e -> {
	         this.frame.setVisible(false);
	         new MainMenuView().loadMainMenuView();
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
