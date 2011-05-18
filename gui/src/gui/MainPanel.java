/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elements.Graph;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.geom.Dimension2D;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author sch1zo
 */
public class MainPanel extends JPanel {
    public MainPanel(){
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        Graph[] graphs = new Graph[4];
        c.gridx = 0;
        for(int i=0;i<graphs.length;i++){
            graphs[i] = new Graph();
            c.gridy = i;
            graphs[i].setMinimumSize(new Dimension(667,120));
            graphs[i].setSize(667, 120);
            graphs[i].setPreferredSize(new Dimension(667,120));
            add(graphs[i],c);
        }
    }
}
