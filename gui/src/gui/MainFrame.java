/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elements.DataDisplayOutput;
import elements.DataDisplayInput;
import fisparser.Rule;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import xmlparser.ObservableParser;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class MainFrame extends JFrame implements ObservableParser.Observer {

  private MainPanel graphPanel;
  private JPanel inputPanel;
  private JPanel outputPanel;
  private JPanel buttonPanel;
  private DataDisplayInput[] inputs;
  private DataDisplayOutput[] outputs;
  private ObservableParser xmlparser;
  //private List<String> timeList;
  private List<Float[]> inputList;
  private List<Float[]> outputList;
  private JLabel lpause;
  private boolean pause;
  private Icon ipause;
  private Icon iplay;
  private static final Color foregroundColor = new Color(51, 204, 0);
  private static final Color highlightColor = new Color(0, 80, 0);
  private FuzzyPanel fuzzyPanel;
  private EnumMap<OutputEnum, List<Rule>> rules;
  private JLabel settingsLabel;
  private JLabel fuzzyLabel;

  public MainFrame() {
    initComponents();
    startParser();
  }

  private void initComponents() {
    loadPlayPauseGfx();
    setLayout(null);
    this.getContentPane().setBackground(Color.BLACK);

    graphPanel = new MainPanel();
    graphPanel.setBackground(Color.BLACK);
    graphPanel.setLocation(0, 0);
    graphPanel.setSize(667, 480);
    graphPanel.setVisible(false);
    this.add(graphPanel);

    inputPanel = new JPanel();
    inputPanel.setBackground(Color.BLACK);
    inputPanel.setLocation(667, 0);
    inputPanel.setSize(133, 480);
    this.add(inputPanel);
    fillInputPanel(inputPanel);

    addPauseButton();

    outputPanel = new JPanel();
    outputPanel.setBackground(Color.BLACK);
    outputPanel.setLocation(133, 480);
    outputPanel.setSize(532, 120);
    this.add(outputPanel);
    fillOutputPanel(outputPanel);

    buttonPanel = new JPanel();
    buttonPanel.setLocation(667, 480);
    buttonPanel.setSize(133, 120);
    buttonPanel.setBackground(Color.BLACK);
    fillButtonPanel(buttonPanel);
    this.add(buttonPanel);

    fuzzyPanel = new FuzzyPanel(rules, new String[]{"Rule#",
                                            InputEnum.MAP.getName(),
                                            InputEnum.SVR.getName(),
                                            InputEnum.CVP.getName(),
                                            InputEnum.CO.getName(),
                                            "Outputset"});
    fuzzyPanel.setLocation(0, 0);
    fuzzyPanel.setSize(667, 480);
    fuzzyPanel.setVisible(true);
    this.add(fuzzyPanel);
  }

  public static void main(String... args) {
    JFrame frame = new MainFrame();
    frame.setSize(800, 600);
    frame.setLocation(10, 10);

    frame.setResizable(true);
    //frame.setUndecorated(true);   //with this you cant move the window, but all sizes fit well

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void fillInputPanel(JPanel inputPanel) {
    inputPanel.setLayout(null);
    inputs = new DataDisplayInput[4];

    for (int i = 0; i < inputs.length; i++) {
      inputs[i] = new DataDisplayInput(133, 120);
      inputs[i].setLocation(0, i * 120);
      inputs[i].setCaption(InputEnum.get(i).getName());
      inputs[i].setUnit(InputEnum.get(i).getUnit());
      inputPanel.add(inputs[i]);
    }
  }

  private void dehighlightAllOutputs() {
    for (DataDisplayOutput output : this.outputs) {
      output.setHighlight(false);
    }
  }

  private void addPauseButton() {
    lpause = new JLabel();
    lpause.addMouseListener(new MouseListener() {

      public void mouseClicked(MouseEvent e) {
        if (pause) {
          lpause.setIcon(ipause);
          pause = false;
        } else {
          lpause.setIcon(iplay);
          pause = true;
        }
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

    pause = false;
    lpause.setIcon(ipause); // NOI18N
    lpause.setSize(133, 120);
    lpause.setLocation(0, 480);
    this.add(lpause);
  }

  private void fillOutputPanel(JPanel outputPanel) {
    outputPanel.setLayout(null);

    outputs = new DataDisplayOutput[4];
    for (int i = 0; i < outputs.length; i++) {
      outputs[i] = new DataDisplayOutput(133, 120);
      outputs[i].addClickListener(new DataDisplayOutput.ClickListener() {
        public void onClick(DataDisplayOutput sender) {
          dehighlightAllOutputs();
          sender.setHighlight(true);
        }
      });
      outputs[i].setLocation(i * 133, 0);
      outputs[i].setCaption(OutputEnum.get(i).getName());
      outputs[i].setUnit(OutputEnum.get(i).getUnit());
      outputPanel.add(outputs[i]);
    }
  }

  private void loadPlayPauseGfx() {
    ipause = new javax.swing.ImageIcon(getClass().getResource("/resource/Pause.png"));
    iplay = new javax.swing.ImageIcon(getClass().getResource("/resource/Play.png"));
  }

  public void update(ObservableParser parser) {
    List<List<Timepoint>> timepoints = parser.getTimepoints();
    List<Timepoint> p = timepoints.get(timepoints.size()-1);
    int id = p.get(0).getId();
    // HACK
    setTitle(Integer.toString(id));

    float tmp;

    for (int i = 0; i < inputs.length; i++) {
      tmp = inputList.get(id)[i];
      inputs[i].setValue(tmp);
    }

    for (int i = 0; i < outputs.length; i++) {
      tmp = outputList.get(id)[i];
      outputs[i].setValue(tmp);
    }

    //fuzzyPanel.updateData(p, OutputEnum.ISDN); //send newest point to fuzzypanel

  }

  private void startParser() {
    xmlparser = new ObservableParser(OutputEnum.VOL.getXMLPath(),
      OutputEnum.DPM.getXMLPath(),
      OutputEnum.NEP.getXMLPath(),
      OutputEnum.ISDN.getXMLPath());
    xmlparser.addObserver(this);
    logparser.Parser lparser = new logparser.Parser();
    fisparser.Parser fparser = new fisparser.Parser();
    try {
      lparser.run("resources/controller.log");
      fparser.run(OutputEnum.VOL.getFisPath(),
        OutputEnum.DPM.getFisPath(),
        OutputEnum.NEP.getFisPath(),
        OutputEnum.ISDN.getFisPath());
    } catch (FileNotFoundException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    inputList = lparser.getInputs();
    outputList = lparser.getOutputs();
    //timeList = lparser.getTimestamps();
    rules = fparser.getAllRules();
    fuzzyPanel.setRules(rules);
    fuzzyPanel.setParser(xmlparser);
    xmlparser.start();
  }

  private void fillButtonPanel(JPanel buttonPanel) {
    buttonPanel.setLayout(null);

    settingsLabel = new JLabel();
    settingsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Settings.png")));
    settingsLabel.setSize(66, 60);
    settingsLabel.setLocation(66, 0);
    buttonPanel.add(settingsLabel);

    fuzzyLabel = new JLabel();
    fuzzyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Fuzzy.png")));
    fuzzyLabel.setSize(66, 60);
    fuzzyLabel.setLocation(0, 60);
    fuzzyLabel.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent e) {
        if(fuzzyLabel.getBackground() == Color.black){
          fuzzyLabel.setBackground(highlightColor);
          graphPanel.setVisible(false);
          fuzzyPanel.setVisible(true);
          List<List<Timepoint>> t = xmlparser.getTimepoints();
          fuzzyPanel.updateData(t.get(t.size()-1), OutputEnum.ISDN);
        }else{
          fuzzyLabel.setBackground(Color.black);
          graphPanel.setVisible(true);
          fuzzyPanel.setVisible(false);
        }
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

    buttonPanel.add(fuzzyLabel);

    JLabel powerLabel = new JLabel();
    powerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Power.png")));
    powerLabel.setSize(66, 60);
    powerLabel.setLocation(66, 60);
    buttonPanel.add(powerLabel);
  }
  
  public static Color getForegroundColor() {
    return foregroundColor;
  }
  public static Color getHighlightColor() {
    return highlightColor;
  }
}
