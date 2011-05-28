/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.Color;
import java.util.ArrayList;
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
public class DrugsInfo3 extends JFrame {

    private Result result;
    private PanelFactory panel_factory;
    private JLabel error_label = new JLabel();
    private boolean was_insert;
    
    public DrugsInfo3(Result result, PanelFactory panel_factory) {
        
        this.result = result;
        this.panel_factory = panel_factory;
    }
    
    public JPanel createPanel(){
    
    JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();
        JLabel jLabel7 = new javax.swing.JLabel();
        JLabel jLabel8 = new javax.swing.JLabel();
        JLabel jLabel9 = new javax.swing.JLabel();
        JLabel jLabel10 = new javax.swing.JLabel();
        JLabel jLabel11 = new javax.swing.JLabel();
        JLabel jLabel12 = new javax.swing.JLabel();
        JLabel jLabel13 = new javax.swing.JLabel();
        JLabel jLabel14 = new javax.swing.JLabel();
        ArrayList<JTextField> textfield_group1 = new ArrayList<JTextField>();
        JTextField jTextField1 = new javax.swing.JTextField();
        JTextField jTextField2 = new javax.swing.JTextField();
        JTextField jTextField3 = new javax.swing.JTextField();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField5 = new javax.swing.JTextField();
        JTextField jTextField6 = new javax.swing.JTextField();
        JTextField jTextField7 = new javax.swing.JTextField();
        JTextField jTextField8 = new javax.swing.JTextField();
        JTextField jTextField9 = new javax.swing.JTextField();
        textfield_group1.add(jTextField1);
        textfield_group1.add(jTextField2);
        textfield_group1.add(jTextField3);
        textfield_group1.add(jTextField4);
        textfield_group1.add(jTextField5);
        textfield_group1.add(jTextField6);
        textfield_group1.add(jTextField7);
        textfield_group1.add(jTextField8);
        textfield_group1.add(jTextField9);
        ArrayList<JTextField> textfield_group2 = new ArrayList<JTextField>();
        JTextField jTextField10 = new javax.swing.JTextField();
        JTextField jTextField11 = new javax.swing.JTextField();
        JTextField jTextField12 = new javax.swing.JTextField();
        JTextField jTextField13 = new javax.swing.JTextField();
        JTextField jTextField14 = new javax.swing.JTextField();
        JTextField jTextField15 = new javax.swing.JTextField();
        JTextField jTextField16 = new javax.swing.JTextField();
        JTextField jTextField17 = new javax.swing.JTextField();
        JTextField jTextField18 = new javax.swing.JTextField();
        textfield_group2.add(jTextField10);
        textfield_group2.add(jTextField11);
        textfield_group2.add(jTextField12);
        textfield_group2.add(jTextField13);
        textfield_group2.add(jTextField14);
        textfield_group2.add(jTextField15);
        textfield_group2.add(jTextField16);
        textfield_group2.add(jTextField17);
        textfield_group2.add(jTextField18);
        ArrayList<JTextField> textfield_group3 = new ArrayList<JTextField>();
        JTextField jTextField19 = new javax.swing.JTextField();
        JTextField jTextField20 = new javax.swing.JTextField();
        JTextField jTextField21 = new javax.swing.JTextField();
        JTextField jTextField22 = new javax.swing.JTextField();
        JTextField jTextField23 = new javax.swing.JTextField();
        JTextField jTextField24 = new javax.swing.JTextField();
        JTextField jTextField25 = new javax.swing.JTextField();
        JTextField jTextField26 = new javax.swing.JTextField();
        JTextField jTextField27 = new javax.swing.JTextField();
        textfield_group3.add(jTextField19);
        textfield_group3.add(jTextField20);
        textfield_group3.add(jTextField21);
        textfield_group3.add(jTextField22);
        textfield_group3.add(jTextField23);
        textfield_group3.add(jTextField24);
        textfield_group3.add(jTextField25);
        textfield_group3.add(jTextField26);
        textfield_group3.add(jTextField27);
        ArrayList<JTextField> textfield_group4 = new ArrayList<JTextField>();
        JTextField jTextField28 = new javax.swing.JTextField();
        JTextField jTextField29 = new javax.swing.JTextField();
        JTextField jTextField30 = new javax.swing.JTextField();
        JTextField jTextField31 = new javax.swing.JTextField();
        JTextField jTextField32 = new javax.swing.JTextField();
        JTextField jTextField33 = new javax.swing.JTextField();
        JTextField jTextField34 = new javax.swing.JTextField();
        JTextField jTextField35 = new javax.swing.JTextField();
        JTextField jTextField36 = new javax.swing.JTextField();
        textfield_group4.add(jTextField28);
        textfield_group4.add(jTextField29);
        textfield_group4.add(jTextField30);
        textfield_group4.add(jTextField31);
        textfield_group4.add(jTextField32);
        textfield_group4.add(jTextField33);
        textfield_group4.add(jTextField34);
        textfield_group4.add(jTextField35);
        textfield_group4.add(jTextField36);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ausgewählte Medikamente:");
        
        error_label.setText("  ");
        
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
                    int index_1 = -1;
                    int index_2 = -1;
                    int index_3 = -1;
                    int index_4 = -1;
                    for(int i = 0; i < result.getDrugs().size(); ++i){
                       
                        if(result.getDrugs().get(i)[0].equals(result.getDrugs_vasodilator()[result.getSelected_drugs()[0]].split(" ")[0]))
                            index_1 = i;
                        if(result.getDrugs().get(i)[0].equals(result.getDrugs_vasoconstrictor()[result.getSelected_drugs()[1]].split(" ")[0]))
                            index_2 = i;
                        if(result.getDrugs().get(i)[0].equals(result.getDrugs_inotrope()[result.getSelected_drugs()[2]].split(" ")[0]))
                            index_3 = i;
                        if(result.getDrugs().get(i)[0].equals(result.getDrugs_volume()[result.getSelected_drugs()[3]].split(" ")[0]))
                            index_4 = i;
                    }
                    //------------------------------
                    for(int i = 0; i < 9; ++i){
                        String ss = "field1-"+i;
                        if(doc.getProperty("name").equals(ss)){
                            limitValues(i, index_1, s);
                        }
                    }
                    //----------------------------
                    for(int i = 0; i < 9; ++i){
                        String ss = "field2-"+i;
                        if(doc.getProperty("name").equals(ss)){
                            limitValues(i, index_2, s);
                        }
                    }
                    //------------------------------
                    for(int i = 0; i < 9; ++i){
                        String ss = "field3-"+i;
                        if(doc.getProperty("name").equals(ss)){
                            limitValues(i, index_3, s);
                        }
                    }
                    
                    //----------------------------
                    for(int i = 0; i < 9; ++i){
                        String ss = "field4-"+i;
                        if(doc.getProperty("name").equals(ss)){
                            limitValues(i, index_4, s);
                        }
                    }
                    
                }catch (BadLocationException badLocationException) {
                 System.out.println("Contents: Unknown");
                }
            }
        };
        
        String vasodi_chosen;
        if(panel_factory.getVasodi_index() != -1){
            int index = panel_factory.getVasodi_box().getSelectedIndex();
            vasodi_chosen = result.getDrugs_vasodilator()[index].split(" ")[0];
        }else{
            //wenn nicht gewaehlt, nimm das erste Element:
             vasodi_chosen = result.getDrugs_vasodilator()[0].split(" ")[0];
        }
        jLabel2.setText(vasodi_chosen);

        
        String vasocon_chosen;
        if(panel_factory.getVasocon_index() != -1){
            int index = panel_factory.getVasocon_box().getSelectedIndex();
            vasocon_chosen = result.getDrugs_vasoconstrictor()[index].split(" ")[0];
        }else{
             vasocon_chosen = result.getDrugs_vasoconstrictor()[0].split(" ")[0];
        }
        jLabel3.setText(vasocon_chosen);
        
        String inotrop_chosen;
        if(panel_factory.getInotrope_index() != -1){
            int index = panel_factory.getInotrope_box().getSelectedIndex();
            inotrop_chosen = result.getDrugs_inotrope()[index].split(" ")[0];
        }else{
             inotrop_chosen = result.getDrugs_inotrope()[0].split(" ")[0];
        }
        jLabel4.setText(inotrop_chosen);

        String vol_chosen;
        if(panel_factory.getVolume_index() != -1){
            int index = panel_factory.getVolume_box().getSelectedIndex();
            vol_chosen = result.getDrugs_volume()[index].split(" ")[0];
        }else{
             vol_chosen = result.getDrugs_volume()[0].split(" ")[0];
        }
        jLabel5.setText(vol_chosen);

        jLabel6.setText("Abkürzung");

        jLabel8.setText("Maximum");

        jLabel9.setText("max. Erhöhung");

        jLabel10.setText("max. Reduzierung");

        jLabel11.setText("Konzentration");

        jLabel12.setText("Elimination");

        jLabel13.setText("Absolutwert");

        jLabel14.setText("gegenteilige Wirkung");

        jLabel7.setText("Port");
        
        int index_vasodi = -1;
        int index_vasocon = -1;
        int index_inotrop = -1;
        int index_vol = -1;
        
        for(int i = 0; i < result.getDrugs().size(); ++i){
            if(result.getDrugs().get(i)[0].equals(vasodi_chosen))
                index_vasodi = i;
            if(result.getDrugs().get(i)[0].equals(vasocon_chosen))
                index_vasocon = i;
            if(result.getDrugs().get(i)[0].equals(inotrop_chosen))
                index_inotrop = i;
            if(result.getDrugs().get(i)[0].equals(vol_chosen))
                index_vol = i;
        }
        
        for(int i = 0; i < textfield_group1.size(); ++i){
            textfield_group1.get(i).setText(result.getDrugs().get(index_vasodi)[i+1]);
            textfield_group1.get(i).getDocument().addDocumentListener(document_listener);
            String s = "field1-"+i;
            textfield_group1.get(i).getDocument().putProperty("name",s);
        }
        
        for(int i = 0; i < textfield_group2.size(); ++i){
            textfield_group2.get(i).setText(result.getDrugs().get(index_vasocon)[i+1]);
            textfield_group2.get(i).getDocument().addDocumentListener(document_listener);
            String s = "field2-"+i;
            textfield_group2.get(i).getDocument().putProperty("name",s);
        }

        for(int i = 0; i < textfield_group3.size(); ++i){
            textfield_group3.get(i).setText(result.getDrugs().get(index_inotrop)[i+1]);
            textfield_group3.get(i).getDocument().addDocumentListener(document_listener);
            String s = "field3-"+i;
            textfield_group3.get(i).getDocument().putProperty("name",s);
        }
        
        for(int i = 0; i < textfield_group4.size(); ++i){
            textfield_group4.get(i).setText(result.getDrugs().get(index_vol)[i+1]);
            textfield_group4.get(i).getDocument().addDocumentListener(document_listener);
            String s = "field4-"+i;
            textfield_group4.get(i).getDocument().putProperty("name",s);
        }

        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(error_label))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(0,0,0)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField9, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, 90, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    )
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGap(5,5,5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField18, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField16, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField15, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField14, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField13, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField12, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField10, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField11, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGap(24,24,24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField27, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField26, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField25, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField24, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField23, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField22, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField21, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField19, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField20, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGap(24,24,24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField36, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField35, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField34, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField33, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField32, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField31, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField30, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField28, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField29, 90,90, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addGap(10,10,10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(error_label)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    public void limitValues(int i, int index, String s){
        if(s.equals("") && (i==0 || i==1)){
           switch(i){
                case 0: error_label.setText("Abkürzung darf nicht leer sein.");
                        result.setDrugs_info_disable_counter(result.getDrugs_info_disable_counter()+1);
                        break;
                case 1: error_label.setText("Port darf nicht leer sein.");
                        result.setDrugs_info_disable_counter(result.getDrugs_info_disable_counter()+1);
                        break;
           }
        }else if(i < 8 && i > 1){
           double input = 0;
           try{
                input = Double.parseDouble(s);
                if(input < 0 || input > 120){
                     error_label.setBackground(Color.magenta);
                     error_label.setText("Geben Sie eine Zahl zwischen 0 und 120 ein!");
                     result.setDrugs_info_disable_counter(result.getDrugs_info_disable_counter()+1);
                }else{
                     if(was_insert && s.length() == 1)
                            result.setDrugs_info_disable_counter(result.getDrugs_info_disable_counter()-1);
                     error_label.setBackground(Color.white);
                     error_label.setText("  ");
                     result.getDrugs().get(index)[i+1] = s;
                }
           }catch(NumberFormatException f){
                     error_label.setBackground(Color.magenta);
                     error_label.setText("Geben Sie eine Zahl zwischen 0 und 120 ein!");
                     result.setDrugs_info_disable_counter(result.getDrugs_info_disable_counter()+1);
           }
        }else{
           if(was_insert && s.length() == 1)
               result.setDrugs_info_disable_counter(result.getDrugs_info_disable_counter()-1);
           error_label.setBackground(Color.white);
           error_label.setText("  ");
           result.getDrugs().get(index)[i+1] = s;
        }
    }
}
