/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author franzi
 */
public class Result {
    
    private Reader reader;
    
    private String name;
    private String firstname;
    private String age;
    private String weight;
    private String[] pre_conditions;
    private String[] intolerances;
    private String[] drugs_vasodilator;
    private String[] drugs_vasoconstrictor;
    private String[] drugs_inotrope;
    private String[] drugs_volume;
    private String[] signals;
    private ArrayList<String[]> drugs = new ArrayList<String[]>();
    private String monitoring_intervall;
    private HashMap<String, String> signal_targets = new HashMap<String, String>();
    
    private ArrayList<String> selected_preconditions = new ArrayList<String>();
    
    private int[] selected_drugs = {0,0,0,0};
    
    private HashMap<String, String> selected_signal_targets = new HashMap<String, String>();

    
        
    public Result(){
        this.reader = new Reader(this);
        
    }
    

    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<String[]> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<String[]> drugs) {
        this.drugs = drugs;
    }

    public String[] getDrugs_inotrope() {
        return drugs_inotrope;
    }

    public void setDrugs_inotrope(String[] drugs_inotrope) {
        this.drugs_inotrope = drugs_inotrope;
    }

    public String[] getDrugs_vasoconstrictor() {
        return drugs_vasoconstrictor;
    }

    public void setDrugs_vasoconstrictor(String[] drugs_vasoconstrictor) {
        this.drugs_vasoconstrictor = drugs_vasoconstrictor;
    }

    public String[] getDrugs_vasodilator() {
        return drugs_vasodilator;
    }

    public void setDrugs_vasodilator(String[] drugs_vasodilator) {
        this.drugs_vasodilator = drugs_vasodilator;
    }

    public String[] getDrugs_volume() {
        return drugs_volume;
    }

    public void setDrugs_volume(String[] drugs_volume) {
        this.drugs_volume = drugs_volume;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String[] getIntolerances() {
        return intolerances;
    }

    public void setIntolerances(String[] intolerances) {
        this.intolerances = intolerances;
    }

    public String getMonitoring_intervall() {
        return monitoring_intervall;
    }

    public void setMonitoring_intervall(String monitoring_intervall) {
        this.monitoring_intervall = monitoring_intervall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPre_conditions() {
        return pre_conditions;
    }

    public void setPre_conditions(String[] pre_conditions) {
        this.pre_conditions = pre_conditions;
    }

    public HashMap<String, String> getSignal_targets() {
        return signal_targets;
    }

    public void setSignal_targets(HashMap<String, String> signal_targets) {
        this.signal_targets = signal_targets;
    }

    public String[] getSignals() {
        return signals;
    }

    public void setSignals(String[] signals) {
        this.signals = signals;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public ArrayList<String> getSelected_preconditions() {
        return selected_preconditions;
    }

    public void setSelected_preconditions(ArrayList<String> selected_preconditions) {
        this.selected_preconditions = selected_preconditions;
    }
   
    public int[] getSelected_drugs() {
        return selected_drugs;
    }

    public void setSelected_drugs(int[] selected_drugs) {
        this.selected_drugs = selected_drugs;
    }
    
    public HashMap<String, String> getSelected_signal_targets() {
        return selected_signal_targets;
    }

    public void setSelected_signal_targets(HashMap<String, String> selected_signal_targets) {
        this.selected_signal_targets = selected_signal_targets;
    }

}
