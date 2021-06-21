package controller; //사용자 입력값 자바 클래스의 위치 표시

import java.util.Scanner;

// UserInput
public class UserInput {
	private static Scanner input = new Scanner(System.in); 
	
	public static String getString() { 
		return input.nextLine(); 
	}
	
	public static double getDouble() { 
		double value = 0.0; 
		while (true) {
			try {
				value = Double.parseDouble(input.nextLine()); //사용자로부터 받은 값을 double로 변환하여 대입한다
				return value; 
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter double\n");
				continue;
			}
		}
	}

	public static int getInteger() { 
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(input.nextLine()); //사용자한테 받은 값을 정수로 변환하여 value에 대입한다			
				return value; 
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter integer\n");
				continue;
			}
		}
	}

	public static int getIntegerBetween(int min, int max) { 
		int value = 0;
		do {
			try {
				value = Integer.parseInt(input.nextLine());
			}
			catch (Exception e) {
				System.out.printf("Error! Please re-enter value [%d-%d]:\n", min, max);
				continue;
			}
		} while (value < min || value > max);
		return value;
	}

	public static boolean getExitKey() { 
		System.out.print("Press q-key to exit or enter-key to continue: "); 
		String str = input.nextLine(); 
		if(str.contentEquals("q")) //만약 str변수의 문자열과 "q"값이 같다면 true 리턴
			return true; 
		else
			return false; //str변수의 문자열이 "q"와 값이 같지 않다면 false 리턴 
	}
	
	
}