package com.foxminded.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator calculator = new Calculator();

	@Test
	void testExpectedException() {
		assertThrows(IllegalArgumentException.class, () -> {
		    calculator.process("1231as", "another word with numbers 123");
		});
	}
	@Test
	void shouldVerifyDevidedSmallerDivision() {
		String expected ="_31|3\n 3 |--\n - |10\n  1";
		assertEquals(expected, calculator.divide("31","3"));
	}
	void shouldVerifyDevidedNormalDivision() {
		String expected ="_31|3\n 3 |--\n - |10\n 1";
		assertEquals(expected, calculator.divide("31","3"));
	}
}
