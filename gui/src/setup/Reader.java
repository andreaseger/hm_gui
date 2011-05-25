/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import java.io.*;
import java.util.*;

public class Reader {

    private Result result;

         
public Reader(Result result) {
    
    this.result = result;
    
    File file = new File("D:/ICU.cfg");
    Properties propFile = new Properties();

    try {
         FileInputStream stream = new FileInputStream(file);

        propFile.load(stream);
        result.setAge(propFile.getProperty("AGE"));
        result.setName(propFile.getProperty("NAME"));
        result.setFirstname(propFile.getProperty("FIRSTNAME"));
        result.setWeight(propFile.getProperty("WEIGHT"));
        String string = propFile.getProperty("PRECONDITION");
        result.setPre_conditions(string.split(","));
        
        string = propFile.getProperty("VASODILATOR");
        result.setDrugs_vasodilator(string.split(","));
        
        string = propFile.getProperty("VASOCONSTRICTOR");
        result.setDrugs_vasoconstrictor(string.split(","));
                
        string = propFile.getProperty("INOTROPE");
        result.setDrugs_inotrope(string.split(","));
        
        string = propFile.getProperty("VOLUME");
        result.setDrugs_volume(string.split(","));
        
        string = propFile.getProperty("SIGNALS");
        result.setSignals(string.split(","));
        if(result.getSignals().length != 11)
            System.out.println("too many signals!!!!");
        string = propFile.getProperty("DRUGS");
        String[] strings = string.split("-");
        for(int i=0;i<strings.length;++i){
            String[] drug = strings[i].split(",");
            result.getDrugs().add(drug);
        }
        result.setMonitoring_intervall(propFile.getProperty("INTERVALINSECONDS"));
        
        string = propFile.getProperty("SIGNAL_TARGETS");
        String[] targets = string.split(",");
        for(int i = 0; i < result.getSignals().length; ++i){
            result.getSignal_targets().put(result.getSignals()[i], targets[i]);
        }
        


    } catch (FileNotFoundException e) {
        System.out.println("File Not Found");
    } catch (IOException e2) {
        System.out.println("Konnte Stream nicht laden");
    }

    }


    //methode: write in File -> String s = age_textfield.getText();
    //int[] s = jList1.getSelectedIndices(); usw...
        
}
