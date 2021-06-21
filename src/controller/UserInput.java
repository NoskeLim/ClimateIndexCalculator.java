package controller; //����� �Է°� �ڹ� Ŭ������ ��ġ ǥ��

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
				value = Double.parseDouble(input.nextLine()); //����ڷκ��� ���� ���� double�� ��ȯ�Ͽ� �����Ѵ�
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
				value = Integer.parseInt(input.nextLine()); //��������� ���� ���� ������ ��ȯ�Ͽ� value�� �����Ѵ�			
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
		if(str.contentEquals("q")) //���� str������ ���ڿ��� "q"���� ���ٸ� true ����
			return true; 
		else
			return false; //str������ ���ڿ��� "q"�� ���� ���� �ʴٸ� false ���� 
	}
	
	
}