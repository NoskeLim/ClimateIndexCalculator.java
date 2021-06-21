package dto;

//각 모드에 따른 상속된 클래스들을 계산해주는 클래스
public class WeatherCalculatorFactory {
	//WeatherCalculaotr의 Mode에 따른 객체 반환 메소드
	public static WeatherCalculator getInstance(Mode mode) {
		// switch/ if-else/ elseif
		if (mode == Mode.WIND_CHILL_TEMPERATURE)
			return new WindChillTemperatureCalculator();
		else if (mode == Mode.HEAT_INDEX)
			return new HeatIndexCalculator();
		else if (mode == Mode.DEW_POINT)
			return new DewPointCalculator();
		else if (mode == Mode.DISCOMFORT_INDEX)
			return new DiscomfortIndexCalculator();
		else if (mode == Mode.SI)
			return new CorruptionIndexCalculator();
		else
			return null;
	}
	
	//WeatherCalculaotr의 data입력값의 Mode에 따른 객체 반환 메소드
	public static WeatherCalculator getInstance(Mode mode, WeatherData data) {
		// switch/ if-else/ elseif
		if (mode == Mode.WIND_CHILL_TEMPERATURE)
			return new WindChillTemperatureCalculator(data);
		else if (mode == Mode.HEAT_INDEX) 
			return new HeatIndexCalculator(data);
		else if (mode == Mode.DEW_POINT)
			return new DewPointCalculator(data);
		else if (mode == Mode.DISCOMFORT_INDEX)
			return new DiscomfortIndexCalculator(data);
		else if (mode == Mode.SI)
			return new CorruptionIndexCalculator(data);
		else
			return null;		
	}
}