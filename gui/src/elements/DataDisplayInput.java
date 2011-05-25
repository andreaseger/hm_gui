package elements;

import gui.InputEnum;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author Moe
 */
public class DataDisplayInput extends javax.swing.JPanel {
    /**
     * Current value.
     */
    private float value;
    private ImageIcon downImage;
    private ImageIcon upImage;
    private ImageIcon sameImage;
  private InputEnum type;

  public InputEnum getType() {
    return type;
  }
    
    /** Creates new form DataDisplayLeft */
    public DataDisplayInput(int width, int height) {
        initComponents();
        loadGraphics();
        setSize(width, height);
    }
    
    /**
     * Sets the value to display.
     * 
     * @param value Value to display.
     * @return Fluent interface.
     */
    public DataDisplayInput setValue(float value) {
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
    
    public DataDisplayInput setUnit(String unit) {
        unitLabel.setText(unit);
        return this;
    }
    
    public DataDisplayInput setCaption(String caption) {
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
        captionLabel = new javax.swing.JLabel();
        unitLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(133, 120));
        setPreferredSize(new java.awt.Dimension(133, 120));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 28));
        valueLabel.setForeground(new java.awt.Color(51, 204, 0));
        valueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        valueLabel.setText("000,00");
        jPanel2.add(valueLabel, java.awt.BorderLayout.CENTER);

        captionLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        captionLabel.setForeground(new java.awt.Color(51, 204, 0));
        captionLabel.setText("<html>\nM<br />\nA<br />\nP");
        jPanel2.add(captionLabel, java.awt.BorderLayout.LINE_END);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        unitLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        unitLabel.setForeground(new java.awt.Color(51, 204, 0));
        unitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitLabel.setText("Unit");
        add(unitLabel, java.awt.BorderLayout.PAGE_END);
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
        this.downImage = new javax.swing.ImageIcon(getClass().getResource("/resource/down.png"));
        this.upImage = new javax.swing.ImageIcon(getClass().getResource("/resource/up.png"));
        this.sameImage = new javax.swing.ImageIcon(getClass().getResource("/resource/same.png"));
    }

  public void setType(InputEnum type) {
    setCaption(type.getName());
    setUnit(type.getUnit());
    this.type = type;
  }
}
