/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author franzi
 */
public class Signals4 extends JFrame {

    private Result result; 
    private ArrayList<JLabel> signal_fields;
    private ArrayList<JTextField> goal_fields;
    private ArrayList<JCheckBox> checkboxes;
    private int item_changed_index;
    private boolean is_warned = false;
    private int counter = 0;
    
    public Signals4(Result result) {
        this.result = result;
    }
    
    public JPanel createPanel(){
    
     JPanel jPanel1 = new JPanel();
         
     signal_fields = new ArrayList<JLabel>();
     goal_fields  = new ArrayList<JTextField>();
     checkboxes = new ArrayList<JCheckBox>();     
     
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        JCheckBox jCheckBox1 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox2 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox3 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox4 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox5 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox6 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox7 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox8 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox9 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox10 = new javax.swing.JCheckBox();
        JCheckBox jCheckBox11 = new javax.swing.JCheckBox();
        checkboxes.add(jCheckBox1);
        checkboxes.add(jCheckBox2);
        checkboxes.add(jCheckBox3);
        checkboxes.add(jCheckBox4);
        checkboxes.add(jCheckBox5);
        checkboxes.add(jCheckBox6);
        checkboxes.add(jCheckBox7);
        checkboxes.add(jCheckBox8);
        checkboxes.add(jCheckBox9);
        checkboxes.add(jCheckBox10);
        checkboxes.add(jCheckBox11);
        
                
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jSignalLabel1 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jSignalLabel2 = new javax.swing.JLabel();
        JLabel jSignalLabel3 = new javax.swing.JLabel();
        JLabel jSignalLabel4 = new javax.swing.JLabel();
        JTextField jTextField6 = new javax.swing.JTextField();
        JTextField jTextField7 = new javax.swing.JTextField();
        JTextField jTextField8 = new javax.swing.JTextField();
        JTextField jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Signale");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setLabelFor(jTextField1);
        
        jLabel2.setText("Monitoring Intervall:");

        jTextField1.setText(result.getMonitoring_intervall());
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                saveChange(e);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                saveChange(e);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                //plain text -> not reachable
                throw new UnsupportedOperationException("Not supported yet.");
            }
            private void saveChange(DocumentEvent e){
                try {
                    String s = e.getDocument().getText(0, e.getDocument().getLength());
                    result.setMonitoring_intervall_buffer(s);
                }catch (BadLocationException badLocationException) {
                 System.out.println("Contents: Unknown");
                }
            }
        });
        
        
        for(int i=0; i<result.getSignals().length; ++i){
            checkboxes.get(i).setText(result.getSignals()[i]);
        }
      
        String s = "-";
             
        
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Zielwerte:");

        jLabel4.setLabelFor(jTextField1);
        jLabel4.setText("sec");
        //signals
        jSignalLabel1.setText(s);
        jSignalLabel2.setText(s);
        jSignalLabel3.setText(s);
        jSignalLabel4.setText(s);
        
        signal_fields.add(jSignalLabel1);
        signal_fields.add(jSignalLabel2);
        signal_fields.add(jSignalLabel3);
        signal_fields.add(jSignalLabel4);
        //goal values
        jTextField6.setText(s);
        jTextField7.setText(s);
        jTextField8.setText(s);
        jTextField9.setText(s);
       
        goal_fields.add(jTextField6);
        goal_fields.add(jTextField7);
        goal_fields.add(jTextField8);
        goal_fields.add(jTextField9);
        
                
        ItemListener item_listener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                ++counter;
                
                 Object source = e.getItemSelectable();
                item_changed_index = -1;
                //welche checkbox auf Seite 4 wurde ausgewählt?
                for(int i = 0; i < checkboxes.size(); ++i){
                    if(source == checkboxes.get(i))
                        item_changed_index = i;
                }
                if (e.getStateChange() == ItemEvent.DESELECTED){
                    /*if(!is_warned && counter > 4){
                        showWarning();
                        is_warned = true;
                    }*/
                    for(int i = 0; i < signal_fields.size(); ++i){
                        String sg = checkboxes.get(item_changed_index).getText();
                        String[] ss = sg.split(" ");
                        String s = ss[ss.length-1].substring(1,ss.length);
                        
                        if(signal_fields.get(i).getText().equals(s)){
                            result.getSelected_signal_targets_buffer().remove(item_changed_index);
                            signal_fields.get(i).setText("-");
                            goal_fields.get(i).setText("-");
                        }
                    }
                }
                else{
                    if(!is_warned && counter > 4){
                        showWarning();
                        is_warned = true;
                    }
                    for(int i = 0; i < signal_fields.size(); ++i){
                    //noch nicht belegt
                        if(signal_fields.get(i).getText().equals("-")){
                            String sg = checkboxes.get(item_changed_index).getText();
                            goal_fields.get(i).setText(result.getSignal_targets().get(sg));
                            
                            String[] ss = sg.split(" ");
                            String s = ss[ss.length-1].substring(1,ss.length);
                            signal_fields.get(i).setText(s);
                            result.getSelected_signal_targets_buffer().put(item_changed_index, result.getSignal_targets().get(sg));
                            item_changed_index = -1;
                            
                            break;
                        }
                        //wenn alle belegt?
                        else if(i == signal_fields.size()-1){
                            final String message = "Sie haben bereits 4 Signale gewählt. Entfernen Sie ein Signal um ein anderes auswählen zu können.";
                            JOptionPane.showMessageDialog(null, message, "Signale",JOptionPane.PLAIN_MESSAGE );
                        }
                    }
                }
            }
        };
        
        for(int i = 0; i < checkboxes.size(); ++i){
            checkboxes.get(i).addItemListener(item_listener);
        }
        
        //preselection from previous changes
        for(Integer key : result.getSelected_signal_targets().keySet()){
            for(int i = 0; i < checkboxes.size(); ++i){
                if(i == key){
                    checkboxes.get(i).setSelected(true);
                }
            }
        }
        
        
       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox9)
                            .addComponent(jCheckBox3))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox7)))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSignalLabel1, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSignalLabel2, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSignalLabel3, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSignalLabel4, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField8, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField9, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(649, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox7))
                .addGap(3, 3, 3)
                .addComponent(jCheckBox11)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSignalLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSignalLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSignalLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSignalLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        
        return jPanel1;
    
    }
    
    private void showWarning(){
        final String message = "Da nur Daten für die Inputs MAP, CVP, SVR und CO vorhanden sind,\nkönnen hier zwar andere Signale ausgewählt werden,\ndie Auswahl wird aber nicht übernommen.";
        JOptionPane.showMessageDialog(null, message, "Inputauswahl",JOptionPane.PLAIN_MESSAGE );
    }
    
}
