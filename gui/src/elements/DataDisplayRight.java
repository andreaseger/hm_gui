package elements;

import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Moe
 */
public class DataDisplayRight extends javax.swing.JPanel {
    /**
     * Current value.
     */
    private float value;
    private ImageIcon downImage;
    private ImageIcon upImage;
    private ImageIcon sameImage;
    
    /** Creates new form DataDisplayLeft */
    public DataDisplayRight(int width, int height) {
        initComponents();
        loadGraphics();
        setAllSizes(width, height);
    }
    
    private void setAllSizes(int width, int height) {
        Dimension d = new Dimension(width, height);
        
        setSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setPreferredSize(d);
    }    

    /**
     * Sets the value to display.
     * 
     * @param value Value to display.
     * @return Fluent interface.
     */
    public DataDisplayRight setValue(float value) {
        if (value == this.value) {
            showSameGraphics();
        } else if (value > this.value) {
            showUpGraphics();
        } else {
            showDownGraphics();
        }
        
        this.value = value;
        updateValueLabel();
        
        return this;
    }
    
    public DataDisplayRight setUnit(String unit) {
        unitLabel.setText(unit);
        return this;
    }
    
    public DataDisplayRight setCaption(String caption) {
        StringBuilder sb = new StringBuilder("<html>");
        
        for(int i = 0; i < caption.length(); i++) {
            sb.append(caption.charAt(i));
            sb.append("<br />");
        }
        
        captionLabel.setText(sb.toString());
        
        return this;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        valueLabel = new javax.swing.JLabel();
        unitLabel = new javax.swing.JLabel();
        captionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(133, 120));
        setPreferredSize(new java.awt.Dimension(133, 120));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(102, 204, 0));
        valueLabel.setText("000,00");
        jPanel2.add(valueLabel, java.awt.BorderLayout.CENTER);

        unitLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        unitLabel.setForeground(new java.awt.Color(102, 204, 0));
        unitLabel.setText("Unit");
        jPanel2.add(unitLabel, java.awt.BorderLayout.PAGE_END);

        add(jPanel2);

        captionLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        captionLabel.setForeground(new java.awt.Color(102, 204, 0));
        captionLabel.setText("<html>\nM<br />\nA<br />\nP");
        add(captionLabel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel captionLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel unitLabel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables


    private void showSameGraphics() {
        unitLabel.setIcon(this.sameImage);
    }

    private void showUpGraphics() {
        unitLabel.setIcon(this.upImage);
    }

    private void showDownGraphics() {
        unitLabel.setIcon(this.downImage);
    }

    private void updateValueLabel() {
        DecimalFormat f = new DecimalFormat("#0.00");
        valueLabel.setText(f.format(this.value));
    }

    private void loadGraphics() {
        this.downImage = new javax.swing.ImageIcon(getClass().getResource("/elements/down.png"));
        this.upImage = new javax.swing.ImageIcon(getClass().getResource("/elements/up.png"));
        this.sameImage = new javax.swing.ImageIcon(getClass().getResource("/elements/same.png"));
    }
}
