package com.example.servlet.app;

public class Calc {
	public static int num(String number) {
		int calc = 0;
		char value = 0;
		String[] numbers = null;
		numbers = number.split("\\+|\\-|\\*|\\/");
		for (int i = 0; i < number.length(); i++) {
			if(number.charAt(i) == '+') {
				value = '+';
			}else if(number.charAt(i) == '-') {
				value = '-';
			}else if(number.charAt(i) == '*') {
				value = '*';
			}else if(number.charAt(i) == '/') {
				value = '/';
			}
			
		}
		int num1 = Integer.parseInt(numbers[0]);
		int num2 = Integer.parseInt(numbers[1]);
		try {
			switch(value) {
			case '+':
				calc = num1 + num2;
				break;
			case '-':
				calc = num1 - num2;
				break;
			case '*':
				calc = num1 * num2;
				break;
			case '/':
				calc = num1 / num2;
				break;
			
			}
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			
		}
		return calc;
	}
}
