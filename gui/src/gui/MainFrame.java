/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elements.DataDisplayBottom;
import elements.DataDisplayRight;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import xmlparser.ObservableParser;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class MainFrame extends JFrame implements ObservableParser.Observer{
    private MainPanel graphPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private JPanel buttonPanel;
    private DataDisplayRight[] inputs;
    private DataDisplayBottom[] outputs;
    private ObservableParser xmlparser;
  private JLabel testlabel;
    
    public MainFrame(){
        initComponents();
        String[] files = new String[4];
        files[0] = "resources/controller_ISDN.xml";
        files[1] = "resources/controller_NEP.xml";
        files[2] = "resources/controller_DPM.xml";
        files[3] = "resources/controller_VOL.xml";
        xmlparser = new ObservableParser(files);
        xmlparser.addObserver(this);
        xmlparser.start();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());

        
        graphPanel = new MainPanel();
        GridBagConstraints c = new GridBagConstraints();
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(graphPanel, c);
        
        
        inputPanel = new JPanel();
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(inputPanel, c);
        fillInputPanel(inputPanel);
        
        outputPanel = new JPanel();
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(outputPanel, c);
        fillOutputPanel(outputPanel);
        
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.pink);
        // c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(buttonPanel, c);

        testlabel = new JLabel();
        testlabel.setText("init");
        buttonPanel.add(testlabel);
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
        for(int i = 0; i < inputs.length ;i++){
            inputs[i] = new DataDisplayRight();
            inputs[i].setCaption("MVP");
        }
        

        for(int i = 0; i < inputs.length ;i++){
            c.gridx = 0;
            c.gridy = i;
            inputPanel.add(inputs[i], c);
        }
    }

    private void fillOutputPanel(JPanel outputPanel) {
        outputPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
	
        outputs = new DataDisplayBottom[4];
        for(int i = 0; i < outputs.length ;i++){
            outputs[i] = new DataDisplayBottom();
            //outputs[i].setCaption("test").setUnit("km/h").setValue(42).setValue(32);
            outputs[i].addClickListener(new DataDisplayBottom.ClickListener() {
              public void onClick(DataDisplayBottom sender) {
                  sender.setHighlight(true);
              }
            });
        }
        c.gridx = 0;
        c.gridy = 0;
        outputPanel.add(new JPanel(), c);
        for(int i = 0; i < outputs.length ;i++){
            c.gridx = i+1;
            c.gridy = 0;
            outputPanel.add(outputs[i], c);
        }
    }

  public void update(ObservableParser parser) {
    List<List<Timepoint>> points = parser.getTimepoints();
    List<Timepoint> p = points.get(points.size()-1);
    Timepoint t = p.get(0);
    testlabel.setText(Integer.toString(t.getId()));
    double v;
    for(int i = 0; i < inputs.length ;i++){
        v = t.getInputs().get(i);   //inputs are always the same
        inputs[i].setValue((float)v);
    }
    for(int i = 0; i < outputs.length ;i++){
        v = p.get(i).getOutput();
        outputs[i].setValue((float)v);
    }
  }
}   
