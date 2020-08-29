package com.foxminded.calculator;

public class Calculator {
	public String [] process(String number) {
		for (int index = 0; index < number.length(); index++) {
			if (!Character.isDigit(number.charAt(index))) {
				throw new IllegalArgumentException("Only numbers can be processed");
			}
		}
		String [] result = new String [0];
		
		return result;
	}
	public int divide (String divident, int divisor) {
		int result =0;
		return result;
	}
}