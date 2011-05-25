/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logparser;

import fisparser.Rule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import xmlparser.Timepoint;

/**
 *
 * @author sch1zo
 */
public class Parser {
  private Pattern ptab;
  private List<Float[]> controllerOutputs;
  private List<Float[]> controllerInputs;
  private List<String> controllerTimestamps;
  private final Pattern ptime;
  private final Pattern pinputs;

  public Parser(){
    ptab = Pattern.compile("\\s\\t");
    ptime = Pattern.compile("\\s*,\\s*");
    pinputs = Pattern.compile("(:|\\s)");
    controllerOutputs = new ArrayList<Float[]>();
    controllerInputs = new ArrayList<Float[]>();
    controllerTimestamps = new ArrayList<String>();
  }
  public void run(String[] files) throws FileNotFoundException{
    processLineByLine(new File(files[0]));
  }
  public void run(String file) throws FileNotFoundException{
    processLineByLine(new File(file));
  }
  /** Template method that calls {@link #processLine(String)}.  */
  public final void processLineByLine(File fFile) throws FileNotFoundException {
    //Note that FileReader is used, not File, since File is not Closeable
    Scanner scanner = new Scanner(new FileReader(fFile));
    try {
      //first use a Scanner to get each line
      String line;
      while ( scanner.hasNextLine() ){
        line = scanner.nextLine();
        if(!line.isEmpty())
          processLine( line );
      }
    }
    finally {
      //ensure the underlying stream is always closed
      //this only has any effect if the item passed to the Scanner
      //constructor implements Closeable (which it does in this case).
      scanner.close();
    }
  }
  protected void processLine(String aLine){
    String[] a = ptab.split(aLine);
    String time= ptime.split(a[0])[1];

    String[] b = pinputs.split(a[1]);

    Float[] inputs = new Float[4];
    for (int i = 1; i < b.length; i++) {
      inputs[i-1] = Float.parseFloat(b[i]);
    }

    String[] c = pinputs.split(a[2]);
    Float[] outputs = new Float[4];
    for (int i = 1; i < c.length; i++) {
      outputs[i-1] = Float.parseFloat(c[i]);
    }
    controllerInputs.add(inputs);
    controllerOutputs.add(outputs);
    controllerTimestamps.add(time);
  }
  public List<Float[]> getInputs(){
    return controllerInputs;
  }
  public List<Float[]> getOutputs(){
    return controllerOutputs;
  }
  public List<String> getTimestamps(){
    return controllerTimestamps;
  }
}
