package com.foxminded.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calculator = new Calculator();

	@Test
	void testExpectedException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    calculator.process(null);
		});
	}
}
