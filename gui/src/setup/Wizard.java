/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Wizard
 * @author noxan
 * @since 0.0.5
 * @version 0.0.7
 */
public class Wizard extends JDialog {

  private JButton nextButton;
  private JButton backButton;
  private JButton cancelButton;
  private JPanel container;
  private String title;
  private ArrayList<JPanel> panels;
  private int currentPanel;
  private PanelFactory panel_factory;
  private boolean page3 = false;
  private int counter = 0;

  public Wizard(String title, ArrayList<JPanel> panels, PanelFactory panel_factory) {
    this.title = title;
    this.panels = panels;
    this.panel_factory = panel_factory;

    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    setTitle(title);
    setLayout(new BorderLayout());
    addWindowListener(new WindowAdapter() {

      @Override
      public void windowClosing(WindowEvent e) {
        cancel();
      }
    });
    setModal(true);
    initComponents();

    if (panels == null || panels.size() < 1) {

      container.add(new JLabel("Empty Setup..."));
      nextButton.setEnabled(false);
      backButton.setEnabled(false);
    } else {
      updateButtons();
      updatePanel();
    }

    setLocation(100, 100);
    setLocationByPlatform(true);
    setSize(667, 480);
    setVisible(true);
  }

  private void initComponents() {
    //bottom
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 2));
    Dimension dim = new Dimension(90, 26);
    backButton = new JButton("Back", new ImageIcon("berg-tal-plakat.png"));
    backButton.setPreferredSize(dim);
    backButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        backButtonActionPerformed();
      }
    });
    bottomPanel.add(backButton);
    nextButton = new JButton("Next", new ImageIcon("berg-tal-plakat.png"));
    nextButton.setHorizontalTextPosition(JButton.LEFT);
    nextButton.setPreferredSize(dim);
    nextButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        nextButtonActionPerformed();
      }
    });
    bottomPanel.add(nextButton);
    cancelButton = new JButton("Cancel", new ImageIcon("berg-tal-plakat.png"));
    cancelButton.setPreferredSize(dim);
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
    if (nextButton.getText().equals("Save")) {
      dispose();
    } else {
      if (currentPanel == 1) {
        page3 = true;
        ++counter;
      }
      if (!page3) {
        currentPanel++;
      }
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
    if (page3 && counter == 1) {
      JPanel panelPage3 = getPanelPage3();
      ++currentPanel;
      panels.add(currentPanel, panelPage3);
      container.add(panelPage3, BorderLayout.CENTER);
      page3 = false;
    } else if (page3 && counter > 1) {
      JPanel panelPage3 = getPanelPage3();
      ++currentPanel;
      panels.set(currentPanel, panelPage3);
      container.add(panelPage3, BorderLayout.CENTER);
      page3 = false;
    } else {
      container.add(panels.get(currentPanel), BorderLayout.CENTER);
    }
    container.validate();
    container.repaint();
  }

  private void updateButtons() {
    if (currentPanel >= (panels.size() - 1)) { //finish
      nextButton.setText("Save");
    } else {
      nextButton.setText("Next");
    }
    if (currentPanel <= 0) {
      backButton.setEnabled(false);
    } else {
      backButton.setEnabled(true);
    }
  }

  private void cancel() {
    final String message = "Sind Sie sicher, dass Sie diesen Setup wirklich beenden wollen?";
    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)) {
      dispose();
    }
  }

  private JPanel getPanelPage3() {
    DrugsInfo3 drugs_info_panel = new DrugsInfo3(panel_factory.getResult(), panel_factory);
    JPanel panel1 = drugs_info_panel.createPanel();

    return panel1;
  }
}
