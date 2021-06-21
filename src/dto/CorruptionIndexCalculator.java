//dto package 내에서 존재
package dto;

import java.util.Objects;

//WeatherCalculator 추상클래스를 상속받아 weatherData를 사용하여 추상메소드 내부 구현
//Lab5 Your Code(SI) - CorruptionIndexCalculator
public class CorruptionIndexCalculator extends WeatherCalculator{
	double temperature;
	double relativeHumidity;
	double value;
	
	//WeatherCalculaotr의 Mode에 따른 객체 반환 메소드
	public CorruptionIndexCalculator() {
		this(new WeatherData(null,0,0,0));
	}
	
	//WeatherCalculaotr의 data입력값의 Mode에 따른 객체 반환 메소드
	public CorruptionIndexCalculator(WeatherData weatherData) {
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
	
	//CI = (RH-65) / 14 * 1.054^T [T = celcuis]
	public static double calculate(double T, double RH) {
		double value =  (RH-65) * 0.0714 * Math.pow(1.054, T);
		return Math.round(value*100)/100.00;
	}
	
	//weatherData를 활용하여 계싼
	@Override //weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}
	
	//도표 생성 메소드
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void printTable() {
		System.out.print("RH/C\t5\t10\t15\t20\t25\t30\t35\t40\n");
		for (int rh = 66; rh < 100; rh += 2) {
			System.out.print(rh + "\t");
			for (int celcius = 5; celcius < 45; celcius += 5) {
				double value = calculate(celcius, rh);
				System.out.print(value + "\t");
			}
			System.out.print("\n");
		}
	}

	//userinput값을 활용한 calculation
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public void getUserInput() {
		System.out.println("Corruption Calculation");	
		System.out.print("Please enter temperature (C): ");
		weatherData.temperature = controller.UserInput.getDouble();
		System.out.print("Please enter relative humidity (RH): ");
		weatherData.relativeHumidity = controller.UserInput.getDouble();
	}
	
	//input값 혹은 weatherData를 받아서 풀력하기 위한 toString
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public String toString() {
		return "SiCalculator [temperature=" + weatherData.getTemperature() + ", relativeHumidity=" + weatherData.getRelativeHumidity() + ", value="
				+ value + ", index=" + CorruptionIndex.getIndex(value) + "]";
	}
	
	//equals와 hashcode 오버라이딩하여 같은 데이터임을 명시함 - HastSet을 위함
	@Override//weatherCalculator 클래스 안에서 계산되기 위하여 overriding
	public boolean equals(Object other) { // Object.equals overriding
	if (this == other) return true;
	if (other instanceof CorruptionIndexCalculator) {
		CorruptionIndexCalculator that = (CorruptionIndexCalculator) other;
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
