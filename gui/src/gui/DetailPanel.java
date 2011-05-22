/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DetailPanel.java
 *
 * Created on 18.05.2011, 14:18:10
 */
package gui;

import elements.Graph;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author max
 */
public class DetailPanel extends javax.swing.JPanel {
    private JPanel mainDetailPanel;
    private JPanel inputPanel;
    private JPanel outputPanel;
    private Graph[] graphs;

    /** Creates new form DetailPanel */
    public DetailPanel(int awidth, int aheight) {
        Dimension dim = new Dimension(awidth, aheight);
        setMinimumSize(dim);
        setSize(dim);
        setPreferredSize(dim);
        setMaximumSize(dim);
        
        initComponents();
    }

    private void initComponents() {
        setBackground(Color.black);
        setLayout(null);
        
        mainDetailPanel = new JPanel();
        System.out.println(this.getWidth());
        Dimension dim = new Dimension((this.getWidth() / 6) * 5, (this.getHeight() / 6) * 5);
        mainDetailPanel.setSize(dim);
        mainDetailPanel.setPreferredSize(dim);
        mainDetailPanel.setMinimumSize(dim);
        mainDetailPanel.setMaximumSize(dim);
        mainDetailPanel.setLocation(0, 0);
        
        mainDetailPanel.setBackground(Color.red);
        mainDetailPanel.setLayout(null);
        
        
        graphs = new Graph[5];
        for(int i = 0; i < 5; i++){
            graphs[i] = new Graph((this.getWidth() / 6) * 5, (this.getHeight() / 6));
            graphs[i].setLocation(0, (this.getHeight() / 6) * i);
            mainDetailPanel.add(graphs[i]);
            System.out.println((this.getHeight() / 6) * i);
        }
        System.out.println(this.getHeight());
        
        add(mainDetailPanel);
        
        inputPanel = new JPanel();
        dim = new Dimension((this.getWidth() / 6), (this.getHeight() / 6) * 5);
        inputPanel.setSize(dim);
        inputPanel.setPreferredSize(dim);
        inputPanel.setMinimumSize(dim);
        inputPanel.setMaximumSize(dim);
        inputPanel.setLocation((this.getWidth() / 6) * 5, 0);
        
        inputPanel.setBackground(Color.blue);
        
        add(inputPanel);
        
        outputPanel = new JPanel();
        dim = new Dimension((this.getWidth() / 6) * 5, (this.getHeight() / 6));
        outputPanel.setSize(dim);
        outputPanel.setPreferredSize(dim);
        outputPanel.setMinimumSize(dim);
        outputPanel.setMaximumSize(dim);
        outputPanel.setLocation(0, (this.getHeight() / 6) * 5);
        
        outputPanel.setBackground(Color.green);
        
        add(outputPanel);
    }
}
