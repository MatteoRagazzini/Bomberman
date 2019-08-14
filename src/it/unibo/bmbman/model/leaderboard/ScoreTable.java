package it.unibo.bmbman.model.leaderboard;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * Model a ScoreTable with rank, name, score and game time of a player.
 *
 */
public class ScoreTable extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private String[] column = {"Rank", "Name", "Score", "Time", "Level"};
    private int rowCount;
    private int colCount;
    private Object[][] data;
/**
 * 
 * @param list used to populate the table
 */
    public ScoreTable(final List<PlayerScoreImpl> list) {
        this.rowCount = list.size();
        this.colCount = this.column.length;
        this.data = new Object[list.size()][this.getColumnCount()];
        this.fill(list);
    }
    private void fill(final List<PlayerScoreImpl> list) {
        Iterator<Entry<Integer, Long>> entry = list.stream()
                                                 .collect(Collectors.groupingBy(PlayerScoreImpl::getLevel, Collectors.counting()))
                                                 .entrySet().iterator();
        int rowIndex = 0;
        int rank = 0;
        Long count = entry.next().getValue();
        for (PlayerScoreImpl ps : list) {
            if (rank == count) {
                count = entry.next().getValue();
                rank = 0;
            }
            this.data[rowIndex][0] = rank + 1;
            this.data[rowIndex][1] = ps.getName();
            this.data[rowIndex][2] = ps.getScore();
            this.data[rowIndex][3] = ps.getGameTime();
            this.data[rowIndex][4] = ps.getLevel();
            rank++;
            rowIndex++;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getColumnCount() {
        return this.colCount;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getColumnName(final int index) {
        return this.column[index];
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getRowCount() {
        return this.rowCount;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return this.data[rowIndex][columnIndex];
    }
}





