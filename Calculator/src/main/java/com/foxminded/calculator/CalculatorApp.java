package com.foxminded.calculator;

import java.util.Scanner;

public class CalculatorApp {
	public static void main(String [] args) {
		try (Scanner scanner = new Scanner (System.in)){
			Calculator calculator = new Calculator();
			String divident = scanner.nextLine();
			String divisor = scanner.nextLine();
			System.out.println(calculator.process(divident,divisor));
		}
	}
}
