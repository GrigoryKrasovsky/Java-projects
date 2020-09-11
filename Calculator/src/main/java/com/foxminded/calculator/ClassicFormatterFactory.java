package com.foxminded.calculator;

public class ClassicFormatterFactory implements FormatterFactory{

	@Override
	public Formatter createFormatter() {
		return new ClassicFormatter();
	}
}
