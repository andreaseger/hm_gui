/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import gui.OutputEnum;
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
    private final static int MAX_TIMEPOINTS = 150;

    private Thread runner;
    private OutputEnum[] output;
    private final int sleeper;
    private boolean skip = false;
    public ObservableParser(OutputEnum[] output, int sleep,boolean skip){
      super();
      this.output = output;
      this.sleeper = sleep;
      this.skip = skip;

      runner = new Thread(this);
    }

    public ObservableParser(OutputEnum o0, OutputEnum o1, OutputEnum o2,OutputEnum o3, int sleep){
      super();
      this.output = new OutputEnum[]{o0,o1,o2,o3};
      sleeper = sleep;

      runner = new Thread(this);
    }

    public void start(){
      runner.start();
    }

    @Override
    public void run() {
      try {
        run(output);
      } catch (Exception ex) {
        Logger.getLogger(ObservableParser.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public void ParserCallback(List<Timepoint> points) {
      timepoints.add(points);

      while(timepoints.size() > MAX_TIMEPOINTS) {
          timepoints.removeFirst();
      }
      //HACK to get faster to the interesting data
      if (skip && points.get(0).getId() < 250) {
        return;
      }

      notifyObservers();

      try {
        runner.sleep(sleeper);
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

    public List<Timepoint>getLastTimepoint(){
      return Collections.unmodifiableList(timepoints.getLast());
    }
    public List<Timepoint>getFirstTimepoint(){
      return Collections.unmodifiableList(timepoints.getFirst());
    }
}
