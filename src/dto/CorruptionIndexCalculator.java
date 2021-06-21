//dto package ������ ����
package dto;

import java.util.Objects;

//WeatherCalculator �߻�Ŭ������ ��ӹ޾� weatherData�� ����Ͽ� �߻�޼ҵ� ���� ����
//Lab5 Your Code(SI) - CorruptionIndexCalculator
public class CorruptionIndexCalculator extends WeatherCalculator{
	double temperature;
	double relativeHumidity;
	double value;
	
	//WeatherCalculaotr�� Mode�� ���� ��ü ��ȯ �޼ҵ�
	public CorruptionIndexCalculator() {
		this(new WeatherData(null,0,0,0));
	}
	
	//WeatherCalculaotr�� data�Է°��� Mode�� ���� ��ü ��ȯ �޼ҵ�
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
	
	//weatherData�� Ȱ���Ͽ� ���
	@Override //weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}
	
	//��ǥ ���� �޼ҵ�
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
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

	//userinput���� Ȱ���� calculation
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void getUserInput() {
		System.out.println("Corruption Calculation");	
		System.out.print("Please enter temperature (C): ");
		weatherData.temperature = controller.UserInput.getDouble();
		System.out.print("Please enter relative humidity (RH): ");
		weatherData.relativeHumidity = controller.UserInput.getDouble();
	}
	
	//input�� Ȥ�� weatherData�� �޾Ƽ� Ǯ���ϱ� ���� toString
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public String toString() {
		return "SiCalculator [temperature=" + weatherData.getTemperature() + ", relativeHumidity=" + weatherData.getRelativeHumidity() + ", value="
				+ value + ", index=" + CorruptionIndex.getIndex(value) + "]";
	}
	
	//equals�� hashcode �������̵��Ͽ� ���� ���������� ����� - HastSet�� ����
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
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
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public int hashCode() { // Object.hashCode overriding
		return Objects.hash(weatherData.getTemperature(), weatherData.getRelativeHumidity(), getValue());
	}
}
