package dto;

//WeatherCalculator 추상클래스는 IWeatherCalculator 인터페이스를 상속
//WeatherCalculator 클래스
public abstract class WeatherCalculator {
	//WeatherCalculator 내에서만 활용할 수 있도록 설정
	protected WeatherData weatherData;// 날씨데이터 사용
	protected double value;
	protected WeatherCalculator(WeatherData weatherData) {
		this.weatherData = weatherData;
		calculate(); // 동적바인딩으로 자식클래스의 calculate() 호출
	}
	
	// 내부코드에서는 동적바인딩으로 자식클래스의 오버라이딩된 메소드 호출
	public final void process() {
		printTable();
		getUserInput();
		calculate();
		System.out.println(this);
	}
	
	//화씨(F)에서 섭씨(C)로 비꾸는 공식
	public static double fromFahrenheightToCelsius(double F) {
		double C = (F-32) * 0.55 ;
		return C;
	}
	
	//섭씨(C)에서 화씨(F)로 비꾸는 공식
	public static double fromCelsiusToFahrenheight(double C) {
		double F = (C*1.8) + 32;
		return F;
	}

	protected abstract void printTable();
	protected abstract void getUserInput();
	protected abstract void calculate();
	
}
