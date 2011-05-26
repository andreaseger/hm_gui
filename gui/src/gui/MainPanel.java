/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elements.Graph;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import setup.Result;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class MainPanel extends JPanel {
    
    JPanel graphPanel;
    Graph[] graphs;
    Result results;
    
    DetailPanel detailPanel;
    MainFrame parent;
        
    public MainPanel(Result res, MainFrame par){
        setLayout(null);
        results = res;
        parent = par;
        initComponents();
    }
    

    private void initComponents() {
        graphPanel = new JPanel();
        graphPanel.setLayout(null);
        graphPanel.setVisible(false);
        Dimension dim = new Dimension(667, 480);
        graphPanel.setSize(dim);
        graphPanel.setPreferredSize(dim);
        graphPanel.setMinimumSize(dim);
        graphPanel.setMaximumSize(dim);
        graphPanel.setBackground(Color.red);

        graphs = new Graph[4];
        for(int i=0;i<graphs.length;i++){
            graphs[i] = new Graph(667, 119);
            graphs[i].setLocation(0, 120 * i);
            graphPanel.add(graphs[i]);
            graphs[i].showValues(null);
            graphs[i].setSteps(50);
        }
        graphs[0].setMax((float) 120.0).setMin((float) 90.0);
        graphs[1].setMax((float) 2.5).setMin((float) 1.5);
        graphs[2].setMax((float) 2.5).setMin((float) 1.5);
        graphs[3].setMax((float) 60.0).setMin((float) 40.0);
        
        detailPanel = new DetailPanel(667, 480, results, this);
        detailPanel.setLocation(0, 0);
        detailPanel.setVisible(false);
        
        add(graphPanel);
        add(detailPanel);

        //@TODO echte Target Werte eintragen
        List<Double> targets = new ArrayList<Double>();
        targets.add(105.0);
        targets.add(2.0);
        targets.add(2.0);
        targets.add(50.0);
        setTargetValues(targets);
        

        showInputGraphs();
    }
    
    public void showInputGraphs(){
        detailPanel.setVisible(false);
        graphPanel.setVisible(true);
        parent.dehighlightAllOutputs();
    }
        
    public void showDetails(){
        graphPanel.setVisible(false);
        detailPanel.setVisible(true);
        //detailPanel.showOutput();
    }
    
    void updateInputGraphs(List<Float[]> inputList, List<Float[]> outputList, int id) {

        ArrayList<ArrayList<Float>> lists = new ArrayList<ArrayList<Float>>();
        for(int i = 0; i < 4; i++)
            lists.add(new ArrayList<Float>());

        for(int i = 250; i < id+250; i++){
            Float[] curr = inputList.get(i);
            for(int j = 0; j < curr.length; j++){
                lists.get(j).add(curr[j]);
            }
        }

        for(int i = 0; i < 4; i++){
            graphs[i].showValues(lists.get(i));
        }

        detailPanel.updateDetailGraphs(lists, inputList, outputList, id);
    }

    void setTargetValues(List<Double> targets){
        for(int i = 0; i < targets.size() && i < graphs.length; i++){
            graphs[i].setTargetValue(targets.get(i));
            detailPanel.setTargetValues(targets);
        }
    }
}
