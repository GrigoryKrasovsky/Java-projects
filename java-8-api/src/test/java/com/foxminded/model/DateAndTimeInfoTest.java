package com.foxminded.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class DateAndTimeInfoTest {

	@Test
	void shouldVerifyCorrectDateAndTimeInfoOutput() {
		
		LocalTime localTime = LocalTime.from(DateTimeFormatter.ofPattern("HH:mm:ss.SSS").parse("12:30:13.057"));
		
		LocalDate localDate = LocalDate.parse("2018-05-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		DateAndTimeInfo dateAndTimeInfo = new DateAndTimeInfo(localTime,localDate);
		String expectedTime = "12:30:13.057";
		String expectedDate = "2018-05-24";
		assertEquals(expectedTime, dateAndTimeInfo.getLocalTime().toString());
		assertEquals(expectedDate, dateAndTimeInfo.getLocalDate().toString());
	}

}
