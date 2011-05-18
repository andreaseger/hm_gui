/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 *
 * @author franzi
 */
public class Middle extends JFrame {
       
    private Reader reader;
    private JComboBox vasodi_box = new javax.swing.JComboBox();
    private JComboBox vasocon_box = new javax.swing.JComboBox();
    private JComboBox inotrope_box = new javax.swing.JComboBox();
    private JComboBox volume_box = new javax.swing.JComboBox();
    private int vasodi_index = -1;
    private int vasocon_index = -1;
    private int inotrope_index = -1;
    private int volume_index = -1;
    
    ArrayList<JCheckBox> checkboxes;
    int item_changed_index;
    ArrayList<JTextField> signal_fields = new ArrayList<JTextField>();
    ArrayList<JTextField> goal_fields = new ArrayList<JTextField>();
    

           
    public Middle(){
    
        //.cfg Datei einlesen
        this.reader = new Reader();
        
        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        JPanel panel1 = getPanelPatientinfo();
        panels.add(panel1);
        
        JPanel panel2 = getPanelTherapy(vasodi_box, vasocon_box, inotrope_box, volume_box);
        panels.add(panel2);
              
        //JPanel panel3 = new JPanel();
        //panels.add(panel3);
        
        JPanel panel4 = getPanelInput();
        panels.add(panel4);

        new Wizard("Setup", panels, this);
    }
    
