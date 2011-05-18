/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.*;
import java.util.*;

public class Reader {

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
    private HashMap<String, String> input_goal_values;

        
      
public Reader() {
    
    File file = new File("D:/ICU.cfg");
    Properties propFile = new Properties();

    try {
         FileInputStream stream = new FileInputStream(file);

        propFile.load(stream);
        this.age = propFile.getProperty("AGE");
        this.name = propFile.getProperty("NAME");
        this.firstname = propFile.getProperty("FIRSTNAME");
        this.weight = propFile.getProperty("WEIGHT");
        String string = propFile.getProperty("PRECONDITION");
        this.pre_conditions = string.split(",");
        
        string = propFile.getProperty("VASODILATOR");
        this.drugs_vasodilator = string.split(",");
        /*String[] strings = string.split(",");
        this.drugs_vasodilator = new String[strings.length+1];
        drugs_vasodilator[0] = "Bitte waehlen";
        for(int i=1; i<drugs_vasodilator.length; ++i){
            drugs_vasodilator[i] = strings[i-1];
        }*/
        string = propFile.getProperty("VASOCONSTRICTOR");
        this.drugs_vasoconstrictor = string.split(",");
                
        string = propFile.getProperty("INOTROPE");
        this.drugs_inotrope = string.split(",");
        
        
        string = propFile.getProperty("VOLUME");
        this.drugs_volume = string.split(",");
        
        
        string = propFile.getProperty("SIGNALS");
        this.signals = string.split(",");
        if(signals.length != 11)
            System.out.println("too many signals!!!!");
        string = propFile.getProperty("DRUGS");
        String[] strings = string.split("-");
        for(int i=0;i<strings.length;++i){
            String[] drug = strings[i].split(",");
            drugs.add(drug);
        }
        this.monitoring_intervall = propFile.getProperty("INTERVALINSECONDS");
        //FEHLEN NOCH ??????????????
        //input_goal_values.


    } catch (FileNotFoundException e) {
        System.out.println("File Not Found");
    } catch (IOException e2) {
        System.out.println("Konnte Stream nicht laden");
    }

    }


    //methode: write in File -> String s = age_textfield.getText();
    //int[] s = jList1.getSelectedIndices(); usw...

    public String getName() {
        return name;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public String getAge() {
        return age;
    }

    public String[] getDrugs_vasodilator() {
        return drugs_vasodilator;
    }

    public String[] getDrugs_vasoconstrictor() {
        return drugs_vasoconstrictor;
    }

    public String[] getDrugs_inotrope() {
        return drugs_inotrope;
    }

    public String[] getDrugs_volume() {
        return drugs_volume;
    }

    public String[] getPre_conditions() {
        return pre_conditions;
    }

    public String[] getIntolerances() {
        return intolerances;
    }

    public String getWeight() {
        return weight;
    }
    
    public void setAge(String age) {
        this.age = age;
    }

   
    public void setName(String name) {
        this.name = name;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPre_conditions(String[] pre_conditions) {
        this.pre_conditions = pre_conditions;
    }

    public void setIntolerances(String[] intolerances) {
        this.intolerances = intolerances;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
    public String[] getSignals() {
        return signals;
    }

    
    public ArrayList<String[]> getDrugs() {
        return drugs;
    }

    public String getMonitoring_intervall() {
        return monitoring_intervall;
    }

    public void setMonitoring_intervall(String monitoring_intervall) {
        this.monitoring_intervall = monitoring_intervall;
    }
    
    public HashMap<String, String> getInput_goal_values() {
        return input_goal_values;
    }
}
