package com.foxminded.calculator;

import com.foxminded.calculator.formatters.Formatter;
import com.foxminded.calculator.formatters.FormatterFactory;
import com.foxminded.calculator.model.Result;


public class CalculatorApp {
	public static void main(String[] args) {
		
		Result result = Calculator.process(-225, 15);
		Formatter format = FormatterFactory.get("Classic");
		System.out.println(format.format(result));
		//System.out.println(Calculator.findDigit(200,0));
		//System.out.println(result.getAllValues());
		//System.out.println(Calculator.findLength(38471));
		//System.out.println(result.getAllValues());
		
	}

}

