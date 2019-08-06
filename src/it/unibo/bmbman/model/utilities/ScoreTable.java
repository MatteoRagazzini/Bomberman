package it.unibo.bmbman.model.utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * 
 * Model a ScoreTable with rank, name, score and game time of a player.
 *
 */
public class ScoreTable extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private String[] column = {"Rank", "Name", "Score", "Time"};
    private int rowCount;
    private int colCount;
    private Object[][] data;
/**
 * 
 * @param list used to populate the table
 */
    public ScoreTable(final List<PlayerScore> list) {
        this.rowCount = list.size();
        this.colCount = this.column.length;
        this.data = new Object[list.size()][this.getColumnCount()];
        this.fill(list);
    }
    private void fill(final List<PlayerScore> list) {
        int rowIndex = 0;
        for (PlayerScore ps : list) {
            this.data[rowIndex][0] = rowIndex + 1;
            this.data[rowIndex][1] = ps.getGameTime();
            this.data[rowIndex][2] = ps.getScore();
            this.data[rowIndex][3] = ps.getName();
            rowIndex++;
            // this.setValueAt(string, rowIndex, colIndex);
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





