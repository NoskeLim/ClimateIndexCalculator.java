package dto;

//enum Mode 클래스 (각 모드둘울 enum클래스를 활용)
public enum Mode {
	DEW_POINT,
	WIND_CHILL_TEMPERATURE,
	HEAT_INDEX,
	DISCOMFORT_INDEX,
	SI;
	
	public static Mode valueOf(int mode) {
		// switch/ if-elseif
		if (mode == 1)
			return DEW_POINT;
		else if (mode == 2)
			return WIND_CHILL_TEMPERATURE;
		else if (mode == 3)
			return HEAT_INDEX;
		else if (mode == 4)
			return DISCOMFORT_INDEX;
		else if (mode == 5)
			return SI;
		return null;
	}
}
