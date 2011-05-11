/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Date;


/**
 *
 * @author max
 */
public class GraphData {
    
    
    private final Date date;
    private final double value;

    public GraphData(Date date, double value){
        this.value = value;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
    
    
}
