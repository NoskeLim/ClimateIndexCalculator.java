//dto package 내에서 존재
package dto;

//Lab4 Your Code
public enum CorruptionIndex {
	Low, Middle, High;
	
	//High value > 7.0
	//Middle 3.0 =< value < 7.0
	//Low value < 3.0
	public static CorruptionIndex getIndex(double value) {
		if (value > 7.0) 
			return CorruptionIndex.High;
		else if (value >= 3.0 && value < 7.0) 
			return CorruptionIndex.Middle;
		else if (value <3.0) 
			return CorruptionIndex.Low;
		else 
			return null;
	}
}
