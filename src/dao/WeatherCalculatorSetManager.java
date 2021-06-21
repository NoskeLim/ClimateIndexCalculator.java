//dao package에 속해 있음
package dao;

import java.util.HashSet; //Set<WeatherCalculator>의 HastSet
import java.util.Random; //getRandom(Set<WeatherCalculator> set)
import java.util.Set;//getRandom(Set<WeatherCalculator> set)
import java.util.function.Predicate;//Predicate<? super WeatherCalculator> predicate

import dto.WeatherCalculator;//dtp package의 WeatherCalculator를 불러옴

//WeatherCalculatorSetManager Class
public class WeatherCalculatorSetManager {
	
	//Set<WeatherCalculator> calculators는 WeatherCalculatorSetManager에서만 접근 가능
	private Set<WeatherCalculator> calculators = null;
	
	//WeatherCalculatorSetManager의 생성자
	public WeatherCalculatorSetManager() {
		this.calculators = new HashSet<> ();
	}
	
	// 세트에 새로 추가
	public void add(WeatherCalculator c) {
		calculators.add(c);
	}
	
	// 세트에서 해당 c 삭제
	public void remove(WeatherCalculator c) {
		calculators.remove(0);
	}
	
	// 세트의 크기 반환
	public int size() {
		return calculators.size();
		
	}
	
	 // 세트 프린트
	public void print() {
		System.out.println(calculators);
	}
	
	// 리스트에서 해당 predicate 조건에 맞는 모든 calculator 세트 반환
	public Set<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate){
		//Set<WeatherCalculator>내에서 필터링을 거침
		Set<WeatherCalculator> result = new HashSet<> ();
	      for (WeatherCalculator cal: calculators) {
	         if (predicate.test(cal)) {
	            result.add(cal);
	         }
	      }
	      return result;
	}
	
	// 인자로 보내준 셋에서 랜덤하게 하나 선택해서 반환
	public static WeatherCalculator getRandom(Set<WeatherCalculator> set) {
		Random rand = new Random();//java.util을 활용하여서 Random을 생성
		for (int i=0; i < set.size(); i++) { //for 반복문을 활용하여서 리스트 내를 거침
		} 
		return (WeatherCalculator) //WeatherCalculator의 값를 리턴함
		set.toArray()[rand.nextInt(set.size())];//리스트중 랜덤의 인자를 셋팅함
	}
}