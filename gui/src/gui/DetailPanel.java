/*
 * DetailPanel.java
 *
 * Created on 18.05.2011, 14:18:10
 */
package gui;

import elements.DataDisplayInput;
import elements.DataDisplayOutput;
import elements.Graph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import setup.Result;

/**
 *
 * @author max
 */
public class DetailPanel extends javax.swing.JPanel {
    private JPanel mainDetailPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private Graph[] graphs;
    private DataDisplayInput[] inputs;
    private Result results;
    private DataDisplayOutput[] outputs;
    private JLabel backButton;
    private MainPanel parent;
    private int currentOutput;
  private JPanel buttonPanel;
  private JLabel fuzzyButton;
  private JLabel backLabel;
  private JLabel fuzzyLabel;

    /** Creates new form DetailPanel */
    public DetailPanel(int awidth, int aheight, Result aResults, MainPanel par) {
        Dimension dim = new Dimension(awidth, aheight);
        setMinimumSize(dim);
        setSize(dim);
        setPreferredSize(dim);
        setMaximumSize(dim);

        results = aResults;
        parent = par;
        currentOutput = -1;
        initComponents();
    }

    void setOutput(int idx)
    {
        dehighlight();
        currentOutput = idx;
        outputs[idx].setHighlight(true);
    }

    void setTargetValues(List<Double> targets)
    {
        for(int i = 0; i < targets.size(); i++){
            graphs[i].setTargetValue(targets.get(i));
        }
    }

    private void initComponents() {
        setBackground(Color.black);
        setLayout(null);
        
        mainDetailPanel = new JPanel();
//        System.out.println(this.getWidth());
        Dimension dim = new Dimension((this.getWidth() / 5) * 4, (this.getHeight() / 5) * 4);
        mainDetailPanel.setSize(dim);
        mainDetailPanel.setPreferredSize(dim);
        mainDetailPanel.setMinimumSize(dim);
        mainDetailPanel.setMaximumSize(dim);
        mainDetailPanel.setLocation(0, 0);
        
        mainDetailPanel.setBackground(new Color(0, 64, 0));
        mainDetailPanel.setLayout(null);
        
        
        graphs = new Graph[5];
        int gH = ((this.getHeight() / 5) * 4) / 5;
        for(int i = 0; i < 5; i++){
            graphs[i] = new Graph((this.getWidth() / 5) * 4, gH);
            graphs[i].setLocation(0, (gH + 1)* i);
            graphs[i].setSteps(150);
            mainDetailPanel.add(graphs[i]);
        }
        graphs[4].setGraphColor(new Color(190, 190, 0));
        graphs[4].setShowTarget(false);

        graphs[0].setMax((float) 120.0).setMin((float) 90.0);
        graphs[1].setMax((float) 2.5).setMin((float) 1.5);
        graphs[2].setMax((float) 2.5).setMin((float) 1.5);
        graphs[3].setMax((float) 60.0).setMin((float) 40.0);
//        System.out.println(this.getHeight());
        
        add(mainDetailPanel);
        
        inputPanel = new JPanel();
        dim = new Dimension((this.getWidth() / 5), (this.getHeight() / 5) * 4);
        inputPanel.setSize(dim);
        inputPanel.setPreferredSize(dim);
        inputPanel.setMinimumSize(dim);
        inputPanel.setMaximumSize(dim);
        inputPanel.setLocation((this.getWidth() / 5) * 4, 0);
        
        inputPanel.setBackground(Color.red);

        inputPanel.setLayout(null);
        inputs = new DataDisplayInput[4];

        for (int i = 0; i < inputs.length; i++) {
          inputs[i] = new DataDisplayInput((this.getWidth() / 5)-1, (this.getHeight() / 5)-1);
          inputs[i].setLocation(1, i * (this.getHeight() / 5));
          inputs[i].setType(InputEnum.get(results.getSelected_inputs()[i]));
          inputPanel.add(inputs[i]);
        }
        
        add(inputPanel);
        
        outputPanel = new JPanel();
        dim = new Dimension((this.getWidth() / 5) * 4, (this.getHeight() / 5));
        outputPanel.setSize(dim);
        outputPanel.setPreferredSize(dim);
        outputPanel.setMinimumSize(dim);
        outputPanel.setMaximumSize(dim);
        outputPanel.setLocation(0, (this.getHeight() / 5) * 4);
        
        outputPanel.setBackground(Color.red);

        outputPanel.setLayout(null);

        outputs = new DataDisplayOutput[4];
        for (int i = 0; i < outputs.length; i++) {
          outputs[i] = new DataDisplayOutput((this.getWidth() / 5)-1, (this.getHeight() / 5)-1);
          outputs[i].setLocation(i * (this.getWidth() / 5), 1);
          outputs[i].setType(OutputEnum.get(results.getSelected_drugs()[i]));
          outputPanel.add(outputs[i]);
        }
        
        add(outputPanel);

        buttonPanel = new JPanel();
        buttonPanel.setLocation((this.getWidth() / 5) * 4, (this.getHeight() / 5) * 4);
        buttonPanel.setSize((this.getWidth() / 5), (this.getHeight() / 5));
        buttonPanel.setBackground(Color.BLACK);
        fillButtonPanel(buttonPanel);
        add(buttonPanel);
    }

