/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestFrame.java
 *
 * Created on 21.04.2011, 15:08:05
 */
package gui;

import javax.swing.JLabel;

/**
 *
 * @author Moe
 */
public class TestFrame extends javax.swing.JFrame {

    /** Creates new form TestFrame */
    public TestFrame() {
        initComponents();
        
        DataDisplayLeft dd = new DataDisplayLeft();
        dd.setCaption("ZIP");
        dd.setUnit("km/h");
        dd.setValue(888);
        dd.setValue(777);
        getContentPane().add(dd);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TestFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
