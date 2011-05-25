/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;



import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
/**
 *
 * @author franzi
 */
public class PanelFactory extends JFrame {
       
    private Result result;
    private JComboBox vasodi_box = new javax.swing.JComboBox();
    private JComboBox vasocon_box = new javax.swing.JComboBox();
    private JComboBox inotrope_box = new javax.swing.JComboBox();
    private JComboBox volume_box = new javax.swing.JComboBox();
    private int vasodi_index = -1;
    private int vasocon_index = -1;
    private int inotrope_index = -1;
    private int volume_index = -1;
           
    public PanelFactory(){
    
        this.result = new Result();
        
        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        PatientInfo1 patient_info = new PatientInfo1(result);
        JPanel panel1 = patient_info.createPanel();
        panels.add(panel1);
        
        Preconditions2 pre_cond = new Preconditions2(result, this);
        JPanel panel2 = pre_cond.createPanel();
        panels.add(panel2);
        
        Signals4 signals = new Signals4(result);
        JPanel panel4 = signals.createPanel();
        panels.add(panel4);

        new Wizard("Setup", panels, this);
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
    
    public Result getResult() {
        return result;
    }
    
    public int getVasodi_index() {
        return vasodi_index;
    }
    
     public void setInotrope_index(int inotrope_index) {
        this.inotrope_index = inotrope_index;
    }

    public void setVasocon_index(int vasocon_index) {
        this.vasocon_index = vasocon_index;
    }

    public void setVasodi_index(int vasodi_index) {
        this.vasodi_index = vasodi_index;
    }

    public void setVolume_index(int volume_index) {
        this.volume_index = volume_index;
    }
    
    public int getInotrope_index() {
        return inotrope_index;
    }

    public int getVasocon_index() {
        return vasocon_index;
    }

    public int getVolume_index() {
        return volume_index;
    }
}