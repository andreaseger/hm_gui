/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sch1zo
 */
public enum InputEnum {
  MAP(0,"MAP","Mean Arterial Pressure","mmHg"),
  CVP(1,"CVP", "Central Venous Pressure","mmHg"),
  SVR(2,"SVR", "Systemic Vascular Resistance","dyn*sec"),
  CO(3,"CO", "Cardiac Output","l/min");

  private static final Map<Integer, InputEnum> lookup = new HashMap<Integer, InputEnum>();

  static {
    for (InputEnum s : EnumSet.allOf(InputEnum.class)) {
      lookup.put(s.getCode(), s);
    }
  }
  private int code;
  private String name;
  private String longname;
  private String unit;

  private InputEnum(int code, String name, String longname, String unit) {
    this.code = code;
    this.name = name;
    this.longname = longname;
    this.unit = unit;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
  public String getLongName() {
    return longname;
  }
  public String getUnit() {
    return unit;
  }


  public static InputEnum get(int code) {
    return lookup.get(code);
  }

  @Override
  public String toString(){
    return name;
  }
}
