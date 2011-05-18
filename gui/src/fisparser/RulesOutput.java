/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fisparser;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sch1zo
 */
public enum RulesOutput {

  HIGHDECR(1,"High-Decrement"),
  SMALLDEC(2,"Small-Decrement"),
  NOCHANGE(3,"No Change"),
  SMALLINCR(4,"Small-Increment"),
  HIGHINCR(5,"High-Increment");

  private static final Map<Integer, RulesOutput> lookup = new HashMap<Integer, RulesOutput>();

  static {
    for (RulesOutput s : EnumSet.allOf(RulesOutput.class)) {
      lookup.put(s.getCode(), s);
    }
  }
  private int code;
  private String text;

  private RulesOutput(int code, String text) {
    this.code = code;
    this.text = text;
  }

  public int getCode() {
    return code;
  }

  public static RulesOutput get(int code) {
    return lookup.get(code);
  }

  @Override
  public String toString(){
    return text;
  }
}
