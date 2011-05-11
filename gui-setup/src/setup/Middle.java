/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;



import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 *
 * @author franzi
 */
public class Middle extends JFrame {
       
    Reader reader;
    
    public Middle(){
    
        //.cfg Datei einlesen
        this.reader = new Reader();
        
        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        JPanel panel1 = getPanelPatientinfo();
        panels.add(panel1);
        
        JPanel panel2 = getPanelTherapie();
        panels.add(panel2);
              
        JPanel panel3 = getPanelInput();
        panels.add(panel3);

        new Wizard("Setup", panels, reader);
    }
    
    public JPanel getPanelPatientinfo(){
        JPanel jPanel1 = new javax.swing.JPanel();
        
        JLabel title = new javax.swing.JLabel();
        JLabel name_label = new javax.swing.JLabel();
        JLabel age_label = new javax.swing.JLabel();
        JLabel weight_label = new javax.swing.JLabel();
        JTextField name_textfield = new javax.swing.JTextField();
        JTextField age_textfield = new javax.swing.JTextField();
        JTextField weight_textfield = new javax.swing.JTextField();
        JLabel kg_label = new javax.swing.JLabel();
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        JList jList1 = new javax.swing.JList();
        JLabel jLabel6 = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        JList jList2 = new javax.swing.JList();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setText("Patienteninformation");

        name_label.setLabelFor(name_textfield);
        name_label.setText("Name:");

        age_label.setLabelFor(age_textfield);
        age_label.setText("Alter:");

        weight_label.setLabelFor(weight_textfield);
        weight_label.setText("Gewicht:");

        name_textfield.setText(reader.getName());
        age_textfield.setText(reader.getAge());
        weight_textfield.setText(reader.getWeight());

        kg_label.setLabelFor(weight_textfield);
        kg_label.setText("in kg");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] preconditions = reader.getPre_conditions();
            public int getSize() { return preconditions.length; }
            public Object getElementAt(int i) { return preconditions[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel6.setText("Vorerkrankungen:");

        jLabel7.setLabelFor(jLabel7);
        jLabel7.setText("Unverträglichkeiten:");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(age_label)
                            .addComponent(weight_label)
                            .addComponent(name_label)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(age_textfield, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                    .addComponent(weight_textfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kg_label))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
                .addGap(105, 105, 105)
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age_label)
                    .addComponent(age_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weight_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weight_label)
                    .addComponent(kg_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED/*, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE*/)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                )
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
          
            return jPanel1;
        }
    
    public JPanel getPanelTherapie(){
        JPanel jPanel1 = new JPanel();
    
       
        
        return jPanel1;
    }
    
     public JPanel getPanelInput(){
        JPanel jPanel1 = new JPanel();
    
        JButton button = new JButton();
        jPanel1.add(button);
        
        return jPanel1;
    }
    
}