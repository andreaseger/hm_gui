/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.List;

/**
 *
 * @author sch1zo
 */
public class ParserImpl extends AbstractParser{
  public void ParserCallback(List<Timepoint> points){
     System.out.println("a new timepoint read");
  }
}
