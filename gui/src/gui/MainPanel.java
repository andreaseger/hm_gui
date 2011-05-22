/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elements.Graph;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author sch1zo
 */
public class MainPanel extends JPanel {
    
    JPanel graphPanel;
    Graph[] graphs;
    
    DetailPanel detailPanel;
        
    public MainPanel(){
        initComponents();
    }
    

    private void initComponents() {
        graphPanel = new JPanel();
        graphPanel.setLayout(new GridBagLayout());
               
        GridBagConstraints c = new GridBagConstraints();
        graphs = new Graph[4];
        c.gridx = 0;
        for(int i=0;i<graphs.length;i++){
            graphs[i] = new Graph(667, 120);
            c.gridy = i;
            graphPanel.add(graphs[i],c);
            graphs[i].showValues(null);
        }
        
        detailPanel = new DetailPanel(667, 480);
        
        showInputGraphs();
    }
    
    public void showInputGraphs(){
        remove(detailPanel);
        add(graphPanel);
    }
    
    public void showStartWizard(){
        
    }
    
    public void showDetails(){
        remove(graphPanel);
        add(detailPanel);
    }

    void updateInputGraphs(List<Float[]> inputList, int id) {
        
        ArrayList<ArrayList<Float>> lists = new ArrayList<ArrayList<Float>>();
        
        for(int i = 0; i < 4; i++){
            lists.add(new ArrayList<Float>());
        }
        
        for(int i = 0; i < id; i++){
            
            for(int j = 0; j < 4; j++){
                lists.get(j).add(inputList.get(i+270)[j]);
            }
        }
        
        for(int i = 0; i < 4; i++){
            graphs[i].showValues(lists.get(i));
            //System.out.println("List :" + i + " size: " + (lists.get(i)).size());
        }
    }
}
