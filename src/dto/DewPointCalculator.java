package dto;

import java.util.Objects;

// https://www.calculator.net/dew-point-calculator.html
// Lab3 DewPointCalculator
public class DewPointCalculator extends WeatherCalculator{
	double temperature; // fahrenheit
	double relativeHumidity; // %
	double value;
	
	//WeatherCalculaotr의 Mode에 따른 객체 반환 메소드
	public DewPointCalculator() {
		this(new WeatherData(null,0,0,0));
	}
	
	//WeatherCalculaotr의 data입력값의 Mode에 따른 객체 반환 메소드
	public DewPointCalculator(WeatherData weatherData) {
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

	public static double fromFahrenheitToCelsius(double F) {
        return (F - 32.0) * (5.0 / 9.0);
    }
	
	public static double fromCelsiusToFahrenheit(double C) {
        return ((9.0 / 5.0) * C + 32.0);
    }
	
	public static double calculate(double F, double RH) {
		double T = fromFahrenheitToCelsius(F);
		double value = (243.12*(Math.log(RH/100) + 17.62*T/(243.12+T)))/(17.62 - (Math.log(RH/100) + 17.62*T/(243.12+T)));		
		value = fromCelsiusToFahrenheit(value);
		return Math.round(value*10)/10.0;
	}
	
	//weatherData를 활용하여 계싼
	@Override //weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}
	
	//도표 생성 메소드
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void printTable() {
		int[] humidities = {100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10};
		int[] fahrenheit = {110, 105, 100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 32};
		System.out.print("F/RH\t100\t95\t90\t85\t80\t75\t70\t65\t60\t55\t50\t45\t40\t35\t30\t25\t20\t15\t10\n");
		for (int i = 0; i < fahrenheit.length; i++) {
			System.out.print(fahrenheit[i] + "\t");
			for (int j = 0; j < humidities.length; j++) {
				double dpt = calculate(fahrenheit[i], humidities[j]);
				if (dpt >= 32) System.out.print(dpt + "\t");
				else System.out.print("\t\t");
			}
			System.out.print("\n");
		}
	}
	
	//userinput값을 활용한 calculation
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void getUserInput() {
		System.out.println("Calculate DewPoint");
		System.out.print("Please enter temperature (F): ");
		weatherData.temperature = controller.UserInput.getDouble();
		System.out.print("Please enter relative humidity (%): ");
		weatherData.relativeHumidity = controller.UserInput.getDouble();	
	}
	
	//input값 혹은 weatherData를 받아서 풀력하기 위한 toString
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public String toString() {
		return "DewPointCalculator [temperature=" + weatherData.getTemperature() + ", relativeHumidity=" + weatherData.getRelativeHumidity() + ", value="
				+ value + "]";
	}
	
	//equals와 hashcode 오버라이딩하여 같은 데이터임을 명시함 - HastSet을 위함
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public boolean equals(Object other) { // Object.equals overriding
	if (this == other) return true;
	if (other instanceof DewPointCalculator) {
		DewPointCalculator that = (DewPointCalculator) other;
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
