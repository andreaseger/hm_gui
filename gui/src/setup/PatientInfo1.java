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
    private JLabel age_error_label = new JLabel();
    private JLabel weight_error_label = new JLabel();
    private JLabel title = new javax.swing.JLabel();
    private JLabel name_label = new javax.swing.JLabel();
    private JLabel firstname_label = new javax.swing.JLabel();
    private JLabel age_label = new javax.swing.JLabel();
    private JLabel weight_label = new javax.swing.JLabel();
    private JTextField name_textfield = new javax.swing.JTextField();
    private JTextField firstname_textfield = new javax.swing.JTextField();
    private JTextField age_textfield = new javax.swing.JTextField();
    private JTextField weight_textfield = new javax.swing.JTextField();
    private JLabel kg_label = new javax.swing.JLabel();
    
    private boolean was_insert;
        

    public PatientInfo1(Result result) {
        this.result = result;
    }
 
    public JPanel createPanel(){
        
        JPanel jPanel1 = new javax.swing.JPanel();
                
       
        
                
        
        DocumentListener document_listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               was_insert = true;
               saveChange(e);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                was_insert = false;
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
                        result.setName_buffer(s);
                    }else if(doc.getProperty("name").equals("firstname")){
                        result.setFirstname_buffer(s);
                    }else if(doc.getProperty("name").equals("age")){
                        int input;
                        try{
                            input = Integer.parseInt(s);
                            if(input < 0 || input > 120){
                                result.setPatient_info_disable_counter(result.getPatient_info_disable_counter()+1);
                                age_error_label.setText("Geben Sie eine Dezimalzahl zwischen 0 und 120 ein!");
                            }else{
                                if(was_insert && s.length() == 1)
                                    result.setPatient_info_disable_counter(result.getPatient_info_disable_counter()-1);
                                age_error_label.setText("");
                                result.setAge_buffer(s);
                            }
                        }catch(NumberFormatException f){
                            result.setPatient_info_disable_counter(result.getPatient_info_disable_counter()+1);
                            age_error_label.setText("Geben Sie eine Dezimalzahl zwischen 0 und 120 ein!");
                        }
                    }else if(doc.getProperty("name").equals("weight")){
                        int input;
                        try{
                            input = Integer.parseInt(s);
                            if(input < 0 || input > 250){
                                result.setPatient_info_disable_counter(result.getPatient_info_disable_counter()+1);
                                weight_error_label.setText("Geben Sie eine Dezimalzahl zwischen 0 und 250 ein!");
                            }else{
                                if(was_insert && s.length() == 1)
                                    result.setPatient_info_disable_counter(result.getPatient_info_disable_counter()-1);
                                weight_error_label.setText("");
                                result.setWeight_buffer(s);
                            }
                        }catch(NumberFormatException f){
                            result.setPatient_info_disable_counter(result.getPatient_info_disable_counter()+1);
                            weight_error_label.setText("Geben Sie eine Dezimalzahl zwischen 0 und 250 ein!");
                        }
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
        
        age_error_label.setText("");
        weight_error_label.setText("");

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
                                    .addComponent(kg_label)
                                    .addGap(5,5,5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(weight_error_label)
                                        //.addGap(5,5,5)
                                        .addComponent(age_error_label)))
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
                    .addComponent(age_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(age_error_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weight_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weight_label)
                    .addComponent(kg_label)
                    .addComponent(weight_error_label))
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
