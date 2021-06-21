package dto;

public class WeatherData extends WeatherCalculatorFactory{
	
	String data;
	double temperature;
	double relativeHumidity;
	double windVelocity;
	
	public WeatherData() {
		this(null, 0.0, 0.0, 0.0);
	}
	
	//»ý¼ºÀÚ
	public WeatherData(String data, double temperature, double relativeHumidity, double windVelocity) {
		this.data = data;
		this.relativeHumidity = relativeHumidity;
		this.temperature = temperature;
		this.windVelocity = windVelocity;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
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
	public double getWindVelocity() {
		return windVelocity;
	}
	public void setWindVelocity(double windVelocity) {
		this.windVelocity = windVelocity;
	}
	
	@Override
	public String toString() {
		return "WeatherData [data=" + data + ", temperature=" + temperature + ", relativeHumidity=" + relativeHumidity
				+ ", windVelocity=" + windVelocity + "]";
	}
	
}
