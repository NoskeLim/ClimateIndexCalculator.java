//dao ��Ű���� ���ԵǾ� ����
package dao;

import java.util.ArrayList;//WeatherCalculatorListManager�� ������
import java.util.List;//List<WetherCalculator>
import java.util.function.Predicate;//predicate method
import java.util.Random; //random method

//dto package�� WeatherCalculator Ŭ������ �ҷ���
import dto.WeatherCalculator;

//WeatherCalculatorListManager Ŭ����
public class WeatherCalculatorListManager {
	
	//List<WeatherCalculator> calculators�� WeatherCalculatorListManager������ ���ٰ��� 
	private List<WeatherCalculator> calculators = null;
	
	//WeatherCalculatorListManager�� ������
	public WeatherCalculatorListManager() {
		this.calculators = new ArrayList<> ();
	}
	
	// ����Ʈ�� ���� �߰�
	public void add(WeatherCalculator c) {
		calculators.add(0, c);
	}
	
	// ����Ʈ���� �ش� calculator ����
	public void remove(WeatherCalculator c) {
		calculators.remove(0);
	}
	
	// ����Ʈ���� index�� calculator�� ��ü
	public void set(int index, WeatherCalculator c) {
		calculators.set(index, c);
	}
	
	// ����Ʈ���� index�� calculator ��ȯ
	public WeatherCalculator get(int index) {
		return calculators.get(index);
	}
	
	// ����Ʈ���� �ش� calculator�� index ��ȯ
	public int indexOf(WeatherCalculator c) {
		return 0;
	}
	
	// ����Ʈ�� ũ�� ��ȯ
	public int size() {
		return calculators.size();
	}
	
	// ��ü ����Ʈ ����Ʈ
	public void print() {
		System.out.println(calculators);
	}
	
	// ����Ʈ���� �ش� predicate ���ǿ� �´� ��� calculator ����Ʈ ��ȯ
	public List<WeatherCalculator> select(Predicate<? super WeatherCalculator> predicate){
		//List<WeatherCalculator>������ ���͸��� ��ħ
		List<WeatherCalculator> result = new ArrayList<> ();
	      for (WeatherCalculator cal: calculators) {
	         if (predicate.test(cal)) {
	            result.add(cal);
	         }
	      }
	      return result;
	}
	
	// ���ڷ� �Ѱ��� ����Ʈ���� �����ϰ� �ϳ� �����ؼ� ��ȯ
	public static WeatherCalculator getRandom(List<WeatherCalculator> list) {
		Random rand = new Random(); //java.util�� Ȱ���Ͽ��� Random�� ����
	    return list.get(rand.nextInt(list.size()));//list���� rand�� nextInt�� Ȱ���Ͽ��� ����Ʈ ���� �� �ϳ��� �����´�.
	 }
	
}