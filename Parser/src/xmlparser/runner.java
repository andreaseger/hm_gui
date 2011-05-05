/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

/**
 *
 * @author sch1zo
 */
public class runner {
  public static void main(String [] args) throws Exception{
    if(args.length != 0){
      ParserImpl foo = new ParserImpl();
      foo.run(args);
    }else{
      System.out.println("no params");
    }
  }
}
