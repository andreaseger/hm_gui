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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sch1zo
 */
public class MainFrame extends JFrame{
    private DataDisplayRight input1;
    private DataDisplayRight input2;
    private DataDisplayRight input3;
    private DataDisplayRight input4;
    
    public MainFrame(){
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());

        
        JPanel graphPanel = new MainPanel();
	GridBagConstraints c = new GridBagConstraints();
	// c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(graphPanel, c);
        
        
        JPanel inputPanel = new JPanel();
	// c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(inputPanel, c);
        fillInputPanel(inputPanel);
        
        JPanel outputPanel = new JPanel();
	// c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.add(outputPanel, c);
        fillOutputPanel(outputPanel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.pink);
	// c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        this.add(buttonPanel, c);         
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
	
        DataDisplayRight[] inputs = new DataDisplayRight[4]; 
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
	
        DataDisplayBottom[] outputs = new DataDisplayBottom[4];
        for(int i = 0; i < outputs.length ;i++){
            outputs[i] = new DataDisplayBottom();
            outputs[i].setCaption("test").setUnit("km/h").setValue(42).setValue(32);
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
}   
