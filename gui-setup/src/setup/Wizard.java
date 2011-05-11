/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * Wizard
 * @author noxan
 * @since 0.0.5
 * @version 0.0.7
 */
public class Wizard extends JFrame {
	
	
	private JButton nextButton;
	private JButton backButton;
	private JButton cancelButton;
	private JPanel container;
	
	private String title;
	private ArrayList<JPanel> panels;
	private int currentPanel;
        
        private Reader reader;
        
      
	public Wizard(String title, ArrayList<JPanel> panels, Reader reader) {
		this.title = title;
		this.panels = panels;
                this.reader = reader;
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle(title);
		setLayout(new BorderLayout());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancel();
			}
		});
		
		initComponents();
		
		if(panels==null||panels.size()<1) {
                                         
			container.add(new JLabel("Empty Setup..."));
			nextButton.setEnabled(false);
			backButton.setEnabled(false);
		} else {
			updateButtons();
			updatePanel();
		}
		
		setLocation(100, 100);
		setLocationByPlatform(true);
		setSize(800, 600);
		setVisible(true);
	}
	
	private void initComponents() {
		//bottom
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 2));
		backButton = new JButton("Back", new ImageIcon("berg-tal-plakat.png"));
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				backButtonActionPerformed();
			}
		});
		bottomPanel.add(backButton);
		nextButton = new JButton("Next", new ImageIcon("berg-tal-plakat.png"));
		nextButton.setHorizontalTextPosition(JButton.LEFT);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextButtonActionPerformed();
			}
		});
		bottomPanel.add(nextButton);
		cancelButton = new JButton("Cancel", new ImageIcon("berg-tal-plakat.png"));
		cancelButton.setHorizontalTextPosition(JButton.LEFT);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		bottomPanel.add(cancelButton);
		add(bottomPanel, BorderLayout.SOUTH);
		
		//container
		container = new JPanel();
		add(container, BorderLayout.CENTER);
	}
	
	private void nextButtonActionPerformed() {
		if(nextButton.getText().equals("Finish")) {
                        
                        //und alles abspeichern!
                        //reader aufrufen um in File zu speichern
                    
			dispose();
		} else {
			currentPanel++;
			updatePanel();
			updateButtons();
		}
	}
	
	private void backButtonActionPerformed() {
		currentPanel--;
		updatePanel();
		updateButtons();
	}
	
	private void updatePanel() {
		container.removeAll();
		container.setLayout(new BorderLayout());
		container.add(panels.get(currentPanel), BorderLayout.CENTER);
		container.validate();
		container.repaint();
	}
	
	private void updateButtons() {
		if(currentPanel>=(panels.size()-1)) { //finish
			nextButton.setText("Finish");
		} else {
			nextButton.setText("Next");
		}
		if(currentPanel<=0) {
			backButton.setEnabled(false);
		} else {
			backButton.setEnabled(true);
		}
	}
	
	private void cancel() {
		final String message = "Sind Sie sicher, dass Sie diesen Setup wirklich beenden wollen?";
		if(JOptionPane.YES_OPTION==JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)) {
			dispose();
		}
	}
        
        
}

