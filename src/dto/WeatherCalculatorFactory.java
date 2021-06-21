package dto;

//�� ��忡 ���� ��ӵ� Ŭ�������� ������ִ� Ŭ����
public class WeatherCalculatorFactory {
	//WeatherCalculaotr�� Mode�� ���� ��ü ��ȯ �޼ҵ�
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
	
	//WeatherCalculaotr�� data�Է°��� Mode�� ���� ��ü ��ȯ �޼ҵ�
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