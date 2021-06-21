//dao 패키지에 포함되어 있음
package dao;

import java.util.ArrayList;//WeatherCalculatorListManager의 샹성자
import java.util.List;//List<WetherCalculator>
import java.util.function.Predicate;//predicate method
import java.util.Random; //random method

//dto package의 WeatherCalculator 클래스를 불러옴
import dto.WeatherCalculator;

//WeatherCalculatorListManager 클래스
public class WeatherCalculatorListManager {
	
	//List<WeatherCalculator> calculators는 WeatherCalculatorListManager에서만 접근가능 
	private List<WeatherCalculator> calculators = null;
	
	//WeatherCalculatorListManager의 생성자
	public WeatherCalculatorListManager() {
		this.calculators = new ArrayList<> ();
	}
	
	// 리스트에 새로 추가
	public void add(WeatherCalculator c) {
		calculators.add(0, c);
	}
	
	// 리스트에서 해당 calculator 삭제
	public void remove(WeatherCalculator c) {
		calculators.remove(0);
	}
	
	// 리스트에서 index에 calculator로 교체
	public void set(int index, WeatherCalculator c) {
		calculators.set(index, c);
	}
	
	// 리스트에서 index의 calculator 반환
	public WeatherCalculator get(int index) {
		return calculators.get(index);
	}
	
	// 리스트에서 해당 calculator의 index 반환
	public int indexOf(WeatherCalculator c) {
		return 0;
	}
	
	// 리스트의 크기 반환
	public int size() {
		return calculators.size();
	}
	
	// 전체 리스트 프린트
	public void print() {
		System.out.println(calculators);
	}
	
	// 리스트에서 해당 predicate 조건에 맞는 모든 calculator 리스트 반환
	public List<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate){
		//List<WeatherCalculator>내에서 필터링을 거침
		List<WeatherCalculator> result = new ArrayList<> ();
	      for (WeatherCalculator cal: calculators) {
	         if (predicate.test(cal)) {
	            result.add(cal);
	         }
	      }
	      return result;
	}
	
	// 인자로 넘겨준 리스트에서 랜덤하게 하나 선택해서 반환
	public static WeatherCalculator getRandom(List<WeatherCalculator> list) {
		Random rand = new Random(); //java.util을 활용하여서 Random을 생성
	    return list.get(rand.nextInt(list.size()));//list에서 rand의 nextInt를 활용하여서 리스트 구성 중 하나를 가져온다.
	 }
	
}