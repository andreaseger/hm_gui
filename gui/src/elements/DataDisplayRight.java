package elements;

import javax.swing.JFrame;

/**
 * @author Moe
 */
public class DataDisplayRight extends javax.swing.JPanel {
    /**
     * Current value.
     */
    private int value;
    
    /** Creates new form DataDisplayLeft */
    public DataDisplayRight() {
        initComponents();
    }

    /**
     * Sets the value to display.
     * 
     * @param value Value to display.
     * @return Fluent interface.
     */
    public DataDisplayRight setValue(int value) {
        if (value == this.value) {
            showSameLabel();
        } else if (value > this.value) {
            showUpLabel();
        } else {
            showDownLabel();
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
        jPanel3 = new javax.swing.JPanel();
        downLabel = new javax.swing.JLabel();
        sameLabel = new javax.swing.JLabel();
        upLabel = new javax.swing.JLabel();
        captionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 36));
        valueLabel.setForeground(new java.awt.Color(102, 204, 0));
        valueLabel.setText("000");
        jPanel2.add(valueLabel, java.awt.BorderLayout.CENTER);

        unitLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        unitLabel.setForeground(new java.awt.Color(102, 204, 0));
        unitLabel.setText("Unit");
        jPanel2.add(unitLabel, java.awt.BorderLayout.PAGE_END);

        add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new java.awt.BorderLayout());

        downLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elements/down.png"))); // NOI18N
        jPanel3.add(downLabel, java.awt.BorderLayout.PAGE_END);

        sameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elements/same.png"))); // NOI18N
        jPanel3.add(sameLabel, java.awt.BorderLayout.CENTER);

        upLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elements/up.png"))); // NOI18N
        jPanel3.add(upLabel, java.awt.BorderLayout.PAGE_START);

        add(jPanel3);

        captionLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        captionLabel.setForeground(new java.awt.Color(102, 204, 0));
        captionLabel.setText("<html>\nM<br />\nA<br />\nP");
        add(captionLabel);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel captionLabel;
    private javax.swing.JLabel downLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel sameLabel;
    private javax.swing.JLabel unitLabel;
    private javax.swing.JLabel upLabel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

    private void showSameLabel() {
        upLabel.setVisible(false);
        downLabel.setVisible(false);
        sameLabel.setVisible(true);
    }

    private void showUpLabel() {
        upLabel.setVisible(true);
        downLabel.setVisible(false);
        sameLabel.setVisible(false);
    }

    private void showDownLabel() {
        upLabel.setVisible(false);
        downLabel.setVisible(true);
        sameLabel.setVisible(false);
    }

    private void updateValueLabel() {
        valueLabel.setText(Integer.toString(this.value));
    }
    
    public static void main(String... str){
        
        JFrame frame = new JFrame("GUI Test");
        frame.setSize(800, 200);
        frame.setResizable(true);
        
        DataDisplayRight ddl = new DataDisplayRight();        
        ddl.setCaption("ZIP").setUnit("km/h").setValue(888);
        frame.getContentPane().add(ddl);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
