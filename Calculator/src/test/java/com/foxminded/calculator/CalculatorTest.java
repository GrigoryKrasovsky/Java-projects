package com.foxminded.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator calculator = new Calculator();

	@Test
	void testExpectedException() {
		assertThrows(IllegalArgumentException.class, () -> {
		    calculator.process("1231as", "another one with numbers 123");
		});
	}
	@Test
	void shouldVerifyDevidedSmallerDivision() {
		String expected ="_31|3\n 3 |--\n - |10\n  1";
		assertEquals(expected, calculator.process("31","3"));
	}
	@Test
	void shouldVerifyDevidedNormalDivision() {
		String expected ="_3222|313\n 313 |---\n --- |10\n   92";
		assertEquals(expected, calculator.process("3222","313"));
	}
	@Test
	void shouldVerifyDevidedLargeDivision() {
		String expected ="_68374621|34213\n 34213   |-----\n -----   |1998\n_341616\n 307917\n ------\n _336992\n"+
	"  307917\n  ------\n  _290751\n   273704\n   ------\n    17047";
		assertEquals(expected, calculator.process("68374621","34213"));
	}
	@Test
	void shouldVerifyDividentSmallerThanDivisor() {
		String expected = "1|2\n |-\n |0\n";
		assertEquals(expected, calculator.process("1","2"));
	}
}
