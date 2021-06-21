package dto;

//interface IWeatherCalculator를 구현
public interface IWeatherCalculator {
	
	abstract void printTable();//추상메소드
	abstract void getUserInput();//추상메소드
	abstract void calculate();//추상메소드
}