    public JPanel getPanelPatientinfo(){
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

        name_textfield.setText(reader.getName());
        firstname_textfield.setText(reader.getFirstname());
        age_textfield.setText(reader.getAge());
        weight_textfield.setText(reader.getWeight());

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
    
    public JPanel getPanelTherapy(JComboBox vasodi_box,JComboBox vasocon_box,JComboBox inotrope_box,JComboBox volume_box){
        JPanel jPanel1 = new JPanel();
    
        JLabel title_label = new javax.swing.JLabel();
        JLabel drugs_label = new javax.swing.JLabel();
        JLabel vasodilator_label = new javax.swing.JLabel();
        JLabel vasoconst_label = new javax.swing.JLabel();
        JLabel inotrope_label = new javax.swing.JLabel();
        JLabel volume_label = new javax.swing.JLabel();
        JLabel preconditions_label = new javax.swing.JLabel();
        JLabel intol_label = new javax.swing.JLabel();
        JScrollPane jScrollPane5 = new javax.swing.JScrollPane();
        JList precond_list = new javax.swing.JList();
        JScrollPane jScrollPane6 = new javax.swing.JScrollPane();
        JList jList6 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        title_label.setFont(new java.awt.Font("Tahoma", 0, 18));
        title_label.setText("Therapievorschlag");

        drugs_label.setText("Medikamente:");

        vasodilator_label.setLabelFor(vasocon_box);
        vasodilator_label.setText("Vasodilator");

        vasoconst_label.setLabelFor(vasodi_box);
        vasoconst_label.setText("Vasoconstrictor");

        inotrope_label.setLabelFor(volume_box);
        inotrope_label.setText("Inotrope");

        volume_label.setLabelFor(inotrope_box);
        volume_label.setText("Volume");
        
        String[] string = reader.getDrugs_vasodilator();
        vasodi_box.setModel(new javax.swing.DefaultComboBoxModel(string));
        string = reader.getDrugs_vasoconstrictor();
        vasocon_box.setModel(new javax.swing.DefaultComboBoxModel(string));
        string = reader.getDrugs_inotrope();
        inotrope_box.setModel(new javax.swing.DefaultComboBoxModel(string));
        string = reader.getDrugs_volume();
        volume_box.setModel(new javax.swing.DefaultComboBoxModel(string));


        vasodi_box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                vasodi_index = (int)cb.getSelectedIndex();
            }
        });
        vasocon_box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                vasocon_index = (int)cb.getSelectedIndex();
            }
        });
        inotrope_box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                inotrope_index = (int)cb.getSelectedIndex();
            }
        });
        volume_box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                volume_index = (int)cb.getSelectedIndex();
            }
        });
        
        preconditions_label.setText("Vorerkrankungen:");

        intol_label.setText("Unverträglichkeiten:");

        precond_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = reader.getPre_conditions();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
       jScrollPane5.setViewportView(precond_list);
      

        jList6.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_label)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vasodi_box, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(vasocon_box, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(inotrope_box, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(volume_box, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(vasodilator_label)
                                .addGap(65, 65, 65)
                                .addComponent(vasoconst_label))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(preconditions_label)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(intol_label))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(inotrope_label)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(volume_label))))
                    .addComponent(drugs_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(intol_label)
                                .addGap(150,150,150)
                                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                )
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(preconditions_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                                        .addComponent(drugs_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, 200, 200, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(inotrope_label)
                                .addComponent(volume_label)
                                .addComponent(vasodilator_label)
                                .addComponent(vasoconst_label)
                                .addGap(200,200,200))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(vasodi_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vasocon_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inotrope_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(volume_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(260, 260, 260)))
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
    
     public JPanel getPanelTherapy2(){
            
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
        
        String vasodi_chosen;
        if(vasodi_index != -1){
            int index = vasodi_box.getSelectedIndex();
            vasodi_chosen = reader.getDrugs_vasodilator()[index].split(" ")[0];
        }else{
            //wenn nicht gewaehlt, nimm das erste Element:
             vasodi_chosen = reader.getDrugs_vasodilator()[0].split(" ")[0];
        }
        jLabel2.setText(vasodi_chosen);

        
        String vasocon_chosen;
        if(vasocon_index != -1){
            int index = vasocon_box.getSelectedIndex();
            vasocon_chosen = reader.getDrugs_vasoconstrictor()[index].split(" ")[0];
        }else{
             vasocon_chosen = reader.getDrugs_vasoconstrictor()[0].split(" ")[0];
        }
        jLabel3.setText(vasocon_chosen);
        
        String inotrop_chosen;
        if(inotrope_index != -1){
            int index = inotrope_box.getSelectedIndex();
            inotrop_chosen = reader.getDrugs_inotrope()[index].split(" ")[0];
        }else{
             inotrop_chosen = reader.getDrugs_inotrope()[0].split(" ")[0];
        }
        jLabel4.setText(inotrop_chosen);

        String vol_chosen;
        if(volume_index != -1){
            int index = volume_box.getSelectedIndex();
            vol_chosen = reader.getDrugs_volume()[index].split(" ")[0];
        }else{
             vol_chosen = reader.getDrugs_volume()[0].split(" ")[0];
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
        
        for(int i = 0; i < reader.getDrugs().size(); ++i){
            if(reader.getDrugs().get(i)[0].equals(vasodi_chosen))
                index_vasodi = i;
            if(reader.getDrugs().get(i)[0].equals(vasocon_chosen))
                index_vasocon = i;
            if(reader.getDrugs().get(i)[0].equals(inotrop_chosen))
                index_inotrop = i;
            if(reader.getDrugs().get(i)[0].equals(vol_chosen))
                index_vol = i;
        }
        
        for(int i = 0; i < textfield_group1.size(); ++i){
            textfield_group1.get(i).setText(reader.getDrugs().get(index_vasodi)[i+1]);
        }
        
        for(int i = 0; i < textfield_group2.size(); ++i){
            textfield_group2.get(i).setText(reader.getDrugs().get(index_vasocon)[i+1]);
        }

        for(int i = 0; i < textfield_group3.size(); ++i){
            textfield_group3.get(i).setText(reader.getDrugs().get(index_inotrop)[i+1]);
        }
        
        for(int i = 0; i < textfield_group4.size(); ++i){
            textfield_group4.get(i).setText(reader.getDrugs().get(index_vol)[i+1]);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
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
                .addGap(65, 65, 65)
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
                .addGap(65, 65, 65)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
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
    
     
     public JPanel getPanelInput(){
        JPanel jPanel1 = new JPanel();
    
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JTextField jTextField1 = new javax.swing.JTextField();
        checkboxes = new ArrayList<JCheckBox>();
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
        JTextField jTextField2 = new javax.swing.JTextField();
        JLabel jLabel4 = new javax.swing.JLabel();
        JTextField jTextField3 = new javax.swing.JTextField();
        JTextField jTextField4 = new javax.swing.JTextField();
        JTextField jTextField5 = new javax.swing.JTextField();
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

        jTextField1.setText(reader.getMonitoring_intervall());
        for(int i=0; i<reader.getSignals().length; ++i){
            checkboxes.get(i).setText(reader.getSignals()[i]);
        }
      
        String s = "-";
             
        
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Zielwerte:");

        jLabel4.setLabelFor(jTextField1);
        jLabel4.setText("sec");
        //signals
        jTextField2.setText(s);
        jTextField3.setText(s);
        jTextField4.setText(s);
        jTextField5.setText(s);
        
        signal_fields.add(jTextField2);
        signal_fields.add(jTextField3);
        signal_fields.add(jTextField4);
        signal_fields.add(jTextField5);
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
                 Object source = e.getItemSelectable();
                item_changed_index = -1;
                //welche checkbox auf Seite 4 wurde ausgewählt?
                for(int i = 0; i < checkboxes.size(); ++i){
                    if(source == checkboxes.get(i))
                        item_changed_index = i;
                }
                if (e.getStateChange() == ItemEvent.DESELECTED){
                    for(int i = 0; i < signal_fields.size(); ++i){
                        if(signal_fields.get(i).getText().equals(checkboxes.get(item_changed_index).getText())){
                            signal_fields.get(i).setText("-");
                            goal_fields.get(i).setText("-");
                            //signal_fields.get(i).validate();
                            //signal_fields.get(i).repaint();
                        }
                    }
                }
                else{
                    for(int i = 0; i < signal_fields.size(); ++i){
                    //noch nicht belegt
                        if(signal_fields.get(i).getText().equals("-")){
                            String s = checkboxes.get(item_changed_index).getText();
                            //String[] ss = s.split("");
                            //ss[1].replaceAll(")", "");
                            //s = ss[1].substring(0, ss[1].length() -1);
                            signal_fields.get(i).setText(s);
                            goal_fields.get(i).setText("???");
                            item_changed_index = -1;
                            break;
                        }
                        //wenn alle belegt?
                        else if(i == signal_fields.size()-1){
                            final String message = "Sie haben bereits 4 Signale gewählt. Deselektieren Sie ein Signal um ein anderes auswählen zu können.";
                            JOptionPane.showMessageDialog(null, "Signale", message ,JOptionPane.PLAIN_MESSAGE );
                        }
                    }
                }
            }
        };
        
        for(int i = 0; i < checkboxes.size(); ++i){
            checkboxes.get(i).addItemListener(item_listener);
        }
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox5)
                                    .addComponent(jCheckBox9)
                                    .addComponent(jTextField6, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField7, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3,100,100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField8, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField4, 100,100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox6)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox10)
                                            .addComponent(jCheckBox4)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0,0,0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox7)
                                    .addComponent(jCheckBox11)
                                    .addComponent(jCheckBox3))))))
                .addContainerGap(531, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox6))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(210, 210, 210))
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
     
     public JComboBox getInotrope_box() {
        return inotrope_box;
    }

    public JComboBox getVasocon_box() {
        return vasocon_box;
    }

    public JComboBox getVasodi_box() {
        return vasodi_box;
    }

    public JComboBox getVolume_box() {
        return volume_box;
    }
    
    public Reader getReader() {
        return reader;
    }
    
    public int getVasodi_index() {
        return vasodi_index;
    }
    
}