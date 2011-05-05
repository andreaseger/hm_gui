/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fisparser;
/**
 *
 * @author sch1zo
 */
public class Rule {
  public RulesInput MAP;
  public RulesInput CVP;
  public RulesInput CL1;
  public RulesInput SVR;
  public RulesOutput OUT;
  public Rule(RulesInput map, RulesInput cvp, RulesInput cl1, RulesInput svr, RulesOutput out){
    MAP = map;
    CVP = cvp;
    CL1 = cl1;
    SVR = svr;
    OUT = out;
  }
  public Rule(int map, int cvp, int cl1, int svr, int out){
    MAP = RulesInput.get(map);
    CVP = RulesInput.get(cvp);
    CL1 = RulesInput.get(cl1);
    SVR = RulesInput.get(svr);
    OUT = RulesOutput.get(out);
  }

  @Override
  public String toString(){
    StringBuilder t = new StringBuilder("MAP: " + MAP.toString());
    t.append(" CVP: ").append(CVP.toString());
    t.append(" CL1: ").append(CL1.toString());
    t.append(" SVR: ").append(SVR.toString());
    t.append("|| OUT: ").append(OUT.toString());
    return t.toString();
  }
}
