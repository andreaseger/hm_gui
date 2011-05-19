/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An observable XML parser.
 * 
 * @author Moe
 */
public class ObservableParser extends AbstractParser implements Runnable{
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
    private final LinkedList<List<Timepoint>> timepoints = new LinkedList<List<Timepoint>>();
    
    /**
     * Maximum number of timepoints. If more timepoints are read, the oldest timepoints are discarded.
     */
    private final static int MAX_TIMEPOINTS = 100;

    private Thread runner;
    private String[] files;

    public ObservableParser(String[] files){
      super();
      this.files = files;

      runner = new Thread(this);
    }

    public void start(){
      runner.start();
    }

    @Override
    public void run() {
      try {
        run(files);
      } catch (Exception ex) {
        //Logger.getLogger(ThreadedParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public void ParserCallback(List<Timepoint> points) {
      timepoints.add(points);

      while(timepoints.size() > MAX_TIMEPOINTS) {
          timepoints.removeFirst();
      }
      //HACK to get faster to the interesting data
      if (points.get(0).getId() < 250) {
        return;
      }

      notifyObservers();

      try {
        runner.sleep(1000);
      } catch (InterruptedException ex) {
        Logger.getLogger(ObservableParser.class.getName()).log(Level.SEVERE, null, ex);
      }                
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
