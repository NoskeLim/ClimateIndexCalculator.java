package dto;

import java.util.Objects;

// https://www.calculator.net/wind-chill-calculator.html
// Lab3 WindChillTemperatureCalculator
public class WindChillTemperatureCalculator extends WeatherCalculator{
	double temperature; // fahrenheit
	double windVelocity; // mph
	double value; // WindChillTemperature
	
	//WeatherCalculaotr�� Mode�� ���� ��ü ��ȯ �޼ҵ�
	public WindChillTemperatureCalculator() {
		this(new WeatherData(null,0,0,0));
	}
	
	//WeatherCalculaotr�� data�Է°��� Mode�� ���� ��ü ��ȯ �޼ҵ�
	public WindChillTemperatureCalculator(WeatherData weatherData) {
		super(weatherData);
	}
	
	//getters, setters
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindVelocity() {
		return windVelocity;
	}

	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}

	public double getValue() {
		return value;
	}
	
	// WCT = 35.74 + 0.6215*F - 35.75*V^0.16 + 0.4275*F*V^0.16
	public static double calculate(double F, double V) {
		double value = 35.74 + 0.6215*F - 35.75*Math.pow(V, 0.16) + 0.4275*F*Math.pow(V, 0.16);
		return Math.round(value);
	}
	
	//weatherData�� Ȱ���Ͽ� ���
	@Override //weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(),weatherData.getWindVelocity());
	}
	
	//��ǥ ���� �޼ҵ�
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void printTable() {
		System.out.print("W/F\t40\t35\t30\t25\t20\t15\t10\t5\t0\t-5\t-10\t-15\t-20\t-25\t-30\t-35\t-40\t-45\n");
		for (int wind = 5; wind < 65; wind += 5) {
			System.out.print(wind + "\t");
			for (int fahrenheit = 40; fahrenheit > - 50; fahrenheit -= 5) {
				double value = calculate(fahrenheit, wind);
				System.out.print(value + "\t");
			}
			System.out.print("\n");
		}
	}
	
	//userinput���� Ȱ���� calculation
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void getUserInput() {
		System.out.println("WindChillTemperature");	
		System.out.print("Please enter temperature (F): ");
		weatherData.temperature = controller.UserInput.getDouble();
		System.out.print("Please enter wind velocity (mph): ");
		weatherData.windVelocity = controller.UserInput.getDouble();
	}
	
	//input�� Ȥ�� weatherData�� �޾Ƽ� Ǯ���ϱ� ���� toString
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public String toString() {
		return "WindChillTemperatureCalculator [temperature=" + + weatherData.getTemperature() + ", windVelocity=" + 
				weatherData.getWindVelocity() + ", value=" + value + ", index=" + WindChillTemperatureIndex.getIndex(value) + "]";
	}
	
	//equals�� hashcode �������̵��Ͽ� ���� ���������� ����� - HastSet�� ����
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public boolean equals(Object other) { // Object.equals overriding
		if (this == other) return true;
		if (other instanceof WindChillTemperatureCalculator) {
			WindChillTemperatureCalculator that = (WindChillTemperatureCalculator) other;
			return this.weatherData.getTemperature() == that.weatherData.getTemperature() &&
			this.weatherData.getWindVelocity() == that.weatherData.getWindVelocity() &&
			this.getValue() == that.getValue();
		}
		return false;
	}
	
	//Hastset
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public int hashCode() { // Object.hashCode overriding
		return Objects.hash(weatherData.getTemperature(), weatherData.getWindVelocity(), getValue());
	}
}
