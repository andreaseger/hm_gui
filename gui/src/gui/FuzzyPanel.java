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
import java.util.EnumMap;
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
  private JLabel goToOverviewLabel;
  private final MainFrame parent;
  private JLabel goToDetailLabel;
  private JPanel controls;
  private JLabel prevLabel;
  private JLabel nextLabel;
  private JLabel newestLabel;
  private JLabel goToDetail;
  private JLabel goToOverview;
  private JPanel buttonpanel;

  /** Creates new form FuzzyPanel */
  FuzzyPanel(EnumMap<OutputEnum, List<Rule>> rules, String[] header, MainFrame par) {
    this.rules = rules;
    parent = par;
    fdata = new FuzzyData(header);
    initComponents();
  }

  FuzzyPanel(EnumMap<OutputEnum, List<Rule>> rules, String[] header, OutputEnum output_type, MainFrame par) {
    this.rules = rules;
    parent = par;
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
    int first_id_in_list = parser.getFirstTimepoint().get(0).getId();
    List<Timepoint> p = parser.getTimepoints().get(current_id - first_id_in_list);
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
    
    rulesTable = new JTable(fdata);//new JTable(fdata);
    rulesTable.setLocation(39, 180);
    rulesTable.setSize(589, 180);
    rulesTable.setGridColor(Color.DARK_GRAY);
    rulesTable.setColumnSelectionAllowed(false);
    rulesTable.setRowSelectionAllowed(false);
    rulesTable.setCellSelectionEnabled(false);

    for (int i = 0; i < fdata.getColumnCount(); i++){
       javax.swing.table.TableColumn column = rulesTable.getColumnModel().getColumn(i);
       column.setCellRenderer(new ColorCellRenderer());
    }

    rulesTable.getTableHeader().setLocation(39, 155);
    rulesTable.getTableHeader().setSize(589, 25);
    rulesTable.getTableHeader().setResizingAllowed(false);
    rulesTable.getTableHeader().setReorderingAllowed(false);
    rulesTable.getTableHeader().setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));

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

    buttonpanel = new JPanel();
    buttonpanel.setSize(410, 60);
    buttonpanel.setLocation(0, 410);
    fillButtonPanel(buttonpanel);
    add(buttonpanel);

    controls = new JPanel();
    controls.setSize(250, 60);
    controls.setLocation(417, 410);
    fillControlPanel(controls);
    add(controls);


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

  public void setCurrent_id(int current_id) {
    this.current_id = current_id;
  }

  private void fillControlPanel(JPanel controls) {
    controls.setLayout(null);

    prev = new JLabel();
    prev.setSize(60, 60);
    prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/prev.png")));
    prev.setVerticalAlignment(SwingConstants.TOP);
    prev.setLocation(5, 0);
    prev.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
        int first_id_in_list = parser.getFirstTimepoint().get(0).getId();

        if(current_id <= first_id_in_list + 1)
          updateData(parser.getFirstTimepoint());
        else
          updateData(parser.getTimepoints().get(current_id - first_id_in_list - 1));
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        prevLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        prevLabel.setVisible(false);
      }
    });

    next = new JLabel();
    next.setSize(60, 60);
    next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/next.png")));
    next.setVerticalAlignment(SwingConstants.TOP);
    next.setLocation(95, 0);
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
      @Override
      public void mouseEntered(MouseEvent e) {
        nextLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        nextLabel.setVisible(false);
      }
    });

    newest = new JLabel();
    newest.setSize(60, 60);
    newest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/newest.png")));
    newest.setVerticalAlignment(SwingConstants.TOP);
    newest.setLocation(185, 0);
    newest.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
          updateData(parser.getLastTimepoint());
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        newestLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        newestLabel.setVisible(false);
      }
    });

    prevLabel = new JLabel("zurück");
    prevLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    prevLabel.setLocation(5, 0);
    prevLabel.setSize(60, 60);
    prevLabel.setVisible(false);
    nextLabel = new JLabel("vor");
    nextLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    nextLabel.setLocation(95, 0);
    nextLabel.setSize(60, 60);
    nextLabel.setVisible(false);
    newestLabel = new JLabel("jetzt");
    newestLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    newestLabel.setLocation(185, 0);
    newestLabel.setSize(120, 60);
    newestLabel.setVisible(false);

    controls.add(prev);
    controls.add(next);
    controls.add(newest);

    controls.add(prevLabel);
    controls.add(nextLabel);
    controls.add(newestLabel);
  }

  private void fillButtonPanel(JPanel buttonpanel) {
    buttonpanel.setLayout(null);

    goToDetail = new JLabel();
    goToDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/back_to_details.png")));
    goToDetail.setSize(200, 60);
    goToDetail.setLocation(0, 0);
    goToDetail.setHorizontalAlignment(SwingConstants.CENTER);
    goToDetail.setVerticalAlignment(SwingConstants.TOP);
    goToDetail.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
        parent.unshowFuzzy();
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        goToDetailLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        goToDetailLabel.setVisible(false);
      }
    });
    buttonpanel.add(goToDetail);

    goToOverview = new JLabel();
    goToOverview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/back_to_overview.png")));
    goToOverview.setSize(200, 60);
    goToOverview.setLocation(210, 0);
    goToOverview.setHorizontalAlignment(SwingConstants.CENTER);
    goToOverview.setVerticalAlignment(SwingConstants.TOP);
    goToOverview.addMouseListener(new SimpleClickHandler() {

      @Override
      public void mouseClicked(MouseEvent e) {
        parent.unshowFuzzy();
        parent.showOverview();
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        goToOverviewLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        goToOverviewLabel.setVisible(false);
      }
    });
    buttonpanel.add(goToOverview);

    goToDetailLabel = new JLabel();
    goToDetailLabel.setSize(200, 30);
    goToDetailLabel.setText("Zurück zur Detailansicht");
    goToDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
    goToDetailLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    goToDetailLabel.setLocation(0, 30);
    goToDetailLabel.setVisible(false);
    
    buttonpanel.add(goToDetailLabel);

    goToOverviewLabel = new JLabel();
    goToOverviewLabel.setSize(200, 30);
    goToOverviewLabel.setText("Zurück zur Übersicht");
    goToOverviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    goToOverviewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    goToOverviewLabel.setLocation(210, 30);
    goToOverviewLabel.setVisible(false);


    buttonpanel.add(goToOverviewLabel);
  }
  
}
