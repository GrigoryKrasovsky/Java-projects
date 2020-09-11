package com.foxminded.calculator;

public class CalculatorApp {
	public static void main(String[] args) {
		
		Result result = Calculator.process(99999,1);
		Formatter format = getFormatterFactory("Classic").createFormatter();
		System.out.println(format.format(result));
	
		
	}
	static FormatterFactory getFormatterFactory(String title) {
		if (title.equalsIgnoreCase("Dutch")){
			return new DutchFormatterFactory();
		}else if (title.equalsIgnoreCase("Classic")){
			return new ClassicFormatterFactory();
		}else {
			throw new IllegalArgumentException(title + " is unknown");
		}
	}
}
