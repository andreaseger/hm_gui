/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sch1zo
 */
class ColorCellRenderer extends DefaultTableCellRenderer {

  public ColorCellRenderer() {
    super();
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));

    String s = (String) value;
    if(s.startsWith("normal"))
      setForeground(Color.ORANGE);
    else if(s.startsWith("high"))
      setForeground(Color.red);
    else if(s.startsWith("low"))
      setForeground(Color.yellow);
    return c;

  }
}
