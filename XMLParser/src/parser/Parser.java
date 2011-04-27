package parser;

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

public class Parser {

	public static void main(String[] args) throws Exception {

		List<Timepoint> timepoints = new ArrayList<Timepoint>();
		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();
		
		long startTime = System.currentTimeMillis();

		NodeList timestamps = (NodeList) xPath.evaluate("/Timepoints/*", new InputSource(new FileReader("resources/test.xml")), XPathConstants.NODESET);
		for (int i = 0; i < timestamps.getLength(); i++) {
			Element ts = (Element) timestamps.item(i);
			Timepoint next = new Timepoint();
			
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
				rules.put(index, Double.parseDouble(rule.getValue()) );
			}
			
			next.setRules(rules);
			next.setOutput(Double.parseDouble(xPath.evaluate("OutputValues/@Output0", ts)));
			timepoints.add(next);
			//System.out.println(next.toString());
		}
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("fertig | " + timepoints.size() + " | Time: " + estimatedTime);
	}
}
