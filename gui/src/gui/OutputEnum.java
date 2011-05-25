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
public enum OutputEnum {
  VOL(0,"HEAS","VOL"),
  DPM(1,"DPM","DPM"),
  NEP(2,"NEP","NEP"),
  ISDN(3,"ISDN","ISDN"),
  SNP(4,"SNP","ISDN"),
  PNP(5,"PNP","NEP"),
  DBT(6,"DBT","DPM");

  private static final Map<Integer, OutputEnum> lookup = new HashMap<Integer, OutputEnum>();

  static {
    for (OutputEnum s : EnumSet.allOf(OutputEnum.class)) {
      lookup.put(s.getCode(), s);
    }
  }
  private int code;
  private String name;
  private String filename;

  private OutputEnum(int code, String name, String filename) {
    this.code = code;
    this.name = name;
    this.filename = filename;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
  public String getUnit(){
    return "ug/kg/min";
  }

  public String getXMLPath() {
    return "resources/controller_" + name + ".xml";
  }

  public String getFisPath() {
    return "resources/cavacoMamdani" + name + "Change.fis";
  }

  public static OutputEnum get(int code) {
    return lookup.get(code);
  }

  @Override
  public String toString(){
    return name;
  }
}
