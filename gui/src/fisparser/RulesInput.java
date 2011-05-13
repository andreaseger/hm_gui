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
public enum RulesInput {

  LOW(1,"low"),
  NORMAL(2,"normal"),
  HIGH(3,"high");
    
  private static final Map<Integer, RulesInput> lookup = new HashMap<Integer, RulesInput>();

  static {
    for (RulesInput s : EnumSet.allOf(RulesInput.class)) {
      lookup.put(s.getCode(), s);
    }
  }
  private int code;
  private String text;

  private RulesInput(int code, String text) {
    this.code = code;
    this.text = text;
  }

  public int getCode() {
    return code;
  }

  public static RulesInput get(int code) {
    return lookup.get(code);
  }
  
  @Override
  public String toString(){
    return text;
  }
}
