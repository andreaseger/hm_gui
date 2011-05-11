/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;


/**
 *
 * @author sch1zo
 */
public class ThreadedParser  extends AbstractParser implements Runnable{
  Thread runner;
  String[] files;
  public ThreadedParser(String[] files){
    super();
    this.files = files;

    runner = new Thread(this);
		runner.start();
  }

  @Override
  public void ParserCallback(List<Timepoint> points){
    final int l = points.get(0).getId();
    SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            xmlparser.runner.label.setText("a new timepoint read: #" + l);
            //System.out.println(Thread.currentThread());
            //System.out.println("a new timepoint read " + t);
          }
        });

    //System.out.println(Thread.currentThread());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
      Logger.getLogger(ParserImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void run() {
    try {
      run(files);
    } catch (Exception ex) {
      Logger.getLogger(ThreadedParser.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
