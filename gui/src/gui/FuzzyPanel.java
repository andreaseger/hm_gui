/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import fisparser.Rule;
import fisparser.RulesInput;
import fisparser.RulesOutput;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import xmlparser.Input;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class FuzzyPanel extends JPanel{
  private final List<List<Rule>> rules;
  private JTable rulesTable;
  private FuzzyData fdata;
  private JScrollPane scollPane;

  /** Creates new form FuzzyPanel */
  FuzzyPanel(List<List<Rule>> rules, String[] header) {
    this.rules = rules;
    fdata = new FuzzyData(header);
    initComponents();
  }

  // o is the outputs index in rules and points
  void updateData(List<Timepoint> points, int o) {
    Timepoint t = points.get(o);
    fdata.clearData();
    if(t.getOutput() != 0){
      Map<Integer, Double> cr = t.getRules();
      Map<Integer, Input> s = t.getSets();
      // at least one rule is active
      for (int i = 0; i < 81; i++) {
        if(cr.get(i) != 0){
          Rule r =rules.get(o).get(i);
          fdata._data.add(new String[]{ i +"",
                                        s.get(0).printByRule(r.MAP),
                                        s.get(1).printByRule(r.CVP),
                                        s.get(2).printByRule(r.CL1),
                                        s.get(3).printByRule(r.SVR),
                                        t.printOutputByRule(r.OUT)
                        });
        }
      }
      fdata.fireTableDataChanged();
    }
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
    setBackground(Color.red);

    rulesTable = new JTable(fdata);
    rulesTable.setLocation(0, 80);
    rulesTable.setSize(660, 400);
    rulesTable.setForeground(new Color(51, 204, 0));
    rulesTable.setBackground(Color.BLACK);
    rulesTable.setAlignmentX(LEFT_ALIGNMENT);
    rulesTable.setGridColor(Color.DARK_GRAY);

    rulesTable.getTableHeader().setLocation(0, 55);
    rulesTable.getTableHeader().setSize(660, 25);
    rulesTable.getTableHeader().setBackground(Color.BLACK);
    rulesTable.getTableHeader().setForeground(Color.GREEN);


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

//    scollPane = new JScrollPane(rulesTable);
//    rulesTable.setPreferredScrollableViewportSize(new Dimension(600, 400));

//    this.add(scollPane);
  }
}
