/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An observable XML parser.
 * 
 * @author Moe
 */
public class ObservableParser extends AbstractParser{
    /**
     * Interface which every observer has to implement.
     */
    public interface Observer {
        /**
         * Is called when new data has been collected.
         * @param parser Parser, which holds the data.
         */
        public void update(ObservableParser parser);
    }
    /**
     * List of observers.
     */
    private final List<Observer> observers = new ArrayList<Observer>();
    
    /**
     * Data.
     */
    private final List<List<Timepoint>> timepoints = new ArrayList<List<Timepoint>>();
    
    /**
     * Maximum number of timepoints. If more timepoints are read, the oldest timepoints are discarded.
     */
    private final static int MAX_TIMEPOINTS = 100;


    @Override
    public void ParserCallback(List<Timepoint> points) {
        timepoints.add(points);
        
        while(timepoints.size() > MAX_TIMEPOINTS) {
            timepoints.remove(0);
        }
        
        notifyObservers();
    }

    /**
     * Notifies all observers.
     */
    private void notifyObservers() {
        for(Observer observer: this.observers) {
            observer.update(this);
        }
    }    
    
    /**
     * Adds an observer.
     * @param observer Observer.
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
    
    /**
     * Removes an observer.
     * @param observer Observer.
     */
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
    
    /**
     * Gets the timepoints.
     * @return Timepoints.
     */
    public List<List<Timepoint>> getTimepoints() {
        return Collections.unmodifiableList(timepoints);
    }
}
