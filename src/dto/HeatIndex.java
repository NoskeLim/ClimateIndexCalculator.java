//dto package 내에서 존재
package dto;

// https://www.weather.gov/ama/heatindex
// https://www.calculator.net/heat-index-calculator.html
// Lab3 HeatIndex
public enum HeatIndex {
	EXTREME_DANGER, DANGER, EXTREME_CAUTION, CAUTION;

	// EXTREME_DANGER 130 F ~ (54 C ~)  
	// DANGER 105 ~ 130 F (41 ~ 54 C)   
	// EXTREME_CAUTION 90 ~ 105 F (32 ~ 41 C)   
	// CAUTION 80 ~ 90 F (27 ~ 32 C)
	public static HeatIndex getIndex(double value) {
		if (value > 130.0) 
			return HeatIndex.EXTREME_DANGER;
		else if (value >= 105.0 && value < 130.0) 
			return HeatIndex.DANGER;
		else if (value >= 90.0 && value < 105.0) 
			return HeatIndex.EXTREME_CAUTION;
		else if (value >= 80.0 && value < 90)
			return HeatIndex.CAUTION;	
		else
			return null;
	}
}
