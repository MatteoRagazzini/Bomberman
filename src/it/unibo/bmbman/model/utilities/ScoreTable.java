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
    private String[][] data;
    /**
     * 
     * @param list of data to populate the table.
     */
    public ScoreTable(final List<List<String>> list) {
        super();
        int rowIndex = 0;
        int colIndex;
        data = new String[list.size()][this.getColumnCount()];
        for (List<String> subList : list) {
            colIndex = 1;
            for (String string : subList) {
                data[rowIndex][colIndex] = string;
                colIndex++;
            }
            rowIndex++;
        }
    }
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





