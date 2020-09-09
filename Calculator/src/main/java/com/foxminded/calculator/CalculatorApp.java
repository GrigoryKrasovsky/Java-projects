package com.foxminded.calculator;

import java.util.List;

public class CalculatorApp {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Result result = calculator.process(343, 3);
		
		System.out.println(result.getDividend());
		List<Step> steps = calculator.process(343, 3).getSteps();
		Step firstLocalDividend = steps.get(0);

		for (int i = 0; i<steps.size(); i++) {

			System.out.println(steps.get(i).getLocalDividend());
			System.out.println(steps.get(i).getIntermediate());
		}
	}
}
