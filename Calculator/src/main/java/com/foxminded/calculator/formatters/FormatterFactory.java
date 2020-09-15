package com.foxminded.calculator.formatters;

public class FormatterFactory {
	public static Formatter get(String title) {
		if (title.equalsIgnoreCase("Dutch")) {
			return new DutchFormatter();
		} else if (title.equalsIgnoreCase("Classic")) {
			return new ClassicFormatter();
		} else {
			throw new IllegalArgumentException(title + " is unknown");
		}
	}
}
