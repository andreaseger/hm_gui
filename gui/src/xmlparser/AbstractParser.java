package xmlparser;

import gui.OutputEnum;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

abstract public class AbstractParser{
  XPathFactory factory;
  XPath xPath;

  public AbstractParser(){
		factory = XPathFactory.newInstance();
		xPath = factory.newXPath();
  }

	public void run(String[] files) throws Exception {
    List<NodeList> nlists = new ArrayList<NodeList>();
    for(String f:files){
      nlists.add((NodeList) xPath.evaluate("/Timepoints/*", new InputSource(new FileReader(f)), XPathConstants.NODESET));
    }
    int minsize=Integer.MAX_VALUE;
    for(NodeList l:nlists){
      if(l.getLength() < minsize)
        minsize = l.getLength();
    }

		for (int i = 0; i < minsize; i++) {
      List<Timepoint> newItems = new ArrayList<Timepoint>();
      for(int n=0;n<nlists.size();n++){
        Element ts = (Element) nlists.get(n).item(i);
        Timepoint next = new Timepoint();
        next.setType(OutputEnum.get(n));

        next.setId(Integer.parseInt(ts.getNodeName().substring(9, ts.getNodeName().length())) );

        NodeList inputattrs = (NodeList) xPath.evaluate("InputValues/@*", ts, XPathConstants.NODESET);
        Map<Integer,Double> inputValues = new HashMap<Integer, Double>(4);
        for (int j = 0; j < inputattrs.getLength(); j++) {
          Attr rule = (Attr) inputattrs.item(j);
          int index = Integer.parseInt(rule.getName().substring(5, rule.getName().length()));
          inputValues.put(index, Double.parseDouble(rule.getValue()) );
        }
        next.setInputs(inputValues);

        NodeList setnodes = (NodeList) xPath.evaluate("Sets/*", ts, XPathConstants.NODESET);
        Map<Integer,Input> sets = new HashMap<Integer, Input>(4);
        for (int j = 0; j < setnodes.getLength(); j++) {
          Element input = (Element) setnodes.item(j);
          int index = Integer.parseInt(input.getNodeName().substring(5, input.getNodeName().length()));
          sets.put(index, new Input(Double.parseDouble(input.getAttribute("low")), Double.parseDouble(input.getAttribute("normal")), Double.parseDouble(input.getAttribute("high"))) );
        }
        next.setSets(sets);

        NodeList ruleattrs = (NodeList) xPath.evaluate("Rules/@*", ts, XPathConstants.NODESET);
        Map<Integer, Double> rules = new HashMap<Integer, Double>(81);
        for (int j = 0; j < ruleattrs.getLength(); j++) {
          Attr rule = (Attr) ruleattrs.item(j);
          int index = Integer.parseInt(rule.getName().substring(4, rule.getName().length()));
          double value = Double.parseDouble(rule.getValue());
          if(value != 0){
            rules.put(index, value );
          }
        }

        next.setRules(rules);
        next.setOutput(Double.parseDouble(xPath.evaluate("OutputValues/@Output0", ts)));

        newItems.add(next);
      }
      ParserCallback(newItems);
		}
	}

  abstract public void ParserCallback(List<Timepoint> points);
}
