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
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;
import xmlparser.Input;
import xmlparser.ObservableParser;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class FuzzyPanel extends JPanel{
  private JTable rulesTable;
  private FuzzyData fdata;
  private EnumMap<OutputEnum, List<Rule>> rules;
  private ObservableParser parser;
  private int current_id;
  private OutputEnum current_output;
  private static final String format = "%s=%3.2f%%";
  private JLabel output;
  private JLabel title;
  private JLabel next;
  private JLabel prev;

  /** Creates new form FuzzyPanel */
  FuzzyPanel(EnumMap<OutputEnum, List<Rule>> rules, String[] header) {
    this.rules = rules;
    fdata = new FuzzyData(header);
    initComponents();
  }

  public void setParser(xmlparser.ObservableParser parser){
    this.parser = parser;
  }
  public void setRules(EnumMap<OutputEnum, List<Rule>> rules){
    this.rules = rules;
  }
  
  void updateData(List<Timepoint> p, OutputEnum o){
    EnumMap<OutputEnum, Timepoint> h = new EnumMap<OutputEnum, Timepoint>(OutputEnum.class);
    for (int i = 0; i < p.size(); i++) {
      h.put(OutputEnum.get(i), p.get(i));
    }
    updateData(h, o);
  }

  // o is the outputs index in rules and points
  void updateData(EnumMap<OutputEnum, Timepoint> points, OutputEnum o) {
    Timepoint t = points.get(o);
    current_id = t.getId();
    current_output = o;
    title.setText(current_id + " | " + o.getName());
    fdata.clearData();
    Map<Integer, Double> cr = t.getRules();
    Map<Integer, Input> s = t.getSets();
    if (!cr.isEmpty()){
      for (Integer i : cr.keySet()) {
          Rule r = rules.get(o).get(i);
          fdata._data.add(new String[]{ String.valueOf(i),
                                        s.get(0).printByRule(r.MAP),
                                        s.get(1).printByRule(r.CVP),
                                        s.get(2).printByRule(r.CL1),
                                        s.get(3).printByRule(r.SVR),
                                        String.format(format, r.OUT, cr.get(i)*100)
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

    title = new JLabel();
    title.setLocation(39, 5);
    title.setSize(589, 50);
    title.setForeground(MainFrame.getForegroundColor());
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setVerticalAlignment(SwingConstants.CENTER);
    title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    title.setText("init");
    add(title);

    rulesTable = new JTable(fdata);
    rulesTable.setLocation(39, 80);
    rulesTable.setSize(589, 300);
    rulesTable.setForeground(MainFrame.getForegroundColor());
    rulesTable.setGridColor(Color.DARK_GRAY);
    rulesTable.setColumnSelectionAllowed(false);

    rulesTable.getTableHeader().setLocation(39, 55);
    rulesTable.getTableHeader().setSize(589, 25);
    rulesTable.getTableHeader().setForeground(MainFrame.getForegroundColor());
    rulesTable.getTableHeader().setResizingAllowed(false);
    rulesTable.getTableHeader().setReorderingAllowed(false);

    TableColumn column = null;
    for (int i = 0; i < 6; i++) {
        column = rulesTable.getColumnModel().getColumn(i);
        switch(i){
          case 0:
            column.setPreferredWidth(51);
            break;
          case 5:
            column.setPreferredWidth(154);
            break;
          default:
            column.setPreferredWidth(96);
        }
    }

    add(rulesTable.getTableHeader());
    add(rulesTable);

    //TODO fontsize to small
    output = new JLabel();
    output.setLocation(100, 380);
    output.setSize(560, 50);
    output.setForeground(MainFrame.getForegroundColor());
    output.setHorizontalAlignment(SwingConstants.CENTER);
    output.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
    add(output);

    next = new JLabel();
    next.setSize(50, 50);
    next.setText(">");
    next.setForeground(MainFrame.getForegroundColor());
    next.setLocation(607, 420);
    next.addMouseListener(new MouseListener() {

      public void mouseClicked(MouseEvent e) {
         //HACK: show next datapoint
        List<List<Timepoint>> t = parser.getTimepoints();
        int last_id_in_list = t.get(t.size()-1).get(0).getId();
        int first_id_in_list = t.get(0).get(0).getId();
        if(current_id == first_id_in_list)
          updateData(t.get(0), current_output);
        else if(current_id + 1 == last_id_in_list)
          updateData(t.get(last_id_in_list), current_output);
        else
          updateData(t.get(current_id-first_id_in_list+1),current_output);
     }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }
    });
    prev = new JLabel();
    prev.setSize(50, 50);
    prev.setText("<");
    prev.setForeground(MainFrame.getForegroundColor());
    prev.setLocation(10, 420);
    prev.addMouseListener(new MouseListener() {

      public void mouseClicked(MouseEvent e) {
        //HACK: show previous datapoint
        List<List<Timepoint>> t = parser.getTimepoints();
        int last_id_in_list = t.get(t.size()-1).get(0).getId();
        int first_id_in_list = t.get(0).get(0).getId();
        if(current_id == first_id_in_list)
          updateData(t.get(0), current_output);
        else if(current_id + 1 == last_id_in_list)
          updateData(t.get(last_id_in_list), current_output);
        else
          updateData(t.get(current_id-first_id_in_list-1),current_output);
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }
    });
    add(next);
    add(prev);

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
    public static String getFormatString(){
      return format;
    }
}
