package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	@Test
	void shouldVerifyCorrectMathUtilsOutput() {
		long input = 73323;
		String expected = "01:13.323";
		
		assertEquals(expected, Utilities.convertLongToTime(input).toString());
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

		
		
		assertEquals(1, Utilities.findLapTime(startTimeList, endTimeList));
	}

}
