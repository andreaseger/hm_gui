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
    
    private boolean is_valid = false;
    
    private String name;
    private String name_buffer;
    private String firstname;
    private String firstname_buffer;
    private String age;
    private String age_buffer;
    private String weight;
    private String weight_buffer;
    
    private String[] pre_conditions;
    private String[] intolerances;
    
    private String[] drugs_vasodilator;
    private String[] drugs_vasoconstrictor;
    private String[] drugs_inotrope;
    private String[] drugs_volume;
    
    private ArrayList<String[]> drugs = new ArrayList<String[]>();
    private ArrayList<String[]> drugs_changed = new ArrayList<String[]>();

    private String monitoring_intervall;
    private String monitoring_intervall_buffer;

        
    private String[] signals;
    private HashMap<String, String> signal_targets = new HashMap<String, String>();
    //<Integer,String> index of the signal -> String[] signals
    private HashMap<Integer, String> selected_signal_targets_buffer = new HashMap<Integer, String>();

    
    private HashMap<Integer, String> selected_signal_targets = new HashMap<Integer, String>();
    
    
    private int[] selected_inputs = {0,1,2,3};
    private double[] selected_input_targets = {105,2.0,2.0,50};

    private ArrayList<String> preconditions_buffer = new ArrayList<String>();
    private ArrayList<String> selected_preconditions = new ArrayList<String>();
    
    private int[] drugs_buffer = {0,0,0,0};
    private int[] selected_drugs = {0,0,0,0};

    
    public Result(){
        this.reader = new Reader(this);
        selected_signal_targets.put(0,signal_targets.get(signals[0]));
        selected_signal_targets.put(1,signal_targets.get(signals[1]));
        selected_signal_targets.put(2,signal_targets.get(signals[2]));
        selected_signal_targets.put(3,signal_targets.get(signals[3]));
    }
    
    
    
    public void saveResults(){
    
        is_valid = true;
        
        setName(name_buffer);
        setFirstname(firstname_buffer);
        setAge(age_buffer);
        setWeight(weight_buffer);
        
        setSelected_preconditions(preconditions_buffer);
        
        //here: selected_drugs constant because of lack of data
        //setSelected_drugs(drugs_buffer);
        //Hack to get the always the default outputs
        setSelected_drugs(new int[]{0,1,2,3});

        setDrugs(drugs_changed);
    
        setMonitoring_intervall(monitoring_intervall_buffer);
        
        setSelected_signal_targets(selected_signal_targets_buffer);
        
        //here: selected_inputs constant because of lack of data
        /*for(int i = 0; i < selected_input_targets.length; ++i){
            double target  = Double.parseDouble(selected_signal_targets.get(i));
            selected_input_targets[i] = target;
        }*/
        
    }
    
    public String getAge_buffer() {
        return age_buffer;
    }

    public void setAge_buffer(String age_buffer) {
        this.age_buffer = age_buffer;
    }

    public int[] getDrugs_buffer() {
        return drugs_buffer;
    }

    public void setDrugs_buffer(int[] drugs_buffer) {
        this.drugs_buffer = drugs_buffer;
    }

    public String getFirstname_buffer() {
        return firstname_buffer;
    }

    public void setFirstname_buffer(String firstname_buffer) {
        this.firstname_buffer = firstname_buffer;
    }

    public String getName_buffer() {
        return name_buffer;
    }

    public void setName_buffer(String name_buffer) {
        this.name_buffer = name_buffer;
    }

    public ArrayList<String> getPreconditions_buffer() {
        return preconditions_buffer;
    }

    public void setPreconditions_buffer(ArrayList<String> preconditions_buffer) {
        this.preconditions_buffer = preconditions_buffer;
    }

    public String getWeight_buffer() {
        return weight_buffer;
    }

    public void setWeight_buffer(String weight_buffer) {
        this.weight_buffer = weight_buffer;
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
    
    public HashMap<Integer, String> getSelected_signal_targets() {
        return selected_signal_targets;
    }

    public void setSelected_signal_targets(HashMap<Integer, String> selected_signal_targets) {
        this.selected_signal_targets = selected_signal_targets;
    }
    
    public ArrayList<String[]> getDrugs_changed() {
        return drugs_changed;
    }

    public void setDrugs_changed(ArrayList<String[]> drugs_changed) {
        this.drugs_changed = drugs_changed;
    }

    public String getMonitoring_intervall_buffer() {
        return monitoring_intervall_buffer;
    }

    public void setMonitoring_intervall_buffer(String monitoring_intervall_buffer) {
        this.monitoring_intervall_buffer = monitoring_intervall_buffer;
    }
    
    public double[] getSelected_input_targets() {
        return selected_input_targets;
    }

    public void setSelected_input_targets(double[] selected_input_targets) {
        this.selected_input_targets = selected_input_targets;
    }

    public int[] getSelected_inputs() {
        return selected_inputs;
    }

    public void setSelected_inputs(int[] selected_inputs) {
        this.selected_inputs = selected_inputs;
    }

    public HashMap<Integer, String> getSelected_signal_targets_buffer() {
        return selected_signal_targets_buffer;
    }

    public void setSelected_signal_targets_buffer(HashMap<Integer, String> selected_signal_targets_buffer) {
        this.selected_signal_targets_buffer = selected_signal_targets_buffer;
    }
    
    public boolean isIs_valid() {
        return is_valid;
    }

    public void setIs_valid(boolean is_valid) {
        this.is_valid = is_valid;
    }
}
