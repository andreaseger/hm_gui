 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sch1zo
 */
public class FuzzyData extends AbstractTableModel{
  public LinkedList<String[]> _data;
  private String[] columnNames;

  public FuzzyData(String[] header){
    _data = new LinkedList<String[]>();
    columnNames = header;
  }
  public void clearData(){
    _data.clear();
    fireTableDataChanged();
  }

  public int getRowCount() {
    return _data.size();
  }

  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public String getColumnName(int col) {
    return columnNames[col];
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    return _data.get(rowIndex)[columnIndex];
  }

  @Override
  public boolean isCellEditable(int row, int col) {
      return false;
  }
  public boolean isCellValueHigh(int row, int col){
    return true;//_data.get(row)[col].matches("high");;
  }
}
