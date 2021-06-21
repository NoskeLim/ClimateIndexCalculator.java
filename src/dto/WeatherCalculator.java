package dto;

//WeatherCalculator �߻�Ŭ������ IWeatherCalculator �������̽��� ���
//WeatherCalculator Ŭ����
public abstract class WeatherCalculator {
	//WeatherCalculator �������� Ȱ���� �� �ֵ��� ����
	protected WeatherData weatherData;// ���������� ���
	protected double value;
	protected WeatherCalculator(WeatherData weatherData) {
		this.weatherData = weatherData;
		calculate(); // �������ε����� �ڽ�Ŭ������ calculate() ȣ��
	}
	
	// �����ڵ忡���� �������ε����� �ڽ�Ŭ������ �������̵��� �޼ҵ� ȣ��
	public final void process() {
		printTable();
		getUserInput();
		calculate();
		System.out.println(this);
	}
	
	//ȭ��(F)���� ����(C)�� ��ٴ� ����
	public static double fromFahrenheightToCelsius(double F) {
		double C = (F-32) * 0.55 ;
		return C;
	}
	
	//����(C)���� ȭ��(F)�� ��ٴ� ����
	public static double fromCelsiusToFahrenheight(double C) {
		double F = (C*1.8) + 32;
		return F;
	}

	protected abstract void printTable();
	protected abstract void getUserInput();
	protected abstract void calculate();
	
}
