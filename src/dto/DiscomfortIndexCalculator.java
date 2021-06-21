package dto;

import java.util.Objects;

// Lab4 DiscomfortIndexCalculator
public class DiscomfortIndexCalculator extends WeatherCalculator{
	double temperature; //Calsius
	double relativeHumidity; // %
	double value; //DiscomfortIndex
	
	//WeatherCalculaotr�� Mode�� ���� ��ü ��ȯ �޼ҵ�
	public DiscomfortIndexCalculator() {
		this(new WeatherData(null,0,0,0));
	}
	
	//WeatherCalculaotr�� data�Է°��� Mode�� ���� ��ü ��ȯ �޼ҵ�
	public DiscomfortIndexCalculator(WeatherData weatherData) {
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
	
	// DI = T - 0.55*(1 - 0.01*RH)*(T - 14.5) [T: celsius] , T = ((F - 32) * 0.555)
	public static double calculate(double F, double RH) {
		double value = ((F - 32) * 0.555) - 0.55*(1 - 0.01*RH)*(((F - 32) * 0.555) - 14.5);
		return Math.round(value*10)/10;
	}
	
	//weatherData�� Ȱ���Ͽ� ���
	@Override //weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void calculate() {
		this.value = calculate(weatherData.getTemperature(), weatherData.getRelativeHumidity());
	}
	
	//��ǥ ���� �޼ҵ�
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void printTable() {
		int[] fahrenheit = {68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110};
		int[] humidities  = {25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
		System.out.print("RH/F\t68\t71\t74\t77\t80\t83\t86\t89\t92\t95\t98\t101\t104\t107\t110\n");
		for (int i = 0; i < humidities.length; i++) {
			System.out.print(humidities[i] + "\t");
			for (int j = 0; j < fahrenheit.length; j++) {
				double value = calculate(fahrenheit[j], humidities[i]);
				System.out.print(value + "\t");
			}
			System.out.print("\n");
		}
	}
	
	//userinput���� Ȱ���� calculation
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public void getUserInput() {
		System.out.println("DiscomfortIndex");
		System.out.print("Please enter temperature (F): ");
		weatherData.temperature = controller.UserInput.getDouble();
		System.out.print("Please enter relative humidity (%): ");
		weatherData.relativeHumidity = controller.UserInput.getDouble();
	}

	//input�� Ȥ�� weatherData�� �޾Ƽ� Ǯ���ϱ� ���� toString
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public String toString() {
		return "DiscomfortIndexCalculator [temperature=" + weatherData.getTemperature() + ", relativeHumidity=" + weatherData.getRelativeHumidity()
				+ ", value=" + value + ", index=" + DiscomfortIndex.getIndex(value) + "]";
	}
	
	//equals�� hashcode �������̵��Ͽ� ���� ���������� ����� - HastSet�� ����
	@Override//weatherCalculator Ŭ���� �ȿ��� ���Ǳ� ���Ͽ� overriding
	public boolean equals(Object other) { // Object.equals overriding
	if (this == other) return true;
	if (other instanceof DiscomfortIndexCalculator) {
		DiscomfortIndexCalculator that = (DiscomfortIndexCalculator) other;
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
