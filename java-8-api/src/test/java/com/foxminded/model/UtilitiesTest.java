package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	@Test
	void shouldVerifyCorrectLongToTimeOutput() {
		long input1 = 73323;
		long input2 = 63323;
		List<Long>test = new ArrayList<>();
		test.add(input1);
		test.add(input2);
		
		String expected = "01:13.323";
		
		assertEquals(expected, Utilities.convertLongToString(test).get(0).toString());
	}
	
	@Test
	void shouldVerifyCorrectFindMinOutput() {
		long input1 = 73323;
		long input2 = 63323;
		List<Long>test = new ArrayList<>();
		test.add(input1);
		test.add(input2);
		Long expected = 63323L;
		
		assertEquals(expected, Utilities.findMinNumber(test));
	}
	
	@Test
	void shouldVerifyCorrectfindLapTimeOutput() {
		DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		LocalTime startTime = LocalTime.from(DTF.parse("12:23:42.474"));
		LocalTime endTime = LocalTime.from(DTF.parse("12:25:08.224"));

		List<LocalTime> startTimeList = new ArrayList<>();
		List<LocalTime> endTimeList = new ArrayList<>();
		startTimeList.add(startTime);
		endTimeList.add(endTime);

		
		List<Long>expected = new ArrayList<>();
		expected.add(85750L);
		assertEquals(expected, Utilities.findLapTime(startTimeList, endTimeList));
	}

}
