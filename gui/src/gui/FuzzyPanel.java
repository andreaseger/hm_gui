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
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
  private OutputEnum output_type;
  private static final String format = "%s=%3.2f%%";
  private JLabel output;
  private JLabel title;
  private JLabel next;
  private JLabel prev;
  private JLabel input;
  private List<Float[]> inputs;
  private List<String> times;
  private JLabel newest;
  private JLabel goToDetail;

  /** Creates new form FuzzyPanel */
  FuzzyPanel(EnumMap<OutputEnum, List<Rule>> rules, String[] header) {
    this.rules = rules;
    fdata = new FuzzyData(header);
    initComponents();
  }

  FuzzyPanel(EnumMap<OutputEnum, List<Rule>> rules, String[] header, OutputEnum output_type) {
    this.rules = rules;
    this.fdata = new FuzzyData(header);
    this.output_type = output_type;
    initComponents();
  }

  public void setParser(xmlparser.ObservableParser parser){
    this.parser = parser;
  }
  public void setRules(EnumMap<OutputEnum, List<Rule>> rules){
    this.rules = rules;
  }
  public void setOutputType(OutputEnum output_type){
    this.output_type = output_type;
  }

  public void updateData(){
    List<Timepoint> p = parser.getTimepoints().get(current_id);
    EnumMap<OutputEnum, Timepoint> h = new EnumMap<OutputEnum, Timepoint>(OutputEnum.class);
    for (int i = 0; i < p.size(); i++) {
      h.put(OutputEnum.get(i), p.get(i));
    }
    updateData(h, output_type);

  }

  public void updateData(List<Timepoint> p){
    EnumMap<OutputEnum, Timepoint> h = new EnumMap<OutputEnum, Timepoint>(OutputEnum.class);
    for (int i = 0; i < p.size(); i++) {
      h.put(OutputEnum.get(i), p.get(i));
    }
    updateData(h, output_type);
  }

  public void updateData(List<Timepoint> p, OutputEnum o){
    EnumMap<OutputEnum, Timepoint> h = new EnumMap<OutputEnum, Timepoint>(OutputEnum.class);
    for (int i = 0; i < p.size(); i++) {
      h.put(OutputEnum.get(i), p.get(i));
    }
    output_type = o;
    updateData(h, o);
  }

  // o is the outputs index in rules and points
  private void updateData(EnumMap<OutputEnum, Timepoint> points, OutputEnum o) {
    Timepoint t = points.get(o);
    current_id = t.getId();
    title.setText(times.get(current_id));
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
      output.setText(o.getName() + " | Differenz = " + t.getOutput());
    } else {
      output.setText("No Rules active");
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      sb.append(String.format("%12s = %.2f", fdata.getColumnName(i+1), inputs.get(current_id)[i] ));
    }
    input.setText("Inputs: " + sb.toString());

    fdata.fireTableDataChanged();
    //updateColors();
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
    title.setLocation(39, 15);
    title.setSize(589, 35);
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setVerticalAlignment(SwingConstants.CENTER);
    title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
    title.setText("init");
    add(title);

    input = new JLabel();
    input.setLocation(39, 50);
    input.setSize(589, 100);
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      s.append(String.format("%12s = %.2f\t", fdata.getColumnName(i+1), 0.00));
    }
    input.setText(s.toString());
    input.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
    add(input);

    rulesTable = new JTable(fdata);
    rulesTable.setLocation(39, 180);
    rulesTable.setSize(589, 180);
    rulesTable.setGridColor(Color.DARK_GRAY);
    rulesTable.setColumnSelectionAllowed(false);
    rulesTable.setRowSelectionAllowed(false);
    rulesTable.setCellSelectionEnabled(false);

    rulesTable.getTableHeader().setLocation(39, 155);
    rulesTable.getTableHeader().setSize(589, 25);
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

    output = new JLabel();
    output.setLocation(100, 370);
    output.setSize(560, 30);
    output.setHorizontalAlignment(SwingConstants.CENTER);
    output.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
    add(output);

    goToDetail = new JLabel();
    goToDetail.setSize(417, 60);
    goToDetail.setText("Back To Details");
    goToDetail.setHorizontalAlignment(SwingConstants.CENTER);
    goToDetail.setVerticalAlignment(SwingConstants.CENTER);
    goToDetail.setLocation(90, 410);
    goToDetail.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
        //TODO
        //this is the currently displayed timepoint
        //parser.getTimepoints().get(current_id);
      }
    });
    add(goToDetail);

    newest = new JLabel();
    newest.setSize(60, 60);
    newest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/next.png")));
    newest.setLocation(597, 410);
    newest.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
          updateData(parser.getLastTimepoint());
      }
    });
    next = new JLabel();
    next.setSize(60, 60);
    next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/next.png")));
    next.setLocation(527, 410);
    next.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
        int last_id_in_list = parser.getLastTimepoint().get(0).getId();
        int first_id_in_list = parser.getFirstTimepoint().get(0).getId();

        if(current_id < first_id_in_list)
          updateData(parser.getFirstTimepoint());
        else if(current_id == last_id_in_list)
          updateData(parser.getLastTimepoint());
        else
          updateData(parser.getTimepoints().get(current_id - first_id_in_list + 1));
      }
    });
    prev = new JLabel();
    prev.setSize(60, 60);
    prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/prev.png")));
    prev.setLocation(10, 410);
    prev.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
        int first_id_in_list = parser.getFirstTimepoint().get(0).getId();

        if(current_id <= first_id_in_list + 1)
          updateData(parser.getFirstTimepoint());
        else
          updateData(parser.getTimepoints().get(current_id - first_id_in_list - 1));

      }
    });

    add(newest);
    add(next);
    add(prev);

    setAllBackgrounds(this,Color.black);
    setAllForegrounds(this,MainFrame.getForegroundColor());
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

  private void setAllForegrounds(Component component, Color color) {
    component.setForeground(color);

    if (component instanceof Container) {
      for (Component child : ((Container) component).getComponents()) {
          setAllForegrounds(child, color);
      }
    }
  }

  void setAbsInputs(List<Float[]> inputList) {
    this.inputs = inputList;
  }

  void setTimes(List<String> timelist) {
    this.times = timelist;
  }
}
