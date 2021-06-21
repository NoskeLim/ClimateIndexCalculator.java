package dto;

import java.util.Objects;

// https://www.calculator.net/heat-index-calculator.html
// Lab3 HeatIndexCalculator
public class HeatIndexCalculator extends WeatherCalculator{
	double temperature; // fahrenheit
	double relativeHumidity; // %
	double value; // HeatIndex
	
	//WeatherCalculaotr의 Mode에 따른 객체 반환 메소드
	public HeatIndexCalculator() {
		this(new WeatherData(null,0,0,0));
	}
	
	//WeatherCalculaotr의 data입력값의 Mode에 따른 객체 반환 메소드
	public HeatIndexCalculator(WeatherData weatherData) {
		super(weatherData);
	}
	
	//getters, setters
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	// HI = -42.379 + (2.04901523*F) + (10.14333127*R) - (0.22475541*F*R) - (0.00683770*F*F) - (0.05481717*R*R) + (0.00122874*F*F*R) + (0.00085282*F*R*R) - (0.00000199*F*F*R*R) [F, R]
	public static double calculate(double F, double RH) {
		if (F < 80.0) return 0.0;
		double value = -42.379 + (2.04901523*F) + (10.14333127*RH) - (0.22475541*F*RH) - (0.00683770*F*F) - (0.05481717*RH*RH) + (0.00122874*F*F*RH) + (0.00085282*F*RH*RH) - (0.00000199*F*F*RH*RH);	
		return Math.round(value*10)/10.0;
	}
	
	//weatherData를 활용하여 계산
	@Override //weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}
	
	@Override
	public void printTable() {
		int[] fahrenheit = {80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110};
		int[] humidities = {40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
		System.out.print("RH/F\t80\t82\t84\t86\t88\t90\t92\t94\t96\t98\t100\t102\t104\t106\t108\t110\n");
		for (int i = 0; i < humidities.length; i++) {
			System.out.print(humidities[i] + "\t");
			for (int j = 0; j < fahrenheit.length; j++) {
				double value = calculate(fahrenheit[j], humidities[i]);
				if (value < 137) System.out.print(value + "\t");
				else System.out.print("\t\t");
			}
			System.out.print("\n");
		}
	}
	
	//도표 생성 메소드
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void getUserInput() {
		System.out.println("HeatIndex");
		System.out.print("Please enter temperature (F): ");
		weatherData.temperature = controller.UserInput.getDouble();
		System.out.print("Please enter relative humidity (%): ");
		weatherData.relativeHumidity = controller.UserInput.getDouble();
	}
	
	//userinput값을 활용한 calculation
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public String toString() {
		return "HeatIndexCalculator [temperature=" + weatherData.getTemperature() + ", relativeHumidity=" + weatherData.getRelativeHumidity() 
				+ ", value=" + value + ", index=" + HeatIndex.getIndex(value) + "]";
	}
	
	//equals와 hashcode 오버라이딩하여 같은 데이터임을 명시함 - HastSet을 위함
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public boolean equals(Object other) { // Object.equals overriding
	if (this == other) return true;
	if (other instanceof HeatIndexCalculator) {
		HeatIndexCalculator that = (HeatIndexCalculator) other;
		return this.weatherData.getTemperature() == that.weatherData.getTemperature() &&
		this.weatherData.getRelativeHumidity() == that.weatherData.getRelativeHumidity() &&
		this.getValue() == that.getValue();
		}
		return false;
	}
	
	//Hastset
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public int hashCode() { // Object.hashCode overriding
		return Objects.hash(weatherData.getTemperature(), weatherData.getRelativeHumidity(), getValue());
	}
}

	
