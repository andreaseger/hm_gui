/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.*;
import java.util.*;

public class Reader {

    private String name;
    private String age;
    private String weight;
    private String[] pre_conditions;
    private String[] unvertraeglichkeiten;
    private String[] drugs_group1;
    private String[] drugs_group2;
    private String[] drugs_group3;
    private String[] drugs_group4;
    private String[] input_sollwert;
    
    
public Reader() {
    
    File file = new File("D:/ICU.cfg");
    Properties propFile = new Properties();

    try {
         FileInputStream stream = new FileInputStream(file);

        propFile.load(stream);
        this.age = propFile.getProperty("AGE");
        this.name = propFile.getProperty("NAME");
        this.weight = propFile.getProperty("WEIGHT");
        String[] strings = {"keine", propFile.getProperty("PRECONDITION1"), propFile.getProperty("PRECONDITION2"), propFile.getProperty("PRECONDITION3"), propFile.getProperty("PRECONDITION4"), propFile.getProperty("PRECONDITION5"), propFile.getProperty("PRECONDITION6"),
        propFile.getProperty("PRECONDITION7"), propFile.getProperty("PRECONDITION8"), propFile.getProperty("PRECONDITION9"), propFile.getProperty("PRECONDITION10"), propFile.getProperty("PRECONDITION11"),
        propFile.getProperty("PRECONDITION12"), propFile.getProperty("PRECONDITION13"), propFile.getProperty("PRECONDITION14")};
        this.pre_conditions = strings;
        


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

    public String getAge() {
        return age;
    }

    public String[] getDrugs_group1() {
        return drugs_group1;
    }

    public String[] getDrugs_group2() {
        return drugs_group2;
    }

    public String[] getDrugs_group3() {
        return drugs_group3;
    }

    public String[] getDrugs_group4() {
        return drugs_group4;
    }

    public String[] getInput_sollwert() {
        return input_sollwert;
    }

    public String[] getPre_conditions() {
        return pre_conditions;
    }

    public String[] getUnvertraeglichkeiten() {
        return unvertraeglichkeiten;
    }

    public String getWeight() {
        return weight;
    }
    
    public void setAge(String age) {
        this.age = age;
    }

    public void setDrugs_group1(String[] drugs_group1) {
        this.drugs_group1 = drugs_group1;
    }

    public void setDrugs_group2(String[] drugs_group2) {
        this.drugs_group2 = drugs_group2;
    }

    public void setDrugs_group3(String[] drugs_group3) {
        this.drugs_group3 = drugs_group3;
    }

    public void setDrugs_group4(String[] drugs_group4) {
        this.drugs_group4 = drugs_group4;
    }

    public void setInput_sollwert(String[] input_sollwert) {
        this.input_sollwert = input_sollwert;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPre_conditions(String[] pre_conditions) {
        this.pre_conditions = pre_conditions;
    }

    public void setUnvertraeglichkeiten(String[] unvertraeglichkeiten) {
        this.unvertraeglichkeiten = unvertraeglichkeiten;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
