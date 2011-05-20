package xmlparser;

import fisparser.RulesInput;
import java.text.DecimalFormat;

public class Input {
	
	private Double _low;
	private Double _normal;
	private Double _high;
	
	public Input(){}
	public Input(Double low, Double normal, Double high) {
		super();
		this._low = low;
		this._normal = normal;
		this._high = high;
	}

  public Double getValueByRule(RulesInput r){
    switch (r) {
      case LOW:
        return _low;
      case NORMAL:
        return _normal;
      case HIGH:
        return _high;
    }
    return 0.0;
  }


  public String printByRule(RulesInput r){
    DecimalFormat f = new DecimalFormat("#00.0");
    switch (r) {
      case LOW:
        return r.toString() + "=" + f.format(_low*100) + "%";
      case NORMAL:
        return r.toString() + "=" + f.format(_normal*100) + "%";
      case HIGH:
        return r.toString() + "=" + f.format(_high*100) + "%";
    }
    return "error";
  }

	public Double getLow() {
		return _low;
	}
	public Double getNormal() {
		return _normal;
	}
	public Double getHigh() {
		return _high;
	}
	public void setLow(Double low) {
		this._low = low;
	}

	public void setNormal(Double normal) {
		this._normal = normal;
	}

	public void setHigh(Double high) {
		this._high = high;
	}
	@Override
	public String toString() {
		return "[low=" + _low + ", normal=" + _normal + ", high=" + _high + "]";
	}
	
}