    public void dehighlight() {
        for (DataDisplayOutput output : this.outputs) {
          output.setHighlight(false);
        }
      }

    public void updateDetailGraphs(ArrayList<ArrayList<Float>> lists, List<Float[]> inputList, List<Float[]> outputList, int id){
        for(int i = 0; i < lists.size(); i++){
            graphs[i].showValues(lists.get(i));
        }

        if(currentOutput >= 0){
            ArrayList<Float> out = new ArrayList<Float>();
            for(int i = 0; i < outputList.size() && i < id; i++){
                out.add(outputList.get(i)[currentOutput]);
            }
            graphs[4].showValues(out);
        }
        
        // TODO set output graph
        //graphs[graphs.length].showValues();

        for(int i = 0; i < inputs.length; i++){
            inputs[i].setValue(inputList.get(id)[i]);
            outputs[i].setValue(outputList.get(id)[i]);
        }
    }

  private void fillButtonPanel(JPanel buttonPanel) {
    buttonPanel.setLayout(null);
    Dimension dim = new Dimension(buttonPanel.getSize().width/2,buttonPanel.getSize().height-10);

    backButton = new JLabel();
    backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/back_to_overview.png")));
    backButton.setLocation(0, 5);
    backButton.setSize(dim);
    backButton.setVerticalAlignment(SwingConstants.TOP);
    backButton.setHorizontalAlignment(SwingConstants.CENTER);
    backButton.addMouseListener(new SimpleClickHandler(){
        @Override
        public void mouseClicked(MouseEvent e) {
            parent.showInputGraphs();
        }
      @Override
      public void mouseEntered(MouseEvent e) {
        backLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        backLabel.setVisible(false);
      }
    });
    backLabel = new JLabel("<html>Zurück<br/>zur<br/>Übersicht</html>");
    backLabel.setForeground(MainFrame.getForegroundColor());
    backLabel.setLocation(0, 5);
    backLabel.setSize(dim);
    backLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    backLabel.setHorizontalAlignment(SwingConstants.CENTER);
    backLabel.setVisible(false);

    buttonPanel.add(backLabel);
    buttonPanel.add(backButton);

    fuzzyButton = new JLabel();
    fuzzyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/fuzzy.png")));
    fuzzyButton.setSize(dim);
    fuzzyButton.setLocation(60,5);
    fuzzyButton.setVerticalAlignment(SwingConstants.TOP);
    fuzzyButton.setHorizontalAlignment(SwingConstants.CENTER);
    fuzzyButton.addMouseListener(new SimpleClickHandler() {
      @Override
      public void mouseClicked(MouseEvent e) {
        parent.parent.showFuzzy();
      }
      @Override
      public void mouseEntered(MouseEvent e) {
        fuzzyLabel.setVisible(true);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        fuzzyLabel.setVisible(false);
      }
    });
    fuzzyLabel = new JLabel("<html>Fuzzy-<br/>anzeige</html>");
    fuzzyLabel.setForeground(MainFrame.getForegroundColor());
    fuzzyLabel.setSize(dim);
    fuzzyLabel.setLocation(60,5);
    fuzzyLabel.setVerticalAlignment(SwingConstants.BOTTOM);
    fuzzyLabel.setHorizontalAlignment(SwingConstants.CENTER);
    fuzzyLabel.setAlignmentX(CENTER_ALIGNMENT);
    fuzzyLabel.setVisible(false);

    buttonPanel.add(fuzzyLabel);
    buttonPanel.add(fuzzyButton);
  }
}

