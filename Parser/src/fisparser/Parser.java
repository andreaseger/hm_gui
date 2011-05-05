/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fisparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author sch1zo
 */
public class Parser {
  private Pattern p;
  private List<Rule> rules;

  public Parser(){
    p = Pattern.compile("(\\s|,\\s)");
    rules = new ArrayList<Rule>();
  }
  public void run(String[] files) throws FileNotFoundException{
    for(String file:files){
      processLineByLine(new File(file));
    }
  }

  /** Template method that calls {@link #processLine(String)}.  */
  public final void processLineByLine(File fFile) throws FileNotFoundException {
    //Note that FileReader is used, not File, since File is not Closeable
    Scanner scanner = new Scanner(new FileReader(fFile));
    Boolean foundrules = false;
    try {
      //first use a Scanner to get each line
      String line;
      while ( scanner.hasNextLine() ){
        line = scanner.nextLine();
        if(!foundrules && line.equals("[Rules]")){
          foundrules = true;
          continue;
        }
        if(foundrules && !line.isEmpty())
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
    String[] a = p.split(aLine);
    rules.add(new Rule( Integer.parseInt(a[0]),
                          Integer.parseInt(a[1]),
                          Integer.parseInt(a[2]),
                          Integer.parseInt(a[3]),
                          Integer.parseInt(a[4])));
  }
  public List<Rule> getRules(){
    return rules;
  }
  public List<Rule> getRules(String[] files) throws FileNotFoundException{
    run(files);
    return rules;
  }


  public static void main(String... aArgs) throws FileNotFoundException {
    Parser parser = new Parser();
    List<Rule> lr = parser.getRules(aArgs);
    for(Rule r : lr){
      System.out.println(r);
    }
  }
}
