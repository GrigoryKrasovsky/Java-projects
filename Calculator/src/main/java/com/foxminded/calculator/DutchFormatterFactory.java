package com.foxminded.calculator;

public class DutchFormatterFactory implements FormatterFactory{

	@Override
	public Formatter createFormatter() {
		return new DutchFormatter();
	}
}
