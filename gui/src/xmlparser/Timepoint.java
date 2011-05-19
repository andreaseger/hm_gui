package xmlparser;

import fisparser.RulesOutput;
import java.util.Map;

public class Timepoint {
	private Integer _id;
	private Map<Integer,Double> _inputs;
	private Map<Integer,Input> _sets;
	private Map<Integer, Double> _rules;
	private Double _output;

	public Timepoint() {
		super();
	}

	public Timepoint(Integer id, Map<Integer,Double> inputs, Map<Integer,Input> sets, Map<Integer, Double> rules, Double output) {
		super();
		this._id = id;
		this._inputs = inputs;
		this._sets = sets;
		this._rules = rules;
		this._output = output;
	}

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}

	public Map<Integer,Double> getInputs() {
		return _inputs;
	}

	public void setInputs(Map<Integer,Double> inputs) {
		this._inputs = inputs;
	}

	public Map<Integer,Input> getSets() {
		return _sets;
	}

	public void setSets(Map<Integer,Input> sets) {
		this._sets = sets;
	}

	public Map<Integer, Double> getRules() {
		return _rules;
	}

	public void setRules(Map<Integer, Double> rules) {
		this._rules = rules;
	}

	public Double getOutput() {
		return _output;
	}
  public String printOutputByRule(RulesOutput r){
    return r.toString() + "=" + _output;
  }

	public void setOutput(Double output) {
		this._output = output;
	}

	@Override
	public String toString() {
		return "Timepoint " + _id + "\n\tInputValues=" + _inputs + "\n\tSets=" + _sets + "\n\tRules=" + _rules + "\n\tOutput=" + _output + "]";
	}

}
