package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	@Test
	void shouldVerifyCorrectMathUtilsOutput() {
		long input = 73323;
		String expected = "00:01:13.323";
		
		assertEquals(expected, Utilities.convertLongToTime(input).toString());
	}

}
