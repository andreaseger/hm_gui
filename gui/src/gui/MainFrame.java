/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elements.DataDisplayBottom;
import elements.DataDisplayRight;
import fisparser.Rule;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
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
  private DataDisplayRight[] inputs;
  private DataDisplayBottom[] outputs;
  private ObservableParser xmlparser;
  private JLabel testlabel;
  private List<String> timeList;
  private List<Float[]> inputList;
  private List<Float[]> outputList;
  private List<List<Rule>> rules;
  private JLabel pause;
  private Icon ipause;
  private Icon iplay;
  private boolean bpause;

  public MainFrame() {
    initComponents();
    startParser();
  }

  private void initComponents() {
    setLayout(null);

    graphPanel = new MainPanel();
    graphPanel.setLocation(0, 0);
    graphPanel.setSize(667, 480);

//    GridBagConstraints c = new GridBagConstraints();
//    // c.fill = GridBagConstraints.HORIZONTAL;
//    c.gridx = 0;
//    c.gridy = 0;
    this.add(graphPanel);


    inputPanel = new JPanel();
    inputPanel.setLocation(668, 0);
    inputPanel.setSize(133, 480);
    // c.fill = GridBagConstraints.HORIZONTAL;
//    c.gridx = 1;
//    c.gridy = 0;
    this.add(inputPanel);
    fillInputPanel(inputPanel);

    outputPanel = new JPanel();
    outputPanel.setLocation(0, 480);
    outputPanel.setSize(667, 120);
    // c.fill = GridBagConstraints.HORIZONTAL;
//    c.gridx = 0;
//    c.gridy = 1;
    this.add(outputPanel);
    fillOutputPanel(outputPanel);

    buttonPanel = new JPanel();
    buttonPanel.setLocation(668, 480);
    buttonPanel.setSize(133, 120);
    buttonPanel.setBackground(Color.pink);
    // c.fill = GridBagConstraints.HORIZONTAL;
//    c.gridx = 1;
//    c.gridy = 1;
//    c.weightx = 1.0;
//    c.weighty = 1.0;
    this.add(buttonPanel);
  }

  public static void main(String... args) {
    JFrame frame = new MainFrame();
    frame.setSize(800, 600);
    frame.setResizable(true);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void fillInputPanel(JPanel inputPanel) {
    inputPanel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    inputs = new DataDisplayRight[4];
    c.gridx = 0;
    for (int i = 0; i < inputs.length; i++) {
      inputs[i] = new DataDisplayRight(133, 120);
      inputs[i].setCaption("MVP");
      c.gridy = i;
      if (i == inputs.length-1) {
        c.weighty=1.0;
      }
      inputPanel.add(inputs[i], c);
    }
  }


    private void dehighlightAllOutputs() {
        for(DataDisplayBottom output: this.outputs) {
            output.setHighlight(false);
        }
    }
    
    private void fillOutputPanel(JPanel outputPanel) {
        outputPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
	

    ipause = new javax.swing.ImageIcon(getClass().getResource("/resource/Pause.png"));
    iplay = new javax.swing.ImageIcon(getClass().getResource("/resource/Play.png"));

    pause = new JLabel();
    pause.setBackground(Color.BLACK);
    pause.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent e) {
        if (bpause){
          pause.setIcon(iplay); // NOI18N
          bpause = false;
        }else{
          pause.setIcon(ipause); // NOI18N
          bpause = true;
        }
      }
      public void mousePressed(MouseEvent e) { }
      public void mouseReleased(MouseEvent e) { }
      public void mouseEntered(MouseEvent e) { }
      public void mouseExited(MouseEvent e) { }
    });

    bpause = true;
    pause.setIcon(ipause); // NOI18N
    pause.setSize(133, 120);
    outputPanel.add(pause);
    //outputPanel.setBackground(Color.black);

    outputs = new DataDisplayBottom[4];
    for (int i = 0; i < outputs.length; i++) {
      outputs[i] = new DataDisplayBottom(133,120);
      outputs[i].addClickListener(new DataDisplayBottom.ClickListener() {
        public void onClick(DataDisplayBottom sender) {
          dehighlightAllOutputs();
          sender.setHighlight(true);
        }
      });
    }
    c.gridx = 0;
    c.gridy = 0;
    outputPanel.add(new JPanel(), c);
    for (int i = 0; i < outputs.length; i++) {
      c.gridx = i + 1;
      if (i == outputs.length-1) {
        c.weightx=1.0;
      }
      outputPanel.add(outputs[i], c);
    }
  }

  public void update(ObservableParser parser) {
    List<List<Timepoint>> points = parser.getTimepoints();
    List<Timepoint> p = points.get(points.size() - 1);
    Timepoint t = p.get(0);

    setTitle(Integer.toString(t.getId()));

    //double v;

    float tmp;

    for (int i = 0; i < inputs.length; i++) {
      //v = t.getInputs().get(i);   //inputs are always the same
      tmp = inputList.get(t.getId())[i];
      inputs[i].setValue(tmp);
    }

    for (int i = 0; i < outputs.length; i++) {
      tmp = outputList.get(t.getId())[i];
      //v = p.get(i).getOutput();
      outputs[i].setValue(tmp);
    }

  }

  private void startParser() {
    String[] files = new String[4];
    files[0] = "resources/controller_ISDN.xml";
    files[1] = "resources/controller_NEP.xml";
    files[2] = "resources/controller_DPM.xml";
    files[3] = "resources/controller_VOL.xml";
    xmlparser = new ObservableParser(files);
    xmlparser.addObserver(this);
    logparser.Parser lparser = new logparser.Parser();
    fisparser.Parser fparser = new fisparser.Parser();
    try {
      lparser.run("resources/controller.log");
      String[] ffiles = new String[4];
      ffiles[0] = "resources/cavacoMamdaniISDNChange.fis";
      ffiles[1] = "resources/cavacoMamdaniNEPChange.fis";
      ffiles[2] = "resources/cavacoMamdaniDPMChange.fis";
      ffiles[3] = "resources/cavacoMamdaniVolChange.fis";
      fparser.run(ffiles);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    inputList = lparser.getInputs();
    outputList = lparser.getOutputs();
    timeList = lparser.getTimestamps();
    rules = fparser.getAllRules();
    xmlparser.start();
  }
}
