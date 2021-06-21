//dao package�� ���� ����
package dao;

import java.util.HashSet; //Set<WeatherCalculator>�� HastSet
import java.util.Random; //getRandom(Set<WeatherCalculator> set)
import java.util.Set;//getRandom(Set<WeatherCalculator> set)
import java.util.function.Predicate;//Predicate<? super WeatherCalculator> predicate

import dto.WeatherCalculator;//dtp package�� WeatherCalculator�� �ҷ���

//WeatherCalculatorSetManager Class
public class WeatherCalculatorSetManager {
	
	//Set<WeatherCalculator> calculators�� WeatherCalculatorSetManager������ ���� ����
	private Set<WeatherCalculator> calculators = null;
	
	//WeatherCalculatorSetManager�� ������
	public WeatherCalculatorSetManager() {
		this.calculators = new HashSet<> ();
	}
	
	// ��Ʈ�� ���� �߰�
	public void add(WeatherCalculator c) {
		calculators.add(c);
	}
	
	// ��Ʈ���� �ش� c ����
	public void remove(WeatherCalculator c) {
		calculators.remove(0);
	}
	
	// ��Ʈ�� ũ�� ��ȯ
	public int size() {
		return calculators.size();
		
	}
	
	 // ��Ʈ ����Ʈ
	public void print() {
		System.out.println(calculators);
	}
	
	// ����Ʈ���� �ش� predicate ���ǿ� �´� ��� calculator ��Ʈ ��ȯ
	public Set<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate){
		//Set<WeatherCalculator>������ ���͸��� ��ħ
		Set<WeatherCalculator> result = new HashSet<> ();
	      for (WeatherCalculator cal: calculators) {
	         if (predicate.test(cal)) {
	            result.add(cal);
	         }
	      }
	      return result;
	}
	
	// ���ڷ� ������ �¿��� �����ϰ� �ϳ� �����ؼ� ��ȯ
	public static WeatherCalculator getRandom(Set<WeatherCalculator> set) {
		Random rand = new Random();//java.util�� Ȱ���Ͽ��� Random�� ����
		for (int i=0; i < set.size(); i++) { //for �ݺ����� Ȱ���Ͽ��� ����Ʈ ���� ��ħ
		} 
		return (WeatherCalculator) //WeatherCalculator�� ���� ������
		set.toArray()[rand.nextInt(set.size())];//����Ʈ�� ������ ���ڸ� ������
	}
}