/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fisparser.Rule;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import xmlparser.Input;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class FuzzyPanel extends JPanel{
  private JTable rulesTable;
  private FuzzyData fdata;
  private final EnumMap<OutputEnum, List<Rule>> rules;
  private JLabel output;
  private final DecimalFormat f;

  /** Creates new form FuzzyPanel */
  FuzzyPanel(EnumMap<OutputEnum, List<Rule>> rules, String[] header) {
    this.rules = rules;
    f = new DecimalFormat("#0.0");
    fdata = new FuzzyData(header);
    initComponents();
  }

  // o is the outputs index in rules and points
  void updateData(EnumMap<OutputEnum, Timepoint> points, OutputEnum o) {
    Timepoint t = points.get(o);
    fdata.clearData();
    Map<Integer, Double> cr = t.getRules();
    Map<Integer, Input> s = t.getSets();
    if (!cr.isEmpty()){
      for (Integer i : cr.keySet()) {
          Rule r = rules.get(o).get(i);
          fdata._data.add(new String[]{ i +"",
                                        s.get(0).printByRule(r.MAP),
                                        s.get(1).printByRule(r.CVP),
                                        s.get(2).printByRule(r.CL1),
                                        s.get(3).printByRule(r.SVR),
                                        r.OUT + "=" + f.format(cr.get(i)*100) + "%"
                        });
      }
      output.setText("Output = " + t.getOutput());
    } else {
      output.setText("No Rules active");
    }
    fdata.fireTableDataChanged();
  }

  public void setAllSizes(int width, int height){
    Dimension d = new Dimension(width, height);
    setMaximumSize(d);
    setMinimumSize(d);
    setPreferredSize(d);
    setSize(d);
  }

  private void initComponents() {
    setLayout(null);

    rulesTable = new JTable(fdata);
    rulesTable.setLocation(0, 80);
    rulesTable.setSize(660, 300);
    rulesTable.setForeground(MainFrame.getForegroundColor());
    rulesTable.setAlignmentX(LEFT_ALIGNMENT);
    rulesTable.setGridColor(Color.DARK_GRAY);
    rulesTable.setColumnSelectionAllowed(false);
    rulesTable.setRowSelectionAllowed(false);

    rulesTable.getTableHeader().setLocation(0, 55);
    rulesTable.getTableHeader().setSize(660, 25);
    rulesTable.getTableHeader().setForeground(MainFrame.getForegroundColor());
    rulesTable.getTableHeader().setResizingAllowed(false);
    rulesTable.getTableHeader().setReorderingAllowed(false);

    TableColumn column = null;
    for (int i = 0; i < 6; i++) {
        column = rulesTable.getColumnModel().getColumn(i);
        switch(i){
          case 0:
            column.setPreferredWidth(50);
            break;
          case 5:
            column.setPreferredWidth(190);
            break;
          default:
            column.setPreferredWidth(105);
        }
    }

    add(rulesTable.getTableHeader());
    add(rulesTable);

    //TODO fontsize to small
    output = new JLabel();
    output.setLocation(100, 380);
    output.setSize(560, 50);
    output.setForeground(MainFrame.getForegroundColor());

    add(output);
    setAllBackgrounds(this,Color.black);
  }
    private void setAllBackgrounds(Component component, Color color) {
        component.setBackground(color);

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setAllBackgrounds(child, color);
            }
        }
    }
}
