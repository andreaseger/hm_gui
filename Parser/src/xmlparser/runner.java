/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sch1zo
 */
public class runner {

  static JLabel label;

  // Method which defines the appearance of the window.
    public static void showGUI() {
        JFrame frame = new JFrame("Simple Thread Demo");
        frame.setMinimumSize(new Dimension(200, 75));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Some Text");
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }




  public static void main(String [] args) throws Exception{

    if(args.length != 0){
      ThreadedParser foo = new ThreadedParser(args);
      //foo.run();
      System.out.println(Thread.currentThread());
      showGUI();
    }else{
      System.out.println("no params");
    }
  }
}
