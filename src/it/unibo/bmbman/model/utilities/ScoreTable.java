package it.unibo.bmbman.model.utilities;

import javax.swing.table.AbstractTableModel;
/**
 * 
 * Model a ScoreTable with rank, name, score and game time of a player.
 *
 */
public class ScoreTable extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] column = {"Rank", "Name", "Score", "Time"};
	private Object[][] data = {{1, "Lucia", 100, "01:22"}, {null, null, null, null}};
	
    /**
     * {@inheritDoc}
     */
	@Override
	public int getColumnCount() {
		return this.column.length;
	}
    /**
     * {@inheritDoc}
     */
	@Override
	public int getRowCount() {
		return this.data.length;
	}
    /**
     * {@inheritDoc}
     */
	@Override
	public Object getValueAt(final int row, final int col) {
		return this.data[row][col];
	}
    /**
     * {@inheritDoc}
     */
	@Override
	public String getColumnName(final int index) {
		return this.column[index];
	}
}



