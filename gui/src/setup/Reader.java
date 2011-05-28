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
    
    File file = new File("resources/ICU.cfg");
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

        
        for(int i = 1; i < result.getSignals().length+1; ++i){
            String key = "SIGNAL"+i;
            string = propFile.getProperty(key);
            String[] ss = string.split(",");
            result.getSignals()[i-1] = ss[0];
            result.getSignal_targets().put(ss[0], ss[1]);
        }
        
        for(int i = 1; i < (6+1); ++i){
            String drug = "DRUG"+i;
            string = propFile.getProperty(drug);
            String[] ss = string.split(",");
            result.getDrugs().add(ss);
        }
                
        result.setMonitoring_intervall(propFile.getProperty("INTERVALINSECONDS"));


    } catch (FileNotFoundException e) {
        System.out.println("File Not Found");
    } catch (IOException e2) {
        System.out.println("Konnte Stream nicht laden");
    }

    }
        
}
