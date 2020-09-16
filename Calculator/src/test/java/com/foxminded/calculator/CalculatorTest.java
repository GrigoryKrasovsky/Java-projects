package com.foxminded.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.foxminded.calculator.formatters.Formatter;
import com.foxminded.calculator.formatters.FormatterFactory;

class CalculatorTest {
	Calculator calculator = new Calculator();
	
	@Test
	void testExpectedException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    Calculator.process(1,0);
	  });
	}
	@Test
	void shouldVerifyCorrectNumbersOneNegative(){
		String expected ="-25 4 -6 -1 -25 -24 ";
		assertEquals(expected, Calculator.process(-25, 4).getAllValues());
	}
	
	@Test
	void shouldVerifyCorrectNumbersAnotherNegative(){
		String expected ="25 -4 -6 1 25 24 ";
		assertEquals(expected, Calculator.process(25, -4).getAllValues());
	}
	@Test
	void shouldVerifyCorrectNumbersBothNegative(){
		String expected ="-25 -4 6 -1 -25 -24 ";
		assertEquals(expected, Calculator.process(-25, -4).getAllValues());
	}
	@Test
	void shouldVerifyLargeNumbersDivision(){
		String expected ="389471 523 744 359 3894 3661 2337 2092 2451 2092 ";
		assertEquals(expected, Calculator.process(389471, 523).getAllValues());
	}
	@Test
	void shouldVerifySmallerDividendDivision(){
		String expected ="1 523 0 1 0 0 ";
		assertEquals(expected, Calculator.process(1, 523).getAllValues());
	}
}