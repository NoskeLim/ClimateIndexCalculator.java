package controller;

import java.util.List;
import java.util.Set;

import dao.WeatherCalculatorListManager;
import dao.WeatherCalculatorSetManager;
import dto.CorruptionIndexCalculator;
import dto.DewPointCalculator;
import dto.Mode;
import dto.WeatherCalculator;
import dto.WeatherCalculatorFactory;
import dto.WeatherData;

// Lab 5 
public class Lab5 {
	// fahrenheitTemperature, relativeHumidity, windVelocity
	static WeatherData[] weatherData = { 
		new WeatherData("2019-01-01", 30.38, 46, 4.0265),
		new WeatherData("2019-02-01", 33.8, 47, 4.0265),
		new WeatherData("2019-03-01", 44.78, 51, 4.6976),
		new WeatherData("2019-04-01", 53.78, 51, 4.2502),
		new WeatherData("2019-05-01", 66.92, 47, 4.6976),
		new WeatherData("2019-06-01", 72.5, 61, 3.8028),
		new WeatherData("2019-07-01", 78.62, 69, 4.0265),
		new WeatherData("2019-08-01", 80.96, 69, 3.5791),
		new WeatherData("2019-09-01", 72.68, 65, 4.9213),
		new WeatherData("2019-10-01", 61.52, 62, 4.6976),
		new WeatherData("2019-11-01", 45.68, 56, 4.9213),
		new WeatherData("2019-12-01", 34.52, 58, 4.6976),		
		new WeatherData("2020-01-01", 34.88, 56, 4.6976),
		new WeatherData("2020-02-01", 36.5, 58, 5.1450),
		new WeatherData("2020-03-01", 45.86, 46, 5.5924),
		new WeatherData("2020-04-01", 51.98, 50, 6.7108),
		new WeatherData("2020-05-01", 64.4, 67, 5.3687),
		new WeatherData("2020-06-01", 75.02, 68, 5.1450),
		new WeatherData("2020-07-01", 75.38, 77, 5.3687),
		new WeatherData("2020-08-01", 79.7, 85, 5.1450),
		new WeatherData("2020-09-01", 70.52, 71, 5.5924),
		new WeatherData("2020-10-01", 57.74, 61, 4.6976),
		new WeatherData("2020-11-01", 46.4, 64, 4.9213),
		new WeatherData("2020-12-01", 31.46, 58, 4.9213)
	};

	public static void main(String[] args) {
		
		// calculate DewPoint, WindChillTemperature, HeatIndex using array of weather data (Temperature, relativeHumidity, windVelocity)
		System.out.println("weather data ..");
		WeatherCalculatorListManager listManager = new WeatherCalculatorListManager();
		for (WeatherData data : weatherData) {
			for (Mode mode : Mode.values()) {
				WeatherCalculator calculator = WeatherCalculatorFactory.getInstance(mode, data);
				listManager.add(calculator);
			}
		}
		
		// print
		System.out.println("listManager print..");		
		listManager.print();
		
		// print
		List<WeatherCalculator> resultList = listManager.select(e -> e instanceof CorruptionIndexCalculator);
		System.out.println("resultList print..");
		resultList.forEach(System.out::println);
		WeatherCalculator randomCalculator = WeatherCalculatorListManager.getRandom(resultList);
		System.out.println("randomCalculator (from resultList)=" + randomCalculator);		
		
		// calculate using user input
		System.out.println("user input..");
		WeatherCalculatorSetManager setManager = new WeatherCalculatorSetManager();
		do {
			System.out.print("Please enter mode [1: DP, 2: WCT, 3: HI, 4: DI, 5: SI]: ");	
			int mode = UserInput.getIntegerBetween(1,5);
			WeatherCalculator calculator = WeatherCalculatorFactory.getInstance(Mode.valueOf(mode));
			calculator.process();
			setManager.add(calculator);
		} while(!UserInput.getExitKey());
		
		// print
		System.out.println("setManager print..");		
		setManager.print();
		Set<WeatherCalculator> resultSet = setManager.select(e -> e instanceof CorruptionIndexCalculator);
		System.out.println("resultSet print..");		
		resultSet.forEach(System.out::println);
		randomCalculator = WeatherCalculatorSetManager.getRandom(resultSet);
		System.out.println("randomCalculator (from resultSet)=" + randomCalculator);		

		System.out.println("done..");
	}
}
