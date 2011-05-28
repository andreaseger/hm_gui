/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author franzi
 */
public class Preconditions2 extends JFrame {

    private Result result;
    private PanelFactory panel_factory;
    private boolean is_warned = false;
    private int counter = 0;
    
    
    
    public Preconditions2(Result result, PanelFactory panel_factory) {
        this.result = result;
        this.panel_factory = panel_factory;   
    }
    
    public JPanel createPanel(){
    
        JPanel jPanel1 = new JPanel();
        
        
    
        JLabel title_label = new javax.swing.JLabel();
        JLabel drugs_label = new javax.swing.JLabel();
        JLabel vasodilator_label = new javax.swing.JLabel();
        JLabel vasoconst_label = new javax.swing.JLabel();
        JLabel inotrope_label = new javax.swing.JLabel();
        JLabel volume_label = new javax.swing.JLabel();
        JLabel preconditions_label = new javax.swing.JLabel();
        JScrollPane jScrollPane5 = new javax.swing.JScrollPane();
        JList precond_list = new javax.swing.JList();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        title_label.setFont(new java.awt.Font("Tahoma", 0, 18));
        title_label.setText("Therapievorschlag");

        drugs_label.setFont(new java.awt.Font("Tahoma",0,14));
        drugs_label.setText("Medikamente:");

        vasodilator_label.setLabelFor(panel_factory.getVasodi_box());
        vasodilator_label.setText("Vasodilator");

        vasoconst_label.setLabelFor(panel_factory.getVasocon_box());
        vasoconst_label.setText("Vasoconstrictor");

        inotrope_label.setLabelFor(panel_factory.getInotrope_box());
        inotrope_label.setText("Inotrope");

        volume_label.setLabelFor(panel_factory.getVolume_box());
        volume_label.setText("Volume");
        
        String[] string = result.getDrugs_vasodilator();
        panel_factory.getVasodi_box().setModel(new javax.swing.DefaultComboBoxModel(string));
        string = result.getDrugs_vasoconstrictor();
        panel_factory.getVasocon_box().setModel(new javax.swing.DefaultComboBoxModel(string));
        string = result.getDrugs_inotrope();
        panel_factory.getInotrope_box().setModel(new javax.swing.DefaultComboBoxModel(string));
        string = result.getDrugs_volume();
        panel_factory.getVolume_box().setModel(new javax.swing.DefaultComboBoxModel(string));


        panel_factory.getVasodi_box().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++counter;
                if(!is_warned && counter > 4){
                    showWarning();
                    is_warned = true;
                }
                JComboBox cb = (JComboBox)e.getSource();
                panel_factory.setVasodi_index((int)cb.getSelectedIndex());
                int selected_drug = (int)cb.getSelectedIndex();
                result.getDrugs_buffer()[0] = selected_drug;
            }
        });
        panel_factory.getVasodi_box().setSelectedIndex(result.getSelected_drugs()[0]);
        
        panel_factory.getVasocon_box().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++counter;
                if(!is_warned && counter > 4){
                    showWarning();
                    is_warned = true;
                }
                JComboBox cb = (JComboBox)e.getSource();
                panel_factory.setVasocon_index((int)cb.getSelectedIndex());
                int selected_drug = (int)cb.getSelectedIndex();
                result.getDrugs_buffer()[1] = selected_drug;
            }
        });
        panel_factory.getVasocon_box().setSelectedIndex(result.getSelected_drugs()[1]);
        
        panel_factory.getInotrope_box().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++counter;
                if(!is_warned && counter > 4){
                    showWarning();
                    is_warned = true;
                }
                JComboBox cb = (JComboBox)e.getSource();
                panel_factory.setInotrope_index((int)cb.getSelectedIndex());
                int selected_drug = (int)cb.getSelectedIndex();
                result.getDrugs_buffer()[2] = selected_drug;
            }
        });
        panel_factory.getInotrope_box().setSelectedIndex(result.getSelected_drugs()[2]);
        
        panel_factory.getVolume_box().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++counter;
                if(!is_warned && counter > 4){
                    showWarning();
                    is_warned = true;
                }
                JComboBox cb = (JComboBox)e.getSource();
                panel_factory.setVolume_index((int)cb.getSelectedIndex());
                int selected_drug = (int)cb.getSelectedIndex();
                result.getDrugs_buffer()[3] = selected_drug;
            }
        });
        panel_factory.getVolume_box().setSelectedIndex(result.getSelected_drugs()[3]);
        
        preconditions_label.setText("Vorerkrankungen:");


        precond_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = result.getPre_conditions();
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        
        ArrayList<Integer> indices_list = new ArrayList<Integer>();
        for(int i = 0; i < result.getPreconditions_buffer().size(); ++i){
            for(int j = 0; j < result.getPre_conditions().length; j++){
                if(result.getPreconditions_buffer().get(i).equals(result.getPre_conditions()[j])){
                    indices_list.add(j);
                }
            }
        }
        int[] indices = new int[indices_list.size()];
        for(int i = 0; i < indices_list.size(); ++i){
            indices[i] = indices_list.get(i);
        }
        precond_list.setSelectedIndices(indices);

        
        precond_list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    
                } else {
                    // Find out which indexes are selected.
                    int minIndex = lsm.getMinSelectionIndex();
                    int maxIndex = lsm.getMaxSelectionIndex();
                    for (int i = minIndex; i <= maxIndex; i++) {
                        if (lsm.isSelectedIndex(i)) {
                            String s = result.getPre_conditions()[i];
                            if(!result.getSelected_preconditions().contains(s)){
                                result.getSelected_preconditions().add(result.getPre_conditions()[i]);
                            }
                        }
                    }
                }
            }
        });
        
       jScrollPane5.setViewportView(precond_list);
              
       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_label)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(preconditions_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panel_factory.getInotrope_box(), javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE)
                                .addComponent(vasodilator_label, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panel_factory.getVasodi_box(), javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE))
                            .addComponent(inotrope_label))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volume_label)
                            .addComponent(panel_factory.getVasocon_box(), 0, 180, Short.MAX_VALUE)
                            .addComponent(vasoconst_label)
                            .addComponent(panel_factory.getVolume_box(), 0, 180, Short.MAX_VALUE)))
                    .addComponent(drugs_label))
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title_label)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preconditions_label))

                .addGap(29, 29, 29)
                .addComponent(drugs_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vasodilator_label)
                    .addComponent(vasoconst_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panel_factory.getVasodi_box(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_factory.getVasocon_box(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inotrope_label)
                    .addComponent(volume_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panel_factory.getInotrope_box(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_factory.getVolume_box(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(344, Short.MAX_VALUE))
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
        final String message = "Da nur Daten für die Medikamente VOL, DPM, NEP und ISDN vorhanden sind,\nkönnen hier zwar andere Medikamente ausgewählt werden,\ndie Auswahl wird aber nicht übernommen.";
        JOptionPane.showMessageDialog(null, message, "Medikamentenauswahl",JOptionPane.PLAIN_MESSAGE );
    }
    

}
