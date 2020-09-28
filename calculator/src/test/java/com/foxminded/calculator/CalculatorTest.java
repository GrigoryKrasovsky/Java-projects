package com.foxminded.calculator;

import com.foxminded.calculator.model.Result;
import com.foxminded.calculator.model.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
	Calculator calculator = new Calculator();
	
	@Test
	void shouldThrowExceptionWhenDivisionByZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.process(1, 0));
	}
	@Test
	void shouldVerifyCorrectNumbersOneNegative() {
		// Correct test
		Result expected = new Result(-25, 4, -6, -1,
				Collections.singletonList(new Step(-25, -24)));
		assertEquals(expected, calculator.process(-25, 4));
	}

	@Test
	void shouldVerifyCorrectNumbersAnotherNegative() {
		// Correct test
		Result expected = new Result(25, -4, -6, 1,
				Collections.singletonList(new Step(25, 24)));
		assertEquals(expected, calculator.process(25, -4));
	}

	@Test
	void shouldVerifyCorrectNumbersBothNegative() {
		String expected = "-25 -4 6 -1 -25 -24 ";
		assertEquals(expected, calculator.process(-25, -4));
	}
	@Test
	void shouldVerifyLargeNumbersDivision() {
		Result expected = new Result(389471, 523, 744, 359,
				Arrays.asList(
						new Step(3894, 3661),
						new Step(2337, 2092),
						new Step(2451, 2092)));
		assertEquals(expected, calculator.process(389471, 523));
	}
	@Test
	void shouldVerifySmallerDividendDivision(){
		String expected ="1 523 0 1 0 0 ";
		assertEquals(expected, calculator.process(1, 523));
	}
}