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
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private JPanel backPanel;
    private JLabel backLabel;
    private MainPanel parent;
    private int currentOutput;

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

    void setTargetValues(List<Double> targets)
    {
        for(int i = 0; i < targets.size(); i++){
            graphs[i].setTargetValue(targets.get(i));
        }
    }

    void showOutput(int id)
    {
        currentOutput = id;
    }

    private void initComponents() {
        setBackground(Color.black);
        setLayout(null);
        
        mainDetailPanel = new JPanel();
        System.out.println(this.getWidth());
        Dimension dim = new Dimension((this.getWidth() / 5) * 4, (this.getHeight() / 5) * 4);
        mainDetailPanel.setSize(dim);
        mainDetailPanel.setPreferredSize(dim);
        mainDetailPanel.setMinimumSize(dim);
        mainDetailPanel.setMaximumSize(dim);
        mainDetailPanel.setLocation(0, 0);
        
        mainDetailPanel.setBackground(Color.red);
        mainDetailPanel.setLayout(null);
        
        
        graphs = new Graph[5];
        int gH = ((this.getHeight() / 5) * 4) / 5;
        for(int i = 0; i < 5; i++){
            graphs[i] = new Graph((this.getWidth() / 5) * 4, gH);
            graphs[i].setLocation(0, (gH + 1)* i);
            graphs[i].setSteps(50);
            mainDetailPanel.add(graphs[i]);
        }

        graphs[0].setMax((float) 120.0).setMin((float) 90.0);
        graphs[1].setMax((float) 2.5).setMin((float) 1.5);
        graphs[2].setMax((float) 2.5).setMin((float) 1.5);
        graphs[3].setMax((float) 60.0).setMin((float) 40.0);
        System.out.println(this.getHeight());
        
        add(mainDetailPanel);
        
        inputPanel = new JPanel();
        dim = new Dimension((this.getWidth() / 5), (this.getHeight() / 5) * 4);
        inputPanel.setSize(dim);
        inputPanel.setPreferredSize(dim);
        inputPanel.setMinimumSize(dim);
        inputPanel.setMaximumSize(dim);
        inputPanel.setLocation((this.getWidth() / 5) * 4, 0);
        
        inputPanel.setBackground(Color.blue);

        inputPanel.setLayout(null);
        inputs = new DataDisplayInput[4];

        for (int i = 0; i < inputs.length; i++) {
          inputs[i] = new DataDisplayInput((this.getWidth() / 5), (this.getHeight() / 5));
          inputs[i].setLocation(0, i * (this.getHeight() / 5));
          inputs[i].setType(InputEnum.get(results.getSelected_drugs()[i]));
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
        
        outputPanel.setBackground(Color.green);

        outputPanel.setLayout(null);

        outputs = new DataDisplayOutput[4];
        for (int i = 0; i < outputs.length; i++) {
          outputs[i] = new DataDisplayOutput((this.getWidth() / 5), (this.getHeight() / 5));
          outputs[i].setLocation(i * (this.getWidth() / 5), 0);
          outputs[i].setType(OutputEnum.get(results.getSelected_drugs()[i]));
          outputPanel.add(outputs[i]);
        }
        
        add(outputPanel);

        backPanel = new JPanel();
        backPanel.setLayout(null);
        backPanel.setLocation((this.getWidth() / 5) * 4, (this.getHeight() / 5) * 4);
        dim = new Dimension((this.getWidth() / 5), (this.getHeight() / 5));
        backPanel.setSize(dim);
        backPanel.setPreferredSize(dim);
        backPanel.setMinimumSize(dim);
        backPanel.setMaximumSize(dim);
        backPanel.setBackground(Color.black);

        backLabel = new JLabel("<-");
        backLabel.setFont(new Font("Dialog", 1, 36));
        backLabel.setForeground(Color.green);
        backLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //backLabel.setBackground(Color.red);
        backLabel.setLocation(0, 0);
        backLabel.setSize(dim);
        backLabel.setPreferredSize(dim);
        backLabel.setMinimumSize(dim);
        backLabel.setMaximumSize(dim);
        backLabel.addMouseListener(new SimpleClickHandler(){
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.showInputGraphs();
            }});
        backPanel.add(backLabel);

        add(backPanel);
    }

    public void updateDetailGraphs(ArrayList<ArrayList<Float>> lists, List<Float[]> inputList, List<Float[]> outputList, int id){
        for(int i = 0; i < lists.size(); i++){
            graphs[i].showValues(lists.get(i));
        }
        
        // TODO set output graph
        //graphs[graphs.length].showValues();

        for(int i = 0; i < inputs.length; i++){
            inputs[i].setValue(inputList.get(id)[i]);
            outputs[i].setValue(outputList.get(id)[i]);
        }
    }
}

