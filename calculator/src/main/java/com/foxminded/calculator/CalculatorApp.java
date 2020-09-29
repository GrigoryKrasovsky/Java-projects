package com.foxminded.calculator;

import com.foxminded.calculator.formatters.Formatter;
import com.foxminded.calculator.formatters.FormatterFactory;
import com.foxminded.calculator.model.Result;


public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Result result = calculator.process(-2225, 15);
        Formatter format = FormatterFactory.get("Classic");
        System.out.println(format.format(result));
    }

}

