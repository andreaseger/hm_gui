/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sch1zo
 */
public class ParserImpl extends AbstractParser{
  @Override
  public void ParserCallback(List<Timepoint> points){
     System.out.println("a new timepoint read");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Logger.getLogger(ParserImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
