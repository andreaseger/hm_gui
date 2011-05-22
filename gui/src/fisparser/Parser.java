/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fisparser;

import gui.OutputEnum;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author sch1zo
 */
public class Parser {
  private Pattern p;
  private EnumMap<OutputEnum, List<Rule>> rules;

  public Parser(){
    p = Pattern.compile("(\\s|,\\s)");
  }
  public void run(String[] files) throws FileNotFoundException{
    rules = new EnumMap<OutputEnum, List<Rule>>(OutputEnum.class);
    //rules = new ArrayList<List<Rule>>();
    for (int i = 0; i < files.length; i++) {
      rules.put(OutputEnum.get(i), new ArrayList<Rule>());
      //rules.add(new ArrayList<Rule>());
      processLineByLine(new File(files[i]),i);
    }
  }

  public void run(String o0,String o1, String o2, String o3) throws FileNotFoundException{
    run(new String[]{o0,o1,o2,o3});
  }

  /** Template method that calls {@link #processLine(String)}.  */
  public final void processLineByLine(File fFile, int index) throws FileNotFoundException {
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
          processLine( line, index );
      }
    }
    finally {
      //ensure the underlying stream is always closed
      //this only has any effect if the item passed to the Scanner
      //constructor implements Closeable (which it does in this case).
      scanner.close();
    }
  }
  protected void processLine(String aLine,int index){
    String[] a = p.split(aLine);

    rules.get(OutputEnum.get(index)).add(new Rule(  Integer.parseInt(a[0]),
                                                    Integer.parseInt(a[1]),
                                                    Integer.parseInt(a[2]),
                                                    Integer.parseInt(a[3]),
                                                    Integer.parseInt(a[4])));
  }
  public List<Rule> getRules(int index){
    return rules.get(OutputEnum.get(index));
  }
  public List<Rule> getRules(OutputEnum o){
    return rules.get(o);
  }
  public EnumMap<OutputEnum,List<Rule> > getAllRules(){
    return rules;
  }
}
