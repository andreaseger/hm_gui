/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author franzi
 */
public class PatientInfo1 extends JFrame {

    
    private Result result;

    public PatientInfo1(Result result) {
        this.result = result;
    }
 
    public JPanel createPanel(){
        
        JPanel jPanel1 = new javax.swing.JPanel();
        
        JLabel title = new javax.swing.JLabel();
        JLabel name_label = new javax.swing.JLabel();
        JLabel firstname_label = new javax.swing.JLabel();
        JLabel age_label = new javax.swing.JLabel();
        JLabel weight_label = new javax.swing.JLabel();
        JTextField name_textfield = new javax.swing.JTextField();
        JTextField firstname_textfield = new javax.swing.JTextField();
        JTextField age_textfield = new javax.swing.JTextField();
        JTextField weight_textfield = new javax.swing.JTextField();
        JLabel kg_label = new javax.swing.JLabel();
                
        
        DocumentListener document_listener = new DocumentListener() {
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
                throw new UnsupportedOperationException("Not supported yet.");
            }
            private void saveChange(DocumentEvent e){
                Document doc = e.getDocument();
                int length =doc.getLength();
                try {
                    String s = doc.getText(0, length);
                    
                    if(doc.getProperty("name").equals("name")){
                        result.setName(s);
                    }else if(doc.getProperty("name").equals("firstname")){
                        result.setFirstname(s);
                    }else if(doc.getProperty("name").equals("age")){
                        result.setAge(s);
                    }else if(doc.getProperty("name").equals("weight")){
                        result.setWeight(s);
                    }
                }catch (BadLocationException badLocationException) {
                 System.out.println("Contents: Unknown");
                }
            }
        };
        name_textfield.getDocument().addDocumentListener(document_listener);
        name_textfield.getDocument().putProperty("name", "name");
        firstname_textfield.getDocument().putProperty("name", "firstname");
        firstname_textfield.getDocument().addDocumentListener(document_listener);
        age_textfield.getDocument().addDocumentListener(document_listener);
        age_textfield.getDocument().putProperty("name", "age");
        weight_textfield.getDocument().addDocumentListener(document_listener);
        weight_textfield.getDocument().putProperty("name", "weight");
        
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setText("Patienteninformation");

        name_label.setLabelFor(name_textfield);
        name_label.setText("Name:");
        
        firstname_label.setLabelFor(firstname_textfield);
        firstname_label.setText("Vorname:");

        age_label.setLabelFor(age_textfield);
        age_label.setText("Alter:");

        weight_label.setLabelFor(weight_textfield);
        weight_label.setText("Gewicht:");

        name_textfield.setText(result.getName());
        firstname_textfield.setText(result.getFirstname());
        age_textfield.setText(result.getAge());
        weight_textfield.setText(result.getWeight());

        kg_label.setLabelFor(weight_textfield);
        kg_label.setText("in kg");


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
                            .addComponent(firstname_label))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(firstname_textfield, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                    .addComponent(name_textfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                             .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(age_textfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(weight_textfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                    .addGap(5,5,5)
                                    .addComponent(kg_label))
                ))).addGap(105, 105, 105)
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname_label)
                    .addComponent(firstname_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
}
